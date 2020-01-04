
package acme.features.employer.jobChallenge;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.jobchallenges.Jobchallenge;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/jobchallenge/")
public class EmployerJobChallengeControllerService extends AbstractController<Employer, Jobchallenge> {

	@Autowired
	private EmployerJobChallengeCreateService createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
