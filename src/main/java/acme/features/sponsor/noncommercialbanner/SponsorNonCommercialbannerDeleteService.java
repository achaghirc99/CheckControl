
package acme.features.sponsor.noncommercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class SponsorNonCommercialbannerDeleteService implements AbstractDeleteService<Sponsor, Noncommercialbanner> {

	@Autowired
	SponsorNonCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercialbanner> request) {
		assert request != null;
		boolean authorise;

		Principal principal = request.getPrincipal();
		int idNonCommercialBanner = request.getModel().getInteger("id");
		Noncommercialbanner cb = this.repository.findOneNonCommercialbannerById(idNonCommercialBanner);

		authorise = cb.getSponsor().getId() == principal.getActiveRoleId();

		return authorise;
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

	}

	@Override
	public void delete(final Request<Noncommercialbanner> request, final Noncommercialbanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
