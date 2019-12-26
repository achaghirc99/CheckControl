
package acme.features.sponsor.commercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/commercialbanner/")
public class SponsorCommercialbannerController extends AbstractController<Sponsor, Commercialbanner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private SponsorCommercialbannerListService		listMineService;

	@Autowired
	private SponsorCommercialbannerShowService		showService;

	@Autowired
	private SponsorCommercialbannerUpdateService	updateService;

	@Autowired
	private SponsorCommercialbannerCreateService	createService;

	@Autowired
	private SponsorCommercialbannerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
