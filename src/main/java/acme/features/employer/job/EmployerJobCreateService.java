
package acme.features.employer.job;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.jobs.JobStatus;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "descriptor", "challenge");

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "description", "moreInfo", "descriptor.description", "finalMode");

	}

	@Override
	public Job instantiate(final Request<Job> request) {
		assert request != null;
		Job job = new Job();
		Employer employer;
		Principal principal;
		principal = request.getPrincipal();
		employer = this.repository.findEmployerById(principal.getActiveRoleId());
		job.setEmployer(employer);

		return job;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		/** Validacion para la FECHA de un Job a la hora de crearlo */
		Calendar calendar;
		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			long minimumDate = calendar.getTimeInMillis() + 604800000L;

			if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().getTime() >= minimumDate, "deadline", "employer.job.update.errors.deadline");
			}
		}

		/**
		 * A job cannot be saved in final mode
		 * unless it has a descriptor, the duties sum up to 100% the weekly workload
		 */
		boolean finalMode = request.getModel().getBoolean("finalMode");
		if (entity.getDescriptor() != null && entity.getDescriptor().getDuties() != null) {
			Double dutypercentage = entity.getDescriptor().getDuties().stream().mapToDouble(Duty::getPercentage).sum();
			errors.state(request, finalMode == true && dutypercentage == 100.00, "finalMode", "employer.job.create.error-descriptor-duties.finalMode");
		}
		boolean checkDuties = entity.getDescriptor().getDuties() == null;

		if (finalMode == false) {
			errors.state(request, checkDuties == true, "finalMode", "employer.job.create.error.duties-is-empty");

		} else {
			errors.state(request, checkDuties == false, "finalMode", "employer.job.create.error.duties-is-empty");
		}

		/**
		 * Validate that the job it’s not considered spam
		 * A job it's considered spam if it contains any spam word
		 */
		if (entity.isFinalMode()) {
			Spamlist list = this.repository.findSpamlist();

			errors.state(request, entity.spam(list, entity.getTitle()), "title", "error.spam");
			errors.state(request, entity.spam(list, entity.getDescription()), "description", "error.spam");
			errors.state(request, entity.spam(list, entity.getDescriptor().getDescription()), "descriptor.description", "error.spam");
		}
	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		//Inject the employer that create the job

		String description = request.getModel().getString("descriptor.description");

		if (description == "" || description == null) {
			entity.setDescriptor(null);
		} else {
			Descriptor newDescriptor = new Descriptor();
			newDescriptor.setDescription(description);
			entity.setDescriptor(newDescriptor);
			this.repository.save(newDescriptor);

		}

		String textChallenge = request.getModel().getString("challenge.text");
		if (textChallenge == "" || textChallenge == null) {
			entity.setChallenge(null);
		}

		boolean finalMode = request.getModel().getBoolean("finalMode");

		if (finalMode == true) {
			entity.setStatus(JobStatus.PUBLISHED);
			this.repository.save(entity);
		} else {
			entity.setStatus(JobStatus.DRAFTED);
			this.repository.save(entity);
		}

		//	this.repository.save(entity);

	}

}
