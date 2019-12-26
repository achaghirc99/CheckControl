
package acme.features.authenticated.requeststore;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requeststores.Requeststore;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, Requeststore> {

	//Internal state-----------------------------------------------------
	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final Request<Requeststore> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Requeststore> request, final Requeststore entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text", "reward", "ticker");

	}

	@Override
	public Collection<Requeststore> findMany(final Request<Requeststore> request) {
		assert request != null;

		Collection<Requeststore> result;

		result = this.repository.findManyAll();

		return result;
	}

}
