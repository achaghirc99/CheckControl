
package acme.features.administrator.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.register.Register;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorRegisterCreateService implements AbstractCreateService<Administrator, Register> {

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
	public Register instantiate(final Request<Register> request) {
		Register result;

		result = new Register();

		return result;
	}

	@Override
	public void validate(final Request<Register> request, final Register entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Register> request, final Register entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
}
