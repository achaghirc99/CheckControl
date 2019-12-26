
package acme.features.authenticated.message_thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messagethread.MessageThread;
import acme.entities.messagethread.MessageThreadAuthenticated;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select mt from MessageThread mt join mt.users u where u.user.id = ?1")
	Collection<MessageThread> findMineById(int id);

	@Query("select mt from MessageThread mt join mt.message where mt.id = ?1")
	MessageThread findOneById(int id);

	@Query("select u from UserAccount u where u.id = ?1")
	UserAccount findUserAccountById(int id);

	@Query("select mt from MessageThread mt where mt.id=?1")
	MessageThread findMessageThreadById(int id);

	@Query("select ua from UserAccount ua where ua.username = ?1")
	UserAccount findOneUserAccountByUsername(String username);

	@Query("select mta from MessageThreadAuthenticated mta where mta.messagethread.id = ?1")
	Collection<MessageThreadAuthenticated> findManyMessageThreadAuthenticatedByMTId(int id);

	@Query("select mta from MessageThreadAuthenticated mta where mta.user.id = ?1 AND mta.messagethread.id = ?2")
	MessageThreadAuthenticated findOneMessageThreadAuthenticatedByIds(int idUserAccount, int idMessageThread);

	@Query("select a from Authenticated a where a.id=?1")
	Authenticated findAuthenticated(int id);
}
