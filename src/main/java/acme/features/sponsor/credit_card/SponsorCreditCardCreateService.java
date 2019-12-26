
package acme.features.sponsor.credit_card;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.creditCard.CreditCard;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorCreditCardCreateService implements AbstractCreateService<Sponsor, CreditCard> {

	@Autowired
	SponsorCreditCardRepository repository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;

		Boolean result = true;
		Principal principal;
		int idUsuario;
		int id;

		principal = request.getPrincipal();
		idUsuario = principal.getActiveRoleId();
		id = request.getModel().getInteger("sponsorId");

		if (id != idUsuario) {
			result = false;
		}

		return result;
	}

	@Override
	public void bind(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<CreditCard> request, final CreditCard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int sponsorId = request.getModel().getInteger("sponsorId");
		model.setAttribute("sponsorId", sponsorId);

		request.unbind(entity, model, "name", "creditCardNumber", "cvc", "month", "year");
	}

	@Override
	public CreditCard instantiate(final Request<CreditCard> request) {
		assert request != null;

		CreditCard result;
		Integer idSponsor;
		Sponsor sponsor;

		result = new CreditCard();
		idSponsor = request.getPrincipal().getActiveRoleId();
		sponsor = this.repository.findSponsor(idSponsor);
		result.setSponsor(sponsor);

		return result;
	}

	@Override
	public void validate(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String month;
		Integer monthNumber;
		String year;
		Integer yearNumber;
		LocalDate date;
		LocalDate actualDate;
		LocalDate limitDate;

		month = entity.getMonth();
		monthNumber = Integer.parseInt(month);
		year = entity.getYear();
		yearNumber = Integer.parseInt(year);
		date = LocalDate.of(yearNumber, monthNumber, 1);
		actualDate = LocalDate.now();
		limitDate = actualDate.withDayOfMonth(1);

		boolean expiredCard = limitDate.isBefore(date);
		errors.state(request, expiredCard, "year", "error.year");

	}

	@Override
	public void create(final Request<CreditCard> request, final CreditCard entity) {
		assert request != null;
		assert entity != null;

		Integer idSponsor = request.getPrincipal().getActiveRoleId();
		Sponsor sponsor = this.repository.findSponsor(idSponsor);
		sponsor.setCreditCard(entity);

		this.repository.save(entity);
		this.repository.save(sponsor);
	}

	@Override
	public void onSuccess(final Request<CreditCard> request, final Response<CreditCard> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
