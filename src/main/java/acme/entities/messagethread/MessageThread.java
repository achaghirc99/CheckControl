
package acme.entities.messagethread;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.messages.Message;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThread extends DomainEntity {

	public static final long						serialVersionUID	= 1L;

	@NotBlank
	private String									title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date									moment;

	@NotNull
	@OneToOne
	private UserAccount								creator;

	// Relationships--------------------

	@Valid
	@OneToMany(mappedBy = "messagethread")
	private Collection<MessageThreadAuthenticated>	users;

	@NotNull
	@Valid
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<@Valid Message>				message;

}
