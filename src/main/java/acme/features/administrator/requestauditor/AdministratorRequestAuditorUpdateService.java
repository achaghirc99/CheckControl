
package acme.features.administrator.requestauditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestauditors.RequestAuditorStatus;
import acme.entities.requestauditors.Requestauditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorRequestAuditorUpdateService implements AbstractUpdateService<Administrator, Requestauditor> {

	@Autowired
	AdministratorRequestAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Requestauditor> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Requestauditor> request, final Requestauditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "user");

	}

	@Override
	public void unbind(final Request<Requestauditor> request, final Requestauditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "accepted", "reference", "status");

	}

	@Override
	public Requestauditor findOne(final Request<Requestauditor> request) {
		assert request != null;

		Requestauditor result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Requestauditor> request, final Requestauditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Requestauditor> request, final Requestauditor entity) {
		assert request != null;
		assert entity != null;

		if (entity.isAccepted()) {
			entity.setStatus(RequestAuditorStatus.ACCEPTED);
		} else {
			entity.setStatus(RequestAuditorStatus.REJECTED);
		}
		this.repository.save(entity);
	}

}
