
package acme.features.auditor.auditRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorAuditRecordsShowService implements AbstractShowService<Auditor, Auditrecord> {

	@Autowired
	private AuditorAuditRecordsRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		assert request != null;

		boolean result;
		Auditrecord auditrecord;
		int auditrecordId;
		Auditor auditor;
		Principal principal;

		auditrecordId = request.getModel().getInteger("id");
		auditrecord = this.repository.findOneAuditRecordById(auditrecordId);
		auditor = auditrecord.getAuditor();
		principal = request.getPrincipal();
		result = auditrecord.isFinalMode() || !auditrecord.isFinalMode() && auditor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "status", "body", "moment");

	}

	@Override
	public Auditrecord findOne(final Request<Auditrecord> request) {
		assert request != null;
		Auditrecord auditrecord;
		int id;
		id = request.getModel().getInteger("id");
		auditrecord = this.repository.findOneAuditRecordById(id);

		return auditrecord;
	}
}
