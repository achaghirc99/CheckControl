
package acme.features.worker.workerapplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerapplicationsShowService implements AbstractShowService<Worker, Application> {

	@Autowired
	private WorkerapplicationsRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		boolean res = false;
		int applicationId;
		Application application;
		Worker worker;
		Principal principal;
		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneWorkerapplicationById(applicationId);
		worker = application.getWorker();
		principal = request.getPrincipal();
		res = worker.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "justification", "password");

		model.setAttribute("applicationId", entity.getId());
		boolean haveAnswer = entity.getAnswer() != null;
		model.setAttribute("haveAnswer", haveAnswer);
		boolean havePassword = entity.getPassword() != null;
		model.setAttribute("havePassword", havePassword);

		if (entity.getPassword() != null) {
			model.setAttribute("password", "[MASKED-PROTECTED]");
		}

		if (haveAnswer) {
			boolean haveOpional = entity.getAnswer().getOptional() != "" || entity.getAnswer().getOptional() != null;
			model.setAttribute("haveOptional", haveOpional);
			request.unbind(entity, model, "answer.answer", "answer.optional");
		}
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneWorkerapplicationById(id);

		return result;
	}
}
