
package acme.features.authenticated.duty;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.dutys.Duty;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/duty/")
public class AuthenticatedJobDutyController extends AbstractController<Authenticated, Duty> {

	@Autowired
	private AuthenticatedJobDutyListService	listDutyService;

	@Autowired
	private AuthenticatedJobDutyShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_DUTY, BasicCommand.LIST, this.listDutyService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
