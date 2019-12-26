
package acme.features.anonymous.bulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.ChaghirBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/chaghirbulletin/")
public class AnonymousChaghirBulletinController extends AbstractController<Anonymous, ChaghirBulletin> {

	//Internal State ---------------------------------------------------------------------
	@Autowired
	private AnonymousChaghirBulletinListService		listService;

	@Autowired
	private AnonymousChaghirBulletinCreateService	createService;


	//Constructors --------------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}

}
