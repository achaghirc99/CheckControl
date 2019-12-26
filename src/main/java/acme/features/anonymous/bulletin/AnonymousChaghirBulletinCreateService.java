
package acme.features.anonymous.bulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.ChaghirBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousChaghirBulletinCreateService implements AbstractCreateService<Anonymous, ChaghirBulletin> {

	@Autowired
	AnonymousChaghirBulletinRepository repository;


	@Override
	public boolean authorise(final Request<ChaghirBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public ChaghirBulletin instantiate(final Request<ChaghirBulletin> request) {
		assert request != null;

		ChaghirBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new ChaghirBulletin();
		result.setName("<surname>Bulletin");
		result.setLanguages("C1 Inglish");
		result.setPhone("631102599");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<ChaghirBulletin> request, final ChaghirBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "phone", "languages");
	}

	@Override
	public void bind(final Request<ChaghirBulletin> request, final ChaghirBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}
	@Override
	public void validate(final Request<ChaghirBulletin> request, final ChaghirBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ChaghirBulletin> request, final ChaghirBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
