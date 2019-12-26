
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.entities.messagethread.MessageThread;
import acme.entities.spams.Spam;
import acme.entities.spams.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.messageThread.id = ?1")
	Collection<Message> findAllMenssage(int id);

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select mt from MessageThread mt join mt.message where mt.id = ?1")
	MessageThread findOneMTById(int id);

	@Query("select m from MessageThread m where m.id = ?1")
	MessageThread findMessageThreadById(int id);

	@Query("select m from Spam m")
	Collection<Spam> findAllSpamWord();

	@Query("select mta from Message mta where mta.messageThread.id = ?1")
	Message findOneMessageById(int idMessageThread);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();

}
