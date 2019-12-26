
package acme.features.sponsor.noncommercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/non-commercialbanner/")
public class SponsorNonCommercialbannerController extends AbstractController<Sponsor, Noncommercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private SponsorNonCommercialbannerListService	listMineService;

	@Autowired
	private SponsorNonCommercialbannerShowService	showService;

	@Autowired
	private SponsorNonCommercialbannerUpdateService	updateService;

	@Autowired
	private SponsorNonCommercialbannerCreateService	createService;

	@Autowired
	private SponsorNonCommercialbannerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
