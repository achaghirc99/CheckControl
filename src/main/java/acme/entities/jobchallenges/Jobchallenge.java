
package acme.entities.jobchallenges;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.entities.xxx4s.XXX4;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jobchallenge extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 150)
	private String				text;

	@URL
	private String				moreInfo;

	@Valid
	@OneToOne()
	private Job					job;

	@Valid
	@OneToOne(optional = true)
	private XXX4				xxx4;

}
