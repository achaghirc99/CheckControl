
package acme.features.administrator.commercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialbanners.Commercialbanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorCommercialbannerListService implements AbstractListService<Administrator, Commercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercialbanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Commercialbanner> request, final Commercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan");
	}

	@Override
	public Collection<Commercialbanner> findMany(final Request<Commercialbanner> request) {
		assert request != null;

		Collection<Commercialbanner> result = this.repository.findAllCommercialbanners();

		return result;
	}

}
