
package acme.features.worker.workerapplications;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.applications.ApplicationStatus;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerapplicationsCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	private WorkerapplicationsRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		//		Boolean result = true;
		//		Integer jobId;
		//		Collection<Application> applications;
		//		Integer IdWorker;
		//		Worker worker;
		//
		//		jobId = request.getModel().getInteger("jobId");
		//		applications = this.repository.findApplicationByJobId(jobId);
		//		IdWorker = request.getPrincipal().getActiveRoleId();
		//		worker = this.repository.findWorker(IdWorker);
		//
		//		for (Application a : applications) {
		//			if (a.getWorker() == worker) {
		//				result = false;
		//			}
		//		}
		//
		//		return result;
		return true;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "job", "worker");
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int jobId = request.getModel().getInteger("jobId");
		model.setAttribute("jobId", jobId);

		request.unbind(entity, model, "referenceNumber", "status", "statement", "skills", "qualifications", "password");
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;

		Application result = new Application();

		result.setStatus(ApplicationStatus.PENDING);

		Date moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		Integer IdWorker = request.getPrincipal().getActiveRoleId();
		Worker worker = this.repository.findWorker(IdWorker);
		result.setWorker(worker);

		Integer jobId = request.getModel().getInteger("jobId");
		Job job = this.repository.findJob(jobId);
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getStatement()), "statement", "error.spam");
		errors.state(request, entity.spam(list, entity.getSkills()), "skills", "error.spam");
		errors.state(request, entity.spam(list, entity.getQualifications()), "qualifications", "error.spam");

		boolean checkPassword = this.isValidPassword(entity.getPassword());
		errors.state(request, checkPassword, "password", "error.password");

	}

	private Boolean isValidPassword(final String password) {
		Boolean res = false;
		int numberDigits = 0, numberLetters = 0, numberSimbols = 0;
		char c;
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			String charToString = String.valueOf(c);
			if (charToString.matches("[a-zA-ZÑñ ]")) {
				numberLetters++;
			} else if (charToString.matches("\\d")) {
				numberDigits++;
			} else {
				numberSimbols++;
			}
		}
		res = numberLetters >= 5 && numberDigits >= 3 && numberSimbols >= 1;
		return res;
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Date moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

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
