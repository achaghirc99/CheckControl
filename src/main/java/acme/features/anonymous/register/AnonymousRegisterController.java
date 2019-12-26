
package acme.features.anonymous.register;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.register.Register;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/register/")
public class AnonymousRegisterController extends AbstractController<Anonymous, Register> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousRegisterShowService	showService;

	@Autowired
	private AnonymousRegisterListService	listService;

	@Autowired
	private AnonymousRegisterListServiceTop	listServiceTop;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addCustomCommand(CustomCommand.LIST_TOP, BasicCommand.LIST, this.listServiceTop);
	}
}
