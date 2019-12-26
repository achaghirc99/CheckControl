
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.FriasBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousFriasBulletinListService implements AbstractListService<Anonymous, FriasBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousFriasBulletinRepository repository;


	// AbstractListService<Administrator,Bulletin> interface ---------------------

	@Override
	public boolean authorise(final Request<FriasBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<FriasBulletin> request, final FriasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "email", "location", "text");
	}

	@Override
	public Collection<FriasBulletin> findMany(final Request<FriasBulletin> request) {
		assert request != null;

		Collection<FriasBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}
