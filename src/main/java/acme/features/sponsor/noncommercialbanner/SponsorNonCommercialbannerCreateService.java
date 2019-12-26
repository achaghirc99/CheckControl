
package acme.features.sponsor.noncommercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorNonCommercialbannerCreateService implements AbstractCreateService<Sponsor, Noncommercialbanner> {

	@Autowired
	SponsorNonCommercialbannerRepository repository;


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

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "optionalJingle", "sponsor");

	}

	@Override
	public Noncommercialbanner instantiate(final Request<Noncommercialbanner> request) {
		assert request != null;
		Noncommercialbanner nonCommercialBanner = new Noncommercialbanner();
		Principal principal = request.getPrincipal();
		int idPrincipal = principal.getActiveRoleId();

		Sponsor sponsor = this.repository.findOneSponsorById(idPrincipal);

		nonCommercialBanner.setSponsor(sponsor);
		return nonCommercialBanner;
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
	public void create(final Request<Noncommercialbanner> request, final Noncommercialbanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
