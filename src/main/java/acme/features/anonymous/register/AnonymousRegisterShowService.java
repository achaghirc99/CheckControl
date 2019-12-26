
package acme.features.anonymous.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.register.Register;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousRegisterShowService implements AbstractShowService<Anonymous, Register> {

	@Autowired
	private AnonymousRegisterRepository repository;


	@Override
	public boolean authorise(final Request<Register> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Register> request, final Register entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "investmentStatement", "assessment");

	}

	@Override
	public Register findOne(final Request<Register> request) {
		assert request != null;

		Register result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
