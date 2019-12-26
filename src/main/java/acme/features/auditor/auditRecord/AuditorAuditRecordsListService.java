
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorAuditRecordsListService implements AbstractListService<Auditor, Auditrecord> {

	@Autowired
	AuditorAuditRecordsRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body");
	}

	@Override
	public Collection<Auditrecord> findMany(final Request<Auditrecord> request) {
		assert request != null;

		Collection<Auditrecord> result;

		String jobId = request.getServletRequest().getParameter("id");
		Principal principal = request.getPrincipal();
		int idPrincipal = principal.getActiveRoleId();
		result = this.repository.findManyByJobId(Integer.parseInt(jobId), idPrincipal);

		return result;
	}

}
