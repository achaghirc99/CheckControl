
package acme.features.employer.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;

		Principal principal;
		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);

		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = job.isFinalMode() || !job.isFinalMode() && employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "status", "deadline", "salary", "moreInfo", "finalMode", "description");
		model.setAttribute("jobId", entity.getId());
		if (entity.getDescriptor() != null) {
			Collection<Duty> duties = entity.getDescriptor().getDuties();
			List<Duty> listaDuties = new ArrayList<Duty>();
			listaDuties.addAll(duties);
			request.unbind(entity, model, "descriptor.description");
			int IdDescriptor = entity.getDescriptor().getId();
			model.setAttribute("idDescriptor", IdDescriptor);
		}
		boolean haveChallenge = entity.getChallenge() != null;
		model.setAttribute("haveChallenge", haveChallenge);
		if (haveChallenge) {
			if (entity.getChallenge().getText() != null || entity.getChallenge().getMoreInfo() != "") {
				boolean haveTextChallenge = entity.getChallenge().getText() != null || entity.getChallenge().getText() != "";
				model.setAttribute("textChallenge", haveTextChallenge);
				request.unbind(entity, model, "challenge.text");
			}
			if (entity.getChallenge().getMoreInfo() != null) {
				boolean haveMoreInfoChallenge = entity.getChallenge().getMoreInfo() != null;
				model.setAttribute("moreInfoChallenge", haveMoreInfoChallenge);
				request.unbind(entity, model, "challenge.moreInfo");
			}
		}
		/**
		 * Con el fin de mostrar la opcion de actualizar solo para aquellos trabajos que esten en finalMode == true, se aplica en form.jsp
		 */
		model.setAttribute("finalMode", entity.isFinalMode());

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job job;
		int id;
		id = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(id);

		if (job.getDescriptor() != null) {
			job.getDescriptor().getDuties().size();

		}

		return job;
	}
}
