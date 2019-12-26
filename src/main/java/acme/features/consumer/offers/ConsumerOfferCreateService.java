
package acme.features.consumer.offers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	//Internal state-------------------------------
	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("beCareful", false);
		model.setAttribute("deadlineDate", entity.getDeadline());
		request.unbind(entity, model, "ticker", "title", "moment", "deadline", "text", "reward", "beCareful");

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		assert request != null;
		Offer offer;
		offer = new Offer();
		return offer;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean beCareful;
		beCareful = request.getModel().getBoolean("beCareful");
		errors.state(request, beCareful, "beCareful", "consumer.offer.error.must-beCareful");

		Boolean reward;
		reward = entity.getReward().getCurrency().equals("EUR");
		errors.state(request, reward, "reward", "consumer.offer.error.must-beEUR");

		Calendar calendar;
		Date minimumDeadline;
		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			minimumDeadline = calendar.getTime();
			if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "consumer.offer.error.must-beFuture");
			}
		}
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		assert request != null;
		assert entity != null;

		Date moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
