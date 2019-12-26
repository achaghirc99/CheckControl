
package acme.features.anonymous.maciasportillobulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.maciasportillobulletins.maciasportillobulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/maciasportillobulletin/")
public class AnonymousmaciasportillobulletinController extends AbstractController<Anonymous, maciasportillobulletin> {

	// Internel state --------------------------------------------
	@Autowired
	private AnonymousmaciasportillobulletinListService	listService;

	@Autowired
	private AnonymousmaciasportillobulletinCreateService	createService;


	// Constructor---------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}
}
