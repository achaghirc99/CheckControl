
package acme.features.sponsor.noncommercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.entities.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class SponsorNonCommercialbannerListService implements AbstractListService<Sponsor, Noncommercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	SponsorNonCommercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercialbanner> request) {
		assert request != null;

		Boolean result = true;
		Principal principal = request.getPrincipal();
		Sponsor sponsor = this.repository.findOneSponsorById(principal.getActiveRoleId());

		int idUserAccount = request.getPrincipal().getAccountId();
		UserAccount ua = this.repository.findUserccount(idUserAccount);
		Collection<UserRole> roles = ua.getRoles();
		Administrator a = this.repository.findAdministrator(idUserAccount);

		if (sponsor.getCreditCard() != null) {
			result = false;
		}
		if (roles.contains(a)) {
			result = true;
		}

		return result;

	}

	@Override
	public void unbind(final Request<Noncommercialbanner> request, final Noncommercialbanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan");
	}

	@Override
	public Collection<Noncommercialbanner> findMany(final Request<Noncommercialbanner> request) {

		Collection<Noncommercialbanner> result;
		Principal principal = request.getPrincipal();
		result = this.repository.findManyByIdNonCommercialbanners(principal.getActiveRoleId());
		return result;
	}

}
