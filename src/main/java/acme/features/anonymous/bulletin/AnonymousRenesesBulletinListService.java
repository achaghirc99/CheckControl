
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.RenesesBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousRenesesBulletinListService implements AbstractListService<Anonymous, RenesesBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousRenesesBulletinRepository repository;


	// AbstractListService<Administrator,Shout> interface ---------------------

	@Override
	public boolean authorise(final Request<RenesesBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<RenesesBulletin> request, final RenesesBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "nationality", "moment");
	}

	@Override
	public Collection<RenesesBulletin> findMany(final Request<RenesesBulletin> request) {
		assert request != null;

		Collection<RenesesBulletin> result;

		result = this.repository.findMany();

		return result;

	}

}
