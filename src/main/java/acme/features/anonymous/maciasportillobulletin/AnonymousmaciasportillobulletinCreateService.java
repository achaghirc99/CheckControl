
package acme.features.anonymous.maciasportillobulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.maciasportillobulletins.maciasportillobulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousmaciasportillobulletinCreateService implements AbstractCreateService<Anonymous, maciasportillobulletin> {

	//Internat state -----------------------------------------

	@Autowired
	AnonymousmaciasportillobulletinRepository repository;


	@Override
	public boolean authorise(final Request<maciasportillobulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public maciasportillobulletin instantiate(final Request<maciasportillobulletin> request) {
		assert request != null;

		maciasportillobulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new maciasportillobulletin();

		result.setMoment(moment);

		return result;

	}

	@Override
	public void unbind(final Request<maciasportillobulletin> request, final maciasportillobulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "hobbies", "city");
	}

	@Override
	public void bind(final Request<maciasportillobulletin> request, final maciasportillobulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<maciasportillobulletin> request, final maciasportillobulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<maciasportillobulletin> request, final maciasportillobulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
