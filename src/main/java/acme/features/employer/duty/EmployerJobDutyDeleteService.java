
package acme.features.employer.duty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerJobDutyDeleteService implements AbstractDeleteService<Employer, Duty> {

	@Autowired
	EmployerJobDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		boolean authorise;
		Principal principal;
		List<Job> job;
		int idDuty = request.getModel().getInteger("id");
		Duty duty = this.repository.findOneDutyById(idDuty);
		principal = request.getPrincipal();
		int idDescriptor = duty.getDescriptor().getId();
		int idEmployer = principal.getActiveRoleId();

		job = this.repository.findManyJobsByEmployerId(idEmployer, idDescriptor);

		authorise = !job.isEmpty();

		return authorise;
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

		request.unbind(entity, model, "dutyTitle", "description", "percentage");

	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;
		Duty duty = new Duty();

		int id = request.getModel().getInteger("id");
		duty = this.repository.findOneDutyById(id);

		return duty;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
