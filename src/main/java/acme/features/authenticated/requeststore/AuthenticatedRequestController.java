
package acme.features.authenticated.requeststore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requeststores.Requeststore;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/requeststore/")
public class AuthenticatedRequestController extends AbstractController<Authenticated, Requeststore> {

	//Internal state---------------------------------------
	@Autowired
	private AuthenticatedRequestListService	listService;

	@Autowired
	private AuthenticatedRequestShowService	showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
