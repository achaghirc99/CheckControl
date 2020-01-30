
package acme.features.employer.passfas;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.passfas.Passfa;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EmployerPassfaListService implements AbstractListService<Employer, Passfa> {

	@Autowired
	EmployerPassfaRepository repository;


	@Override
	public boolean authorise(final Request<Passfa> request) {
		assert request != null;
		Boolean res = false;

		String id = request.getServletRequest().getParameter("idJob");
		Passfa p = this.repository.findPassfaById(Integer.parseInt(id));
		Employer e = p.getJob().getEmployer();
		Principal principal = request.getPrincipal();

		res = principal.getActiveRoleId() == e.getId();

		return res;
	}

	@Override
	public void unbind(final Request<Passfa> request, final Passfa entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");

	}

	@Override
	public Collection<Passfa> findMany(final Request<Passfa> request) {
		assert request != null;

		String id = request.getServletRequest().getParameter("idJob");
		Collection<Passfa> passfas = this.repository.findAllPassfasById(id);

		return passfas;
	}

}
