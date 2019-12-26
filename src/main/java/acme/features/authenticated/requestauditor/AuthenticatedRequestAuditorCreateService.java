
package acme.features.authenticated.requestauditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestauditors.RequestAuditorStatus;
import acme.entities.requestauditors.Requestauditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedRequestAuditorCreateService implements AbstractCreateService<Authenticated, Requestauditor> {

	@Autowired
	AuthenticatedRequestAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Requestauditor> request) {
		assert request != null;
		//
		//		Boolean result = true;
		//		Integer id;
		//		Collection<Requestauditor> requestauditors;
		//		Integer IdAuthenticated;
		//		Authenticated authenticated;
		//
		//		id = request.getModel().getInteger("id");
		//		requestauditors = this.repository.findRequestAuditorById(id);
		//		IdAuthenticated = request.getPrincipal().getActiveRoleId();
		//		authenticated = this.repository.findAuthenticated(IdAuthenticated);
		//
		//		for (Requestauditor r : requestauditors) {
		//			if (r.getUser() == authenticated) {
		//				result = false;
		//			}
		//		}

		return true;
	}

	@Override
	public void bind(final Request<Requestauditor> request, final Requestauditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Requestauditor> request, final Requestauditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "accepted", "user", "reference");
		model.setAttribute("idRequest", entity.getId());

		Boolean res = entity.isAccepted();
		model.setAttribute("accept", res);
	}

	@Override
	public Requestauditor instantiate(final Request<Requestauditor> request) {
		assert request != null;

		Requestauditor result;
		Principal principal;
		int authenticatedId;
		Authenticated authenticated;

		principal = request.getPrincipal();
		authenticatedId = principal.getActiveRoleId();
		authenticated = this.repository.findOneAuthenticatedById(authenticatedId);

		result = new Requestauditor();
		result.setUser(authenticated);
		result.setStatus(RequestAuditorStatus.REJECTED);
		return result;
	}

	@Override
	public void validate(final Request<Requestauditor> request, final Requestauditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Collection<Requestauditor> ls = this.repository.findAllRequestAuditorById(request.getPrincipal().getActiveRoleId());
		errors.state(request, ls.size() < 1, "reference", "authenticated.requestAuditor.error.create.moreThanOneRequest");

		String reference = entity.getReference().toString();
		String username = entity.getUser().getUserAccount().getUsername().toString();
		boolean checkReference = reference.equals(username);
		errors.state(request, checkReference, "reference", "authenticated.requestAuditor.error.create.reference");

	}

	@Override
	public void create(final Request<Requestauditor> request, final Requestauditor entity) {
		assert request != null;
		assert entity != null;

		entity.setAccepted(false);
		entity.setStatus(RequestAuditorStatus.REJECTED);
		this.repository.save(entity.getUser());
		this.repository.save(entity);
	}

}
