
package acme.features.authenticated.auditRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.Auditrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuditRecordsShowService implements AbstractShowService<Authenticated, Auditrecord> {

	@Autowired
	private AuthenticatedAuditRecordsRepository repository;


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

		request.unbind(entity, model, "title", "finalMode", "body", "moment");

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
