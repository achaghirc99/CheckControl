
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.ChaghirBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousChaghirBulletinListService implements AbstractListService<Anonymous, ChaghirBulletin> {

	//Internal State ---------------------------------------------

	@Autowired
	AnonymousChaghirBulletinRepository repository;


	//AbstractListService<Anonymous,Bulletin> interface ------------------

	@Override
	public boolean authorise(final Request<ChaghirBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<ChaghirBulletin> findMany(final Request<ChaghirBulletin> request) {
		assert request != null;

		Collection<ChaghirBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<ChaghirBulletin> request, final ChaghirBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "languages", "phone", "moment");
	}

}
