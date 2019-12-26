
package acme.features.administrator.register;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.register.Register;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorRegisterListService implements AbstractListService<Administrator, Register> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorRegisterRepository repository;


	// AbstractListService<Anonymous, Register> interface --------------

	@Override
	public boolean authorise(final Request<Register> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Register> request, final Register entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "investmentStatement", "assessment");
	}

	@Override
	public Collection<Register> findMany(final Request<Register> request) {
		assert request != null;

		Collection<Register> result = this.repository.findManyRegisters();

		//		Collection<Register> res = new ArrayList<>();

		//		for (Register r : result) {
		//			if (r.getAssessment() == 5) {
		//				res.add(r);
		//			}
		//		}
		//		return res;
		return result;
	}

}
