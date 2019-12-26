
package acme.features.authenticated.register;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.register.Register;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/register/")
public class AuthenticatedRegisterController extends AbstractController<Authenticated, Register> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedRegisterShowService	showService;
	@Autowired
	private AuthenticatedRegisterListService	listService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
}
