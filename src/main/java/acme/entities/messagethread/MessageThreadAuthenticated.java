
package acme.entities.messagethread;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThreadAuthenticated extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@Valid
	@ManyToOne(optional = true)
	private MessageThread		messagethread;

	@NotNull
	@Valid
	@ManyToOne
	private UserAccount			user;

}
