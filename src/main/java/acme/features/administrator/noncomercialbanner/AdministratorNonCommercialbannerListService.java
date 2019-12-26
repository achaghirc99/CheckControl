
package acme.features.administrator.noncomercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNonCommercialbannerListService implements AbstractListService<Administrator, Noncommercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorNonCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercialbanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Noncommercialbanner> request, final Noncommercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "optionalJingle");
	}

	@Override
	public Collection<Noncommercialbanner> findMany(final Request<Noncommercialbanner> request) {
		assert request != null;

		Collection<Noncommercialbanner> result = this.repository.findAllNonCommercialbanners();

		return result;
	}

}
