
package acme.features.authenticated.message_thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.entities.messagethread.MessageThread;
import acme.entities.messagethread.MessageThreadAuthenticated;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageThreadCreateService implements AbstractCreateService<Authenticated, MessageThread> {

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "creator");
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");

	}

	@Override
	public MessageThread instantiate(final Request<MessageThread> request) {
		MessageThread result;

		Date moment;

		Collection<MessageThreadAuthenticated> users;

		Collection<Message> message;

		UserAccount creator;

		creator = this.repository.findUserAccountById(request.getPrincipal().getAccountId());

		users = new ArrayList<MessageThreadAuthenticated>();

		message = new ArrayList<Message>();

		moment = new Date(System.currentTimeMillis() - 1);

		result = new MessageThread();

		result.setMoment(moment);
		result.setUsers(users);
		result.setMessage(message);
		result.setCreator(creator);

		return result;
	}

	@Override
	public void validate(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<MessageThread> request, final MessageThread entity) {
		assert request != null;
		assert entity != null;

		Collection<MessageThreadAuthenticated> users;
		Collection<Message> messages;
		MessageThreadAuthenticated messageThreadAuthenticated;

		users = new ArrayList<MessageThreadAuthenticated>();
		messages = new ArrayList<Message>();
		messageThreadAuthenticated = new MessageThreadAuthenticated();

		Integer id = request.getPrincipal().getAccountId();

		UserAccount userAcc = this.repository.findUserAccountById(id);

		messageThreadAuthenticated.setUser(userAcc);
		messageThreadAuthenticated.setMessagethread(entity);

		users.add(messageThreadAuthenticated);

		entity.setUsers(users);
		entity.setMessage(messages);

		this.repository.save(messageThreadAuthenticated);
		this.repository.save(entity);

	}

}
