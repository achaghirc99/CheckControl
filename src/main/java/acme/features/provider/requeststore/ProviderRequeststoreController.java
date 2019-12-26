
package acme.features.provider.requeststore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requeststores.Requeststore;
import acme.entities.roles.Provider;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/provider/requeststore/")
public class ProviderRequeststoreController extends AbstractController<Provider, Requeststore> {

	@Autowired
	private ProviderRequetStoreListService		listService;

	@Autowired
	private ProviderRequestStoreCreateService	createService;

	@Autowired
	private ProviderRequestStoreShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}
}
