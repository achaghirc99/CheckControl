
package acme.features.authenticated.companyrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.companyrecords.Companyrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedCompanyRecordShowService implements AbstractShowService<Authenticated, Companyrecord> {

	//Internal state

	@Autowired
	private AuthenticatedCompanyRecordRepository repository;


	@Override
	public boolean authorise(final Request<Companyrecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Companyrecord> request, final Companyrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "ceo", "description", "url", "phone", "email", "evaluation");
	}

	@Override
	public Companyrecord findOne(final Request<Companyrecord> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		Companyrecord result = this.repository.findOneById(id);

		result.setName(result.getFullName());

		return result;
	}

}
