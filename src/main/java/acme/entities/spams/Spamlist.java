
package acme.entities.spams;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spamlist extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@Range(min = 0, max = 100)
	private Double				threshold;

	@Valid
	@OneToMany
	private Collection<Spam>	spamList;

}
