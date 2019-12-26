
package acme.features.anonymous.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.companyrecords.Companyrecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/companyrecord/")
public class AnonymousCompanyRecordController extends AbstractController<Anonymous, Companyrecord> {

	//Internal state---------------------------------------------

	@Autowired
	private AnonymousCompanyRecordListService		listService;

	@Autowired
	private AnonymousCompanyRecordShowService		showService;

	@Autowired
	private AnonymousCompanyRecordListServiceTop	listServiceTop;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_TOP, BasicCommand.LIST, this.listServiceTop);
	}

}
