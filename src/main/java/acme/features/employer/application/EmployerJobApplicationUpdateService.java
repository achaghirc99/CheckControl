
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.applications.ApplicationStatus;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobApplicationUpdateService implements AbstractUpdateService<Employer, Application> {

	@Autowired
	EmployerJobApplicationsRepository repository;


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
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "justification");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application ap;
		int idApp = request.getModel().getInteger("id");

		ap = this.repository.findOneWorkerapplicationById(idApp);

		return ap;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		ApplicationStatus status = entity.getStatus();
		boolean checkStatusAccepted = status.equals(ApplicationStatus.ACCEPTED) && entity.getJustification() == "";
		boolean checkStatusPending = status.equals(ApplicationStatus.PENDING) && entity.getJustification() == "";
		boolean checkStatusRejected = status.equals(ApplicationStatus.REJECTED) && entity.getJustification() != "";
		if (entity.getStatus().equals(ApplicationStatus.ACCEPTED) || entity.getStatus().equals(ApplicationStatus.PENDING)) {
			errors.state(request, checkStatusAccepted || checkStatusPending, "justification", "employer.job.application.update.error.justification");
		} else {
			if (!errors.hasErrors("justification") && entity.getStatus().equals(ApplicationStatus.REJECTED)) {
				errors.state(request, checkStatusRejected, "justification", "employer.job.application.update.error.justification.rejected");
			}
		}
	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Application> request, final Response<Application> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
