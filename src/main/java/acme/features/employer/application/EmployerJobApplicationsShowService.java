
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobApplicationsShowService implements AbstractShowService<Employer, Application> {

	@Autowired
	private EmployerJobApplicationsRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		boolean result;
		int applicationId;
		Application application;
		Employer employer;

		Principal principal;
		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneWorkerapplicationById(applicationId);

		employer = application.getJob().getEmployer();
		principal = request.getPrincipal();

		result = employer.getId() == principal.getActiveRoleId();

		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "justification");
		model.setAttribute("idApp", entity.getId());
		boolean haveAnswer = entity.getAnswer() != null;
		model.setAttribute("haveAnswer", haveAnswer);
		boolean haveXxx4 = entity.getXxx4() != null && entity.getJob().getChallenge().getXxx4() != null;
		model.setAttribute("haveXxx4", haveXxx4);
		boolean havePassword = false;
		if (entity.getXxx4() != null) {
			havePassword = entity.getXxx4().getPassword() != null && entity.getJob().getChallenge().getXxx4() != null;
			model.setAttribute("havePassword", havePassword);
		}
		if (haveAnswer) {
			if (havePassword) {
				request.unbind(entity, model, "xxx4.password");
				model.setAttribute("password", "[MASKED-PROTECTED]");
				boolean checkPassword = entity.getXxx4().getPassword().equals(entity.getJob().getChallenge().getXxx4().getPassword());
				if (checkPassword) {
					request.unbind(entity, model, "answer");
				}
			} else if (haveAnswer && !havePassword) {
				request.unbind(entity, model, "answer");
			}
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
