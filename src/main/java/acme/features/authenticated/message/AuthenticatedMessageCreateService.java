
package acme.features.authenticated.message;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.entities.messagethread.MessageThread;
import acme.entities.spams.Spamlist;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageCreateService implements AbstractCreateService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "tags", "body");

		model.setAttribute("id", request.getServletRequest().getParameter("id"));
		model.setAttribute("accepted", false);
	}

	@Override
	public Message instantiate(final Request<Message> request) {

		assert request != null;

		Message result;
		Date moment;
		String id;

		result = new Message();
		moment = new Date(System.currentTimeMillis() - 1);
		id = request.getServletRequest().getParameter("id");
		MessageThread mt = this.repository.findMessageThreadById(Integer.parseInt(id));

		result.setMoment(moment);
		result.setMessageThread(mt);

		return result;
	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean fm;
		boolean accepted;

		accepted = request.getModel().getBoolean("accepted");

		if (!errors.hasErrors("accepted")) {
			errors.state(request, accepted, "accepted", "authenticated.messages.accepted");
		}

		Spamlist list = this.repository.findSpamlist();

		errors.state(request, entity.spam(list, entity.getTitle()), "title", "error.spam");
		errors.state(request, entity.spam(list, entity.getBody()), "body", "error.spam");

	}

	@Override
	public void create(final Request<Message> request, final Message entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
