
package acme.features.administrator.commercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialbanners.Commercialbanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCommercialbannerShowService implements AbstractShowService<Administrator, Commercialbanner> {

	//Internal state-----------------------
	@Autowired
	private AdministratorCommercialbannerRepository repository;


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

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");

	}

	@Override
	public Commercialbanner findOne(final Request<Commercialbanner> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		Commercialbanner result = this.repository.findOneCommercialbannerById(id);

		return result;
	}

}
