
package acme.entities.xxx4s;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class XXX4 extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	@Pattern(regexp = "(^(?=.*[A-z]{5,})(?=.*\\d{3,})(?=.*\\p{P}{1,}).{9,}$)?", message = "The password must have five letters, three digits and two symbol punctuation")
	private String				password;

}
