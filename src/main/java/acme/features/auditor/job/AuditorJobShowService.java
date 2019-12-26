
package acme.features.auditor.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorJobShowService implements AbstractShowService<Auditor, Job> {

	@Autowired
	private AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "salary", "moreInfo", "description", "finalMode");
		int idDescriptor = entity.getDescriptor().getId();
		model.setAttribute("idDescriptor", idDescriptor);
		model.setAttribute("jobId", entity.getId());

		boolean isAudited;
		int jobId = entity.getId();
		int auditorId = request.getPrincipal().getActiveRoleId();
		Auditrecord a = this.repository.findManyAuditorByJobIdAndAuditorId(jobId, auditorId);
		isAudited = a == null ? false : true;
		model.setAttribute("isAudited", isAudited);

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

}
