
package acme.features.worker.workerapplications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/application/")
public class WorkerapplicationsController extends AbstractController<Worker, Application> {

	@Autowired
	private WorkerapplicationsListService	listMineService;

	@Autowired
	private WorkerapplicationsShowService	showService;

	@Autowired
	private WorkerapplicationsCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}

}
