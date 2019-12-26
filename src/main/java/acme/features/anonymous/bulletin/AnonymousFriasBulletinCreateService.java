
package acme.features.anonymous.bulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.FriasBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousFriasBulletinCreateService implements AbstractCreateService<Anonymous, FriasBulletin> {

	//Internal state---------------------------------

	@Autowired
	private AnonymousFriasBulletinRepository repository;


	@Override
	public boolean authorise(final Request<FriasBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<FriasBulletin> request, final FriasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<FriasBulletin> request, final FriasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "email", "location", "text");

	}

	@Override
	public FriasBulletin instantiate(final Request<FriasBulletin> request) {
		assert request != null;
		FriasBulletin result;

		result = new FriasBulletin();

		return result;
	}

	@Override
	public void validate(final Request<FriasBulletin> request, final FriasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<FriasBulletin> request, final FriasBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
