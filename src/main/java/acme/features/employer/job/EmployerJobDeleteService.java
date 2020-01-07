
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerJobDeleteService implements AbstractDeleteService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		boolean result;
		int jobId;
		Job job;
		Employer employer;

		Principal principal;
		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);

		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "descriptor");

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "description", "moreInfo", "descriptor.description");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job job = new Job();
		int id;
		id = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(id);

		if (job.getDescriptor() != null) {
			job.getDescriptor().getDuties().size();

		}

		return job;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Collection<Application> applys = this.repository.finApplicationsByJobId(entity.getId());
		boolean checkApplys = applys.isEmpty();
		errors.state(request, checkApplys, "status", "employer.job.delete.error.application-not-null");
	}

	@Override
	public void delete(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.deleteAll(entity.getDescriptor().getDuties());
		this.repository.delete(entity.getDescriptor());
		if (entity.getPassfa() != null) {
			this.repository.delete(entity.getPassfa());
		}
		this.repository.delete(entity);

	}
}
