
package acme.entities.passfas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Passfa extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 256)
	private String				text;

	@URL
	private String				trackNumber;

	@Valid
	@OneToOne()
	private Job					job;

}
