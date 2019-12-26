
package acme.entities.jobs;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.entities.dutys.Duty;
import acme.entities.spams.Spamlist;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Descriptor extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				description;

	@Valid
	@OneToMany(mappedBy = "descriptor")
	private Collection<Duty>	duties;


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
