
package acme.entities.noncommercialbanners;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Sponsor;
import acme.entities.spams.Spamlist;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Noncommercialbanner extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@URL
	private String				targetUrl;

	@URL
	private String				optionalJingle;

	//Relationships
	@Valid
	@ManyToOne(optional = false)
	private Sponsor				sponsor;


	public Boolean spam(final Spamlist l, final String propiedad) {
		List<String> list = l.getSpamList().stream().map(x -> x.getSpamWord()).collect(Collectors.toList());
		String[] palabras = propiedad.split(" ");
		Integer tamaño = palabras.length;
		Integer acum = 0;
		for (String p : palabras) {
			if (list.contains(p)) {
				acum++;
			}
		}
		Double porcentaje = (double) (acum * 100) / tamaño;

		return porcentaje < l.getThreshold();
	}

}
