
package acme.entities.requestauditors;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Requestauditor extends DomainEntity {

	public static final long		serialVersionUID	= 1L;

	@NotBlank
	private String					reference;

	@NotNull
	private boolean					accepted;

	@NotNull
	private RequestAuditorStatus	status;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private Authenticated			user;

}
