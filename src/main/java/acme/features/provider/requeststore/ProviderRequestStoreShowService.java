
package acme.features.provider.requeststore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requeststores.Requeststore;
import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class ProviderRequestStoreShowService implements AbstractShowService<Provider, Requeststore> {

	@Autowired
	private ProviderRequestStoreRepository repository;


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

		request.unbind(request, model, "title", "moment", "deadline", "text", "ticker", "reward");
		;
	}

	@Override
	public Requeststore findOne(final Request<Requeststore> request) {
		assert request != null;

		Requeststore requestStore;
		int id;

		id = request.getModel().getInteger("id");
		requestStore = this.repository.findOneRequest(id);

		return requestStore;
	}

}
