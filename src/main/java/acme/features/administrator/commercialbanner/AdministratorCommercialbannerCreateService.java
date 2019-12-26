
package acme.features.administrator.commercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorCommercialbannerCreateService implements AbstractCreateService<Administrator, Commercialbanner> {

	@Autowired
	AdministratorCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercialbanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Commercialbanner> request, final Commercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert entity != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Commercialbanner> request, final Commercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");
	}

	@Override
	public Commercialbanner instantiate(final Request<Commercialbanner> request) {
		Commercialbanner result = new Commercialbanner();
		return result;
	}

	@Override
	public void validate(final Request<Commercialbanner> request, final Commercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getSlogan()), "slogan", "error.spam");
	}

	@Override
	public void create(final Request<Commercialbanner> request, final Commercialbanner entity) {
		this.repository.save(entity);
	}
}
