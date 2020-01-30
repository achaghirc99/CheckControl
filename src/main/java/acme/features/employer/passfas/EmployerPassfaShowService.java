
package acme.features.employer.passfas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.passfas.Passfa;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerPassfaShowService implements AbstractShowService<Employer, Passfa> {

	@Autowired
	EmployerPassfaRepository repository;


	@Override
	public boolean authorise(final Request<Passfa> request) {
		assert request != null;
		Boolean res = true;

		//		Integer id = request.getModel().getInteger("id");
		//		Passfa p = this.repository.findPassfaById(id);
		//
		//		Job job = p.getJob();
		//		Employer e = job.getEmployer();
		//		Principal principal = request.getPrincipal();
		//
		//		res = principal.getActiveRoleId() == e.getId();

		return res;
	}

	@Override
	public void unbind(final Request<Passfa> request, final Passfa entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "trackNumber");

	}

	@Override
	public Passfa findOne(final Request<Passfa> request) {
		assert request != null;
		Integer id = request.getModel().getInteger("id");
		Passfa p = this.repository.findPassfaById(id);

		return p;
	}

}
