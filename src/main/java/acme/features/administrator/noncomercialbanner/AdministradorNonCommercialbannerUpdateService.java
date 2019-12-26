
package acme.features.administrator.noncomercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministradorNonCommercialbannerUpdateService implements AbstractUpdateService<Administrator, Noncommercialbanner> {

	@Autowired
	AdministratorNonCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercialbanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Noncommercialbanner> request, final Noncommercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
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

	@Override
	public void validate(final Request<Noncommercialbanner> request, final Noncommercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getSlogan()), "slogan", "error.spam");
	}

	@Override
	public void update(final Request<Noncommercialbanner> request, final Noncommercialbanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
