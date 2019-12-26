
package acme.features.administrator.requestauditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requestauditors.Requestauditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/requestauditor/")
public class AdministratorRequestAuditorController extends AbstractController<Administrator, Requestauditor> {

	@Autowired
	private AdministratorRequestAuditorListService		listService;

	@Autowired
	private AdministratorRequestAuditorUpdateService	updateService;

	@Autowired
	private AdministratorRequestAuditorShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
