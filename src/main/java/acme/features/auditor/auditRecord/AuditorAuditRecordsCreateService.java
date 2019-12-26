
package acme.features.auditor.auditRecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.auditRecords.Auditrecordstatus;
import acme.entities.jobs.Job;
import acme.entities.jobs.JobStatus;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class AuditorAuditRecordsCreateService implements AbstractCreateService<Auditor, Auditrecord> {

	@Autowired
	AuditorAuditRecordsRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		boolean res = false;
		assert request != null;
		Job job;

		String jobid = request.getServletRequest().getParameter("id");
		job = this.repository.findOneJobById(Integer.parseInt(jobid));
		if (job.getStatus().equals(JobStatus.PUBLISHED)) {
			res = true;
		}
		return res;
	}

	@Override
	public Auditrecord instantiate(final Request<Auditrecord> request) {
		assert request != null;
		Auditrecord result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new Auditrecord();
		result.setMoment(moment);

		Integer id = request.getPrincipal().getActiveRoleId();
		Auditor auditor = this.repository.findOneAuditorById(id);
		result.setAuditor(auditor);

		String jobid = request.getServletRequest().getParameter("id");
		Job job = this.repository.findOneJobById(Integer.parseInt(jobid));
		result.setJob(job);

		result.setStatus(Auditrecordstatus.PUBLISHED);

		return result;
	}

	@Override
	public void bind(final Request<Auditrecord> request, final Auditrecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "status");
		model.setAttribute("id", request.getServletRequest().getParameter("id"));
	}

	@Override
	public void validate(final Request<Auditrecord> request, final Auditrecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Auditrecord> request, final Auditrecord entity) {
		assert request != null;
		assert entity != null;

		String jobid = request.getServletRequest().getParameter("id");
		Job job = this.repository.findOneJobById(Integer.parseInt(jobid));
		entity.setJob(job);
		this.repository.save(entity);

		//		Date moment;
		//
		//		moment = new Date(System.currentTimeMillis() - 1);
		//		entity.setMoment(moment);
		//		this.repository.save(entity);

		//		boolean finalMode = request.getModel().getBoolean("finalMode");
		//
		//		if (finalMode == true) {
		//			entity.setStatus(Auditrecordstatus.PUBLISHED);
		//			this.repository.save(entity);
		//		} else {
		//			entity.setStatus(Auditrecordstatus.DRAFT);
		//			this.repository.save(entity);
		//		}
	}

}
