
package acme.entities.companyrecords;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Companyrecord extends DomainEntity {

	//Serialisation identifier----------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes------------------------------------

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo;

	@NotBlank
	private String				description;

	@URL
	private String				url;

	@Pattern(regexp = "(\\+[1-9]\\d{0,2}\\s)?(\\([1-9]\\d{0,3}\\)\\s)?(\\d{6,10})")
	private String				phone;

	@Email
	private String				email;

	private Boolean				incorporated;

	@Range(min = 1, max = 5)
	private Integer				evaluation;


	//Derived attributes

	@Transient
	public String getFullName() {
		StringBuilder res = new StringBuilder();
		if (this.incorporated == true) {
			res.append(this.name);
			res.append(", Inc.");
		} else {
			res.append(this.name);
			res.append(", LLC.");
		}
		return res.toString();
	}

}
