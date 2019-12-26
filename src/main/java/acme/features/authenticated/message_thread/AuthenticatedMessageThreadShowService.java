
package acme.features.authenticated.message_thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messagethread.MessageThread;
import acme.entities.messagethread.MessageThreadAuthenticated;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	@Autowired
	private AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;
		Boolean result = true;

		Integer idPrincipal = request.getPrincipal().getAccountId();
		Integer idThread = request.getModel().getInteger("id");

		MessageThreadAuthenticated mta = this.repository.findOneMessageThreadAuthenticatedByIds(idPrincipal, idThread);

		if (mta == null) {
			result = false;
		}

		return result;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id = request.getModel().getInteger("id");
		model.setAttribute("messageThreadId", id);

		request.unbind(entity, model, "title", "moment");

		model.setAttribute("isAdministrator", entity.getCreator().getId() == request.getPrincipal().getAccountId());
	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");

		MessageThread result = this.repository.findMessageThreadById(id);

		return result;
	};

}
