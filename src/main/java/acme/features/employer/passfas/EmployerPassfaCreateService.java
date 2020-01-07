
package acme.features.employer.passfas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.passfas.Passfa;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerPassfaCreateService implements AbstractCreateService<Employer, Passfa> {

	@Autowired
	EmployerPassfaRepository repositorty;


	@Override
	public boolean authorise(final Request<Passfa> request) {
		assert request != null;
		boolean res = false;

		Integer id = request.getModel().getInteger("id");
		Principal principal = request.getPrincipal();

		Job job = this.repositorty.getJobById(id);

		Employer e = job.getEmployer();

		res = principal.getActiveRoleId() == e.getId();

		return res;
	}

	@Override
	public void bind(final Request<Passfa> request, final Passfa entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Passfa> request, final Passfa entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "trackNumber");
		model.setAttribute("jobId", entity.getJob().getId());
	}

	@Override
	public Passfa instantiate(final Request<Passfa> request) {
		assert request != null;
		Passfa challenge = new Passfa();

		String id = request.getServletRequest().getParameter("id");
		Job job = this.repositorty.getJobById(Integer.parseInt(id));

		challenge.setJob(job);

		return challenge;
	}

	@Override
	public void validate(final Request<Passfa> request, final Passfa entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean nonHavePassfa = entity.getJob().getPassfa() == null;
		errors.state(request, nonHavePassfa, "text", "error.job.havePassfa");

	}

	@Override
	public void create(final Request<Passfa> request, final Passfa entity) {
		assert request != null;
		assert entity != null;

		String trackNumber = request.getModel().getString("trackNumber");
		if (trackNumber == "" || trackNumber == null) {
			entity.setTrackNumber(null);
		}
		this.repositorty.save(entity);

	}

}
