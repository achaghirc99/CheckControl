
package acme.entities.spams;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spamWord;

	@Range(min = 0, max = 100)
	private Double				threshold;

}
