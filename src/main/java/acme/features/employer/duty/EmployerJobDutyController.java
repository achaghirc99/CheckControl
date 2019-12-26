
package acme.features.employer.duty;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.dutys.Duty;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/duty/")
public class EmployerJobDutyController extends AbstractController<Employer, Duty> {

	@Autowired
	private EmployerJobDutyListService		listDutyService;

	@Autowired
	private EmployerJobDutyShowService		showService;

	@Autowired
	private EmployerJobDutyUpdateService	updateService;

	@Autowired
	private EmployerJobDutyCreateService	createService;

	@Autowired
	private EmployerJobDutyDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_DUTY, BasicCommand.LIST, this.listDutyService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
