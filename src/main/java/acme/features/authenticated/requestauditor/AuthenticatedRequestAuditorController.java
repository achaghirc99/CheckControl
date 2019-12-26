
package acme.features.authenticated.requestauditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requestauditors.Requestauditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/requestauditor/")
public class AuthenticatedRequestAuditorController extends AbstractController<Authenticated, Requestauditor> {

	@Autowired
	private AuthenticatedRequestAuditorCreateService	createService;

	@Autowired
	private AuthenticatedRequestAuditorListService		listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
}
