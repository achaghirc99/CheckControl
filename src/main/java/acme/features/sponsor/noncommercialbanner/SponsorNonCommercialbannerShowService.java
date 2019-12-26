
package acme.features.sponsor.noncommercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorNonCommercialbannerShowService implements AbstractShowService<Sponsor, Noncommercialbanner> {

	//Internal state-----------------------
	@Autowired
	private SponsorNonCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercialbanner> request) {
		assert request != null;

		Boolean result = true;
		Principal principal = request.getPrincipal();
		Sponsor sponsor = this.repository.findOneSponsorById(principal.getActiveRoleId());
		if (sponsor.getCreditCard() != null) {
			result = false;
		}
		return result;

	}

	@Override
	public void unbind(final Request<Noncommercialbanner> request, final Noncommercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "optionalJingle");
		model.setAttribute("id", entity.getId());
	}

	@Override
	public Noncommercialbanner findOne(final Request<Noncommercialbanner> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		Noncommercialbanner result = this.repository.findOneNonCommercialbannerById(id);

		return result;

	}
}
