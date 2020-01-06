
package acme.entities.applications;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobchallenges.XXX4;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.entities.spams.Spamlist;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	/**
	 * Serial Identificator
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 5, max = 15)
	@Pattern(regexp = "[\\w]{4}-[\\w]{4}:[\\w]{4}", message = "The pattern must be like EEEE-JJJJ-WWWW")
	@Column(unique = true)
	private String				referenceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotNull
	private ApplicationStatus	status;

	@NotBlank
	private String				statement;

	@NotBlank
	private String				skills;

	@NotBlank
	private String				qualifications;

	private String				justification;

	/**
	 * Esto es lo nuevo añadido para el checkControl
	 */

	@Valid
	@OneToOne(optional = true)
	private XXX4				xxx4;

	private String				answer;

	//---------------------------------------------------------------------------------------

	//Relationships
	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;

	@Valid
	@ManyToOne(optional = false)
	private Job					job;


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
