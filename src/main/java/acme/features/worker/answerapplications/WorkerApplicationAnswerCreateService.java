
package acme.features.worker.answerapplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answers.Answer;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationAnswerCreateService implements AbstractCreateService<Worker, Answer> {

	@Autowired
	WorkerApplicationsAnswerRepository repository;


	@Override
	public boolean authorise(final Request<Answer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Answer> request, final Answer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "application");

	}

	@Override
	public void unbind(final Request<Answer> request, final Answer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "answer", "optional");
		model.setAttribute("applicationId", entity.getApplication().getId());

	}

	@Override
	public Answer instantiate(final Request<Answer> request) {
		assert request != null;
		Answer answer = new Answer();

		String id = request.getServletRequest().getParameter("id");
		Application application = this.repository.getApplicationById(Integer.parseInt(id));

		answer.setApplication(application);

		return answer;
	}

	@Override
	public void validate(final Request<Answer> request, final Answer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Answer> request, final Answer entity) {
		assert request != null;
		assert entity != null;

		String optional = request.getModel().getString("optional");
		if (optional == "" || optional == null) {
			entity.setOptional(null);
		}

		this.repository.save(entity);

	}

}
