
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

		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "justification");

		model.setAttribute("applicationId", entity.getId());
		boolean haveAnswer = entity.getAnswer() != null || entity.getAnswer() != "";
		model.setAttribute("haveAnswer", haveAnswer);
		if (entity.getXxx4() != null) {
			boolean havePassword = entity.getXxx4().getPassword() != null;
			model.setAttribute("havePassword", havePassword);
			if (havePassword) {
				request.unbind(entity, model, "xxx4.password");
				model.setAttribute("password", "[MASKED-PROTECTED]");
			}
		}

		if (haveAnswer) {
			request.unbind(entity, model, "answer");
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
