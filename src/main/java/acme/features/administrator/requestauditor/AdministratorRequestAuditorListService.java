
package acme.features.administrator.requestauditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestauditors.Requestauditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorRequestAuditorListService implements AbstractListService<Administrator, Requestauditor> {

	@Autowired
	AdministratorRequestAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Requestauditor> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Requestauditor> request, final Requestauditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "accepted", "reference", "status");

	}

	@Override
	public Collection<Requestauditor> findMany(final Request<Requestauditor> request) {
		assert request != null;

		Collection<Requestauditor> result;

		result = this.repository.findAllRequestAuditor();

		return result;
	}

}
