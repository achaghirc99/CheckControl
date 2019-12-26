
package acme.features.sponsor.commercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class SponsorCommercialbannerDeleteService implements AbstractDeleteService<Sponsor, Commercialbanner> {

	@Autowired
	SponsorCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercialbanner> request) {
		assert request != null;
		boolean authorise;

		Principal principal = request.getPrincipal();
		int idCommercialBanner = request.getModel().getInteger("id");
		Commercialbanner cb = this.repository.findOneCommercialbannerById(idCommercialBanner);

		authorise = cb.getSponsor().getId() == principal.getActiveRoleId();

		return authorise;

	}

	@Override
	public void bind(final Request<Commercialbanner> request, final Commercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

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
	public Commercialbanner findOne(final Request<Commercialbanner> request) {
		assert request != null;
		Commercialbanner resutl;

		int idCommercialBanner = request.getModel().getInteger("id");
		resutl = this.repository.findOneCommercialbannerById(idCommercialBanner);

		return resutl;

	}

	@Override
	public void validate(final Request<Commercialbanner> request, final Commercialbanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Commercialbanner> request, final Commercialbanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
