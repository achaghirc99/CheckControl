
package acme.features.sponsor.commercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.entities.UserRole;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorCommercialbannerShowService implements AbstractShowService<Sponsor, Commercialbanner> {

	//Internal state-----------------------
	@Autowired
	private SponsorCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercialbanner> request) {
		assert request != null;

		Boolean result = true;
		Principal principal = request.getPrincipal();
		Sponsor sponsor = this.repository.findOneSponsorById(principal.getActiveRoleId());

		int idUserAccount = request.getPrincipal().getAccountId();
		UserAccount ua = this.repository.findUserccount(idUserAccount);
		Collection<UserRole> roles = ua.getRoles();
		Administrator a = this.repository.findAdministrator(idUserAccount);

		if (sponsor.getCreditCard() == null) {
			result = false;
		}
		if (roles.contains(a)) {
			result = true;
		}
		return result;

	}

	@Override
	public void unbind(final Request<Commercialbanner> request, final Commercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");
		model.setAttribute("idCommercialBanner", entity.getId());
	}

	@Override
	public Commercialbanner findOne(final Request<Commercialbanner> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		Commercialbanner result = this.repository.findOneCommercialbannerById(id);

		return result;
	}

}
