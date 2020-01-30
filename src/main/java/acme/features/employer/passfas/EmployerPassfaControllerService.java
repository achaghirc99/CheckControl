
package acme.features.employer.passfas;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.passfas.Passfa;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/passfa/")
public class EmployerPassfaControllerService extends AbstractController<Employer, Passfa> {

	@Autowired
	private EmployerPassfaCreateService	createService;

	@Autowired
	private EmployerPassfaShowService	showService;

	@Autowired
	private EmployerPassfaListService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
