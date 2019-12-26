
package acme.features.employer.application;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EmployerJobListMineGroupByReferenceService implements AbstractListService<Employer, Application> {

	@Autowired
	EmployerJobApplicationsRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "status");

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result = new HashSet<>();

		Principal principal;
		principal = request.getPrincipal();
		Map<Application, Integer> grouped = this.repository.findApplicationGroupedByStatus(principal.getActiveRoleId());
		result.addAll(grouped.keySet());

		return result;
	}
}
