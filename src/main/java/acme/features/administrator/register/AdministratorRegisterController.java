
package acme.features.administrator.register;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.register.Register;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/register/")
public class AdministratorRegisterController extends AbstractController<Administrator, Register> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorRegisterShowService	showService;

	@Autowired
	private AdministratorRegisterListService	listService;

	@Autowired
	private AdministratorRegisterListServiceTop	listServiceTop;

	@Autowired
	private AdministratorRegisterCreateService	createService;

	@Autowired
	private AdministratorRegistertDeleteService	deleteService;

	@Autowired
	private AdministratorRegisterUpdateService	updateService;


	//Constructors -----------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_TOP, BasicCommand.LIST, this.listServiceTop);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}
}
