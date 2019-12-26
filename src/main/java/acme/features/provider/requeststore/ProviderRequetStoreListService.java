
package acme.features.provider.requeststore;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requeststores.Requeststore;
import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ProviderRequetStoreListService implements AbstractListService<Provider, Requeststore> {

	@Autowired
	ProviderRequestStoreRepository repository;


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

		request.unbind(entity, model, "title", "moment", "deadline", "ticker");

	}

	@Override
	public Collection<Requeststore> findMany(final Request<Requeststore> request) {
		assert request != null;

		Collection<Requeststore> requestStore;
		requestStore = this.repository.findManyAll();
		return requestStore;
	}

}
