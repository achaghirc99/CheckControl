
package acme.features.employer.job;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Job;
import acme.entities.jobs.JobStatus;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		boolean res = false;

		Principal principal;
		principal = request.getPrincipal();
		int jobId = request.getModel().getInteger("id");
		Job job = this.repository.findOneJobById(jobId);

		res = job.getEmployer().getUserAccount().getId() == principal.getAccountId();

		return res;
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

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "description", "moreInfo", "finalMode", "descriptor.description");

		if (request.isMethod(HttpMethod.POST)) {
			request.transfer(model, "status");
			request.transfer(model, "deadline");
			request.transfer(model, "finalMode");
		}

		if (entity.getChallenge() != null) {
			model.setAttribute("textChallenge", entity.getChallenge().getText());
			request.unbind(entity, model, "challenge.text", "challenge.moreInfo");
		}
		if (entity.getChallenge().getMoreInfo() != "" || entity.getChallenge().getMoreInfo() != null) {
			model.setAttribute("moreInfoChallenge", entity.getChallenge().getMoreInfo());
		}
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		/* Validacion para la FECHA de un Job a la hora de editarlo */
		Calendar calendar;
		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			long minimumDate = calendar.getTimeInMillis() + 604800000L;

			if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().getTime() >= minimumDate, "deadline", "employer.job.update.errors.deadline");
			}
		}
		/* Validacion para EL SALARIO de un Job a la hora de editarlo */

		if (!errors.hasErrors("salary.currency")) {
			boolean checkCurrency = entity.getSalary().getCurrency().equals("€") || entity.getSalary().getCurrency().equals("$") || entity.getSalary().getCurrency().equals("EUR") || entity.getSalary().getCurrency().equals("USD");
			errors.state(request, checkCurrency, "salary.currency", "employer.job.update.errors.salary.currency");
		}

		/* Validacion para EL porcentaje de las duties de un Job a la hora de editarlo */

		List<Duty> duties = entity.getDescriptor().getDuties().stream().collect(Collectors.toList());
		double ac = 0.0;
		for (Duty d : duties) {
			ac = ac + d.getPercentage();
		}
		errors.state(request, ac <= 100.00, "duty.percentage", "employer.job.duty.update.errors.percentage");

		/**
		 * Validacion del final Mode
		 * - Para que el finalMode pueda ser true y estar publicado el Job
		 * es necesario que tenga un descriptor, que la suma de las duties sea del 100%
		 * y que no sea considerado spam.
		 *
		 */
		boolean checkDescriptor = entity.getDescriptor() == null;
		errors.state(request, !checkDescriptor, "finalMode", "employer.job.create.error.descriptor-is-empty");

		boolean finalMode = entity.isFinalMode();
		boolean checkDutiesEmpty = entity.getDescriptor().getDuties().isEmpty();

		if (!errors.hasErrors("finalMode") && finalMode == true && checkDutiesEmpty) {
			errors.state(request, !checkDutiesEmpty, "finalMode", "employer.job.create.error.duties-is-empty");

		} else if (!errors.hasErrors("finalMode") && finalMode == true && !checkDutiesEmpty) {
			Double dutypercentage = entity.getDescriptor().getDuties().stream().mapToDouble(Duty::getPercentage).sum();
			errors.state(request, dutypercentage == 100.00, "finalMode", "employer.job.create.error-descriptor-duties.finalMode");

		}

		/**
		 * Validate that the job it’s not considered spam
		 * A job it's considered spam if it contains any spam word
		 */

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getTitle()), "title", "error.spam");
		errors.state(request, entity.spam(list, entity.getDescription()), "description", "error.spam");
		errors.state(request, entity.spam(list, entity.getDescriptor().getDescription()), "descriptor.description", "error.spam");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job job = new Job();

		int jobId = request.getModel().getInteger("id");

		job = this.repository.findOneJobById(jobId);
		job.getDescriptor().getDuties().size();
		return job;
	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		boolean finalMode = entity.isFinalMode();

		if (finalMode) {
			entity.setStatus(JobStatus.PUBLISHED);
			this.repository.save(entity);
		} else {
			entity.setStatus(JobStatus.DRAFTED);
		}

		this.repository.save(entity);
		this.repository.save(entity.getChallenge());
		this.repository.save(entity.getDescriptor());

		for (Duty d : entity.getDescriptor().getDuties()) {
			this.repository.save(d);
		}

	}

	@Override
	public void onSuccess(final Request<Job> request, final Response<Job> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
