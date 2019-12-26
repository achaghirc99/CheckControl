
package acme.features.administrator.noncomercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/noncommercialbanner/")
public class AdministratorNonCommercialbannerController extends AbstractController<Administrator, Noncommercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorNonCommercialbannerListService		listService;

	@Autowired
	private AdministratorNonCommercialbannerShowService		showService;

	@Autowired
	private AdministratorNonCommercialbannerCreateService	createService;

	@Autowired
	private AdministradorNonCommercialbannerUpdateService	updateService;

	@Autowired
	private AdministratorNonCommercialbannerDeleteService	deleteService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
