
package acme.features.authenticated.register;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.register.Register;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRegisterListService implements AbstractListService<Authenticated, Register> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedRegisterRepository repository;


	// AbstractListService<Authenticated, Register> interface --------------

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
	public Collection<Register> findMany(final Request<Register> request) {
		assert request != null;

		Collection<Register> result;

		result = this.repository.findManyAll();

		return result;
	}

}
