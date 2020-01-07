
package acme.features.employer.jobChallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobchallenges.Jobchallenge;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobChallengeCreateService implements AbstractCreateService<Employer, Jobchallenge> {

	@Autowired
	EmployerJobChallengeRepository repositorty;


	@Override
	public boolean authorise(final Request<Jobchallenge> request) {
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
	public void bind(final Request<Jobchallenge> request, final Jobchallenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Jobchallenge> request, final Jobchallenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo", "xxx4.password");
		model.setAttribute("jobId", entity.getJob().getId());
	}

	@Override
	public Jobchallenge instantiate(final Request<Jobchallenge> request) {
		assert request != null;
		Jobchallenge challenge = new Jobchallenge();

		String id = request.getServletRequest().getParameter("id");
		Job job = this.repositorty.getJobById(Integer.parseInt(id));

		challenge.setJob(job);

		return challenge;
	}

	@Override
	public void validate(final Request<Jobchallenge> request, final Jobchallenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean nonHaveChallenge = entity.getJob().getChallenge() == null;
		errors.state(request, nonHaveChallenge, "text", "error.job.haveChallenge");

	}

	@Override
	public void create(final Request<Jobchallenge> request, final Jobchallenge entity) {
		assert request != null;
		assert entity != null;

		String moreInfo = request.getModel().getString("moreInfo");
		if (moreInfo == "" || moreInfo == null) {
			entity.setMoreInfo(null);
		}
		this.repositorty.save(entity.getXxx4());
		this.repositorty.save(entity);

	}

}
