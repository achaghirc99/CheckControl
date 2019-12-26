
package acme.entities.register;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Register extends DomainEntity {

	/**
	 * Serial Identificator
	 */
	private static final long	serialVersionUID	= 1L;

	//Atributes

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				investmentStatement;

	@Range(min = 1, max = 5)
	private Integer				assessment;

}
