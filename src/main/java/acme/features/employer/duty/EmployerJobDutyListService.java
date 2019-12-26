
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EmployerJobDutyListService implements AbstractListService<Employer, Duty> {

	@Autowired
	EmployerJobDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		boolean authorise;

		Principal principal = request.getPrincipal();
		int idEmployer = principal.getActiveRoleId();
		int idDescriptor = request.getModel().getInteger("idDescriptor");
		Collection<Job> job = this.repository.findManyJobsByEmployerId(idEmployer, idDescriptor);

		authorise = !job.isEmpty();

		return authorise;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "dutyTitle", "description", "percentage");

	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		assert request != null;
		String idDescriptor = request.getServletRequest().getParameter("idDescriptor");
		Collection<Duty> dutys = this.repository.findManyDutiesByDescriptorId(Integer.parseInt(idDescriptor));

		return dutys;
	}

}
