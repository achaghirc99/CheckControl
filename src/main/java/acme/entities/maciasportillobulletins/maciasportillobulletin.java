
package acme.entities.maciasportillobulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class maciasportillobulletin extends DomainEntity {

	//Serialisation identifier------------------------------------------------------------
	private static final long	serialVersionUID	= 1L;

	//Atributes---------------------------------------------------------------------------
	@NotBlank
	private String				name;

	@NotBlank
	private String				hobbies;

	@NotBlank
	private String				city;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
}
