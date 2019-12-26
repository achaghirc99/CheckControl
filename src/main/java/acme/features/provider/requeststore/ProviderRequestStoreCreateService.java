
package acme.features.provider.requeststore;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requeststores.Requeststore;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestStoreCreateService implements AbstractCreateService<Provider, Requeststore> {

	@Autowired
	ProviderRequestStoreRepository repository;


	@Override
	public boolean authorise(final Request<Requeststore> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Requeststore> request, final Requeststore entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Requeststore> request, final Requeststore entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "reward", "ticker");

	}

	@Override
	public Requeststore instantiate(final Request<Requeststore> request) {
		assert request != null;
		Requeststore requestStore = new Requeststore();
		Date moment = new Date(System.currentTimeMillis() - 1);

		requestStore.setMoment(moment);

		return requestStore;
	}

	@Override
	public void validate(final Request<Requeststore> request, final Requeststore entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean inEur;
		inEur = entity.getReward().getCurrency().equals("EUR");
		errors.state(request, inEur, "reward", "provider.RequestStore.error.must-BeEur");

		Calendar calendar;
		Date minimumDate;
		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			minimumDate = calendar.getTime();
			if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().after(minimumDate), "deadline", "provider.requestStore.error.must-BeFuture");
			}
		}

	}

	@Override
	public void create(final Request<Requeststore> request, final Requeststore entity) {
		assert request != null;
		assert entity != null;

		Date moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
