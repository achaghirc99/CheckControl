
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
		boolean havePassword = entity.getPassword() != null && entity.getJob().getPassword() != null;
		model.setAttribute("havePassword", havePassword);
		if (entity.getPassword() != null) {
			model.setAttribute("password", "[MASKED-PROTECTED]");
		}

		if (haveAnswer) {
			boolean haveOptional = entity.getAnswer().getOptional() != null;
			model.setAttribute("haveOptional", haveOptional);
			if (havePassword) {
				boolean checkPassword = entity.getPassword().equals(entity.getJob().getPassword());
				if (checkPassword) {
					request.unbind(entity, model, "answer.answer", "answer.optional");
				}
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
