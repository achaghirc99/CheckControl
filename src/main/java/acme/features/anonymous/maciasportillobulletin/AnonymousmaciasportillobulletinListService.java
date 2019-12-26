
package acme.features.anonymous.maciasportillobulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.maciasportillobulletins.maciasportillobulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousmaciasportillobulletinListService implements AbstractListService<Anonymous, maciasportillobulletin> {

	//Internal state ---------------------------------------------------
	@Autowired
	AnonymousmaciasportillobulletinRepository repository;


	//AbstractListService<Anonymous, Bulletin> interface-------------------------------------------

	@Override
	public boolean authorise(final Request<maciasportillobulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<maciasportillobulletin> findMany(final Request<maciasportillobulletin> request) {
		assert request != null;

		Collection<maciasportillobulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<maciasportillobulletin> request, final maciasportillobulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "hobbies", "city", "moment");
	}
}
