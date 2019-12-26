
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobDutyUpdateService implements AbstractUpdateService<Employer, Duty> {

	@Autowired
	EmployerJobDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		boolean res = true;
		return res;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		model.setAttribute("idDuty", entity.getId());
		request.unbind(entity, model, "dutyTitle", "description", "percentage");

		if (request.isMethod(HttpMethod.POST)) {
			request.transfer(model, "percentage");
		}

	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		int dutyId = request.getModel().getInteger("id");

		Duty duty = this.repository.findOneDutyById(dutyId);

		return duty;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		double percentage = request.getModel().getDouble("percentage");
		errors.state(request, percentage > 0.0 && percentage <= 100.0, "percentage", "employer.job.duty.update.errors.percentage");

		Collection<Duty> duties = entity.getDescriptor().getDuties();
		duties.remove(entity);
		double ac = 0.0;
		if (!errors.hasErrors("percentage")) {
			for (Duty d : duties) {
				ac = ac + d.getPercentage();
			}
			ac = ac + entity.getPercentage();
			errors.state(request, ac <= 100.00, "percentage", "employer.job.duty.update.errors.total-percentage");
		}

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getDutyTitle()), "dutyTitle", "error.spam");
		errors.state(request, entity.spam(list, entity.getDescription()), "description", "error.spam");
	}

	@Override
	public void update(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
	@Override
	public void onSuccess(final Request<Duty> request, final Response<Duty> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}
}
