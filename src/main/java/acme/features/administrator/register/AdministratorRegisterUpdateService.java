
package acme.features.administrator.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.register.Register;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorRegisterUpdateService implements AbstractUpdateService<Administrator, Register> {

	@Autowired
	AdministratorRegisterRepository repository;


	@Override
	public boolean authorise(final Request<Register> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Register> request, final Register entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Register> request, final Register entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "investmentStatement", "assessment");
	}

	@Override
	public void validate(final Request<Register> request, final Register entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public Register findOne(final Request<Register> request) {
		assert request != null;

		Register result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneRegisterById(id);

		return result;
	}

	@Override
	public void update(final Request<Register> request, final Register entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
