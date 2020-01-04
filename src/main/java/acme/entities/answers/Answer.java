
package acme.entities.answers;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import acme.entities.applications.Application;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	private String				answer;

	private String				optional;

	@Valid
	@OneToOne()
	private Application			application;

}
