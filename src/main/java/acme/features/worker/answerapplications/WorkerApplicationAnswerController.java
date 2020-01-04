
package acme.features.worker.answerapplications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.answers.Answer;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/answer/")
public class WorkerApplicationAnswerController extends AbstractController<Worker, Answer> {

	@Autowired
	private WorkerApplicationAnswerCreateService createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
