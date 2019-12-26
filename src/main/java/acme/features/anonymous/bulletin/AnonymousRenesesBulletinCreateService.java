
package acme.features.anonymous.bulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.RenesesBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousRenesesBulletinCreateService implements AbstractCreateService<Anonymous, RenesesBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousRenesesBulletinRepository repository;


	@Override
	public boolean authorise(final Request<RenesesBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<RenesesBulletin> request, final RenesesBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<RenesesBulletin> request, final RenesesBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "nationality");

	}

	@Override
	public RenesesBulletin instantiate(final Request<RenesesBulletin> request) {
		assert request != null;
		RenesesBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new RenesesBulletin();

		result.setMoment(moment);
		return result;
	}

	@Override
	public void validate(final Request<RenesesBulletin> request, final RenesesBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<RenesesBulletin> request, final RenesesBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
