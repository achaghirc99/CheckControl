
package acme.features.authenticated.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	@Autowired
	private AuthenticatedJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;

		Principal principal;
		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);

		principal = request.getPrincipal();

		if (principal.isAuthenticated()) {
			result = true;
		} else {
			result = job.isFinalMode() || !job.isFinalMode();
		}

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "status", "descriptor.description", "deadline", "salary", "moreInfo", "finalMode", "description");
		int idDescriptor = entity.getDescriptor().getId();
		model.setAttribute("idDescriptor", idDescriptor);
		model.setAttribute("jobId", entity.getId());

		Boolean isWorker;
		isWorker = request.getPrincipal().hasRole(Worker.class);
		model.setAttribute("isWorker", isWorker);
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job job;
		int id;
		id = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(id);

		job.getDescriptor().getDuties().size();

		return job;
	}
}
