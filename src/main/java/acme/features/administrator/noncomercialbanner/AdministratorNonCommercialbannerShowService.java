
package acme.features.administrator.noncomercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorNonCommercialbannerShowService implements AbstractShowService<Administrator, Noncommercialbanner> {

	@Autowired
	private AdministratorNonCommercialbannerRepository repository;


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
	public Noncommercialbanner findOne(final Request<Noncommercialbanner> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		Noncommercialbanner result = this.repository.findOneNonCommercialbannerById(id);

		return result;
	}

}
