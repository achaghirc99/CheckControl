
package acme.features.sponsor.commercialbanner;

import java.util.Collection;
import java.util.Collections;

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
import acme.framework.services.AbstractListService;

@Service
public class SponsorCommercialbannerListService implements AbstractListService<Sponsor, Commercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	SponsorCommercialbannerRepository repository;


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

		request.unbind(entity, model, "picture", "slogan");
	}

	@Override
	public Collection<Commercialbanner> findMany(final Request<Commercialbanner> request) {
		assert request != null;

		Collection<Commercialbanner> result;
		Principal principal = request.getPrincipal();
		Sponsor sponsor = this.repository.findOneSponsorById(principal.getActiveRoleId());
		if (sponsor.getCreditCard() != null) {
			result = this.repository.findManyByIdCommercialbanners(principal.getActiveRoleId());

		} else {
			result = Collections.emptyList();
		}
		return result;
	}

}
