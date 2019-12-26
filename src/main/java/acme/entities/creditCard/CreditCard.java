
package acme.entities.creditCard;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import acme.entities.roles.Sponsor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CreditCard", uniqueConstraints = @UniqueConstraint(columnNames = {
	"creditCardNumber"
}))
public class CreditCard extends DomainEntity {

	//Serialisation identifier

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	private String				name;

	@CreditCardNumber
	private String				creditCardNumber;

	@NotBlank
	@Pattern(regexp = "\\d{3}", message = "XXX")
	private String				cvc;

	@NotBlank
	@Range(min = 1, max = 12)
	@Pattern(regexp = "\\d{2}", message = "XX")
	private String				month;

	@NotBlank
	@Pattern(regexp = "\\d{4}", message = "XX")
	private String				year;

	@OneToOne(optional = false)
	private Sponsor				sponsor;

}
