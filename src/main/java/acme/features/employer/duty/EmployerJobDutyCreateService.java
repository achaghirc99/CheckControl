
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Descriptor;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobDutyCreateService implements AbstractCreateService<Employer, Duty> {

	@Autowired
	EmployerJobDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		String descriptorId = request.getServletRequest().getParameter("idDescriptor");
		model.setAttribute("idDescriptor", descriptorId);
		request.unbind(entity, model, "dutyTitle", "description", "percentage");

	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public Duty instantiate(final Request<Duty> request) {
		assert request != null;
		Duty duty = new Duty();
		String descriptorId = request.getServletRequest().getParameter("idDescriptor");
		Descriptor descriptor = this.repository.findOneDescriptorById(Integer.parseInt(descriptorId));
		duty.setDescriptor(descriptor);

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
			if (duties.size() != 0) {
				for (Duty d : duties) {
					ac = ac + d.getPercentage();
				}
			}
			ac = ac + entity.getPercentage();
			errors.state(request, ac <= 100.00, "percentage", "employer.job.duty.update.errors.total-percentage");
		}

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getDutyTitle()), "dutyTitle", "error.spam");
		errors.state(request, entity.spam(list, entity.getDescription()), "description", "error.spam");
	}

	@Override
	public void create(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
