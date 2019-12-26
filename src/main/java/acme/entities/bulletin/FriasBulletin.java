
package acme.entities.bulletin;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FriasBulletin extends DomainEntity {

	//Serialisation identifier---------------

	private static final long	serialVersionUID	= 1L;

	//Attributes-----------------------------

	@NotBlank
	private String				author;

	@NotBlank
	@Email
	private String				email;

	@NotBlank
	private String				location;

	@NotBlank
	private String				text;

}
