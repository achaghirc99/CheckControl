
package acme.entities.jobs;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.applications.Application;
import acme.entities.auditRecords.Auditrecord;
import acme.entities.jobchallenges.Jobchallenge;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends DomainEntity {

	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 5, max = 10)
	@Column(unique = true)
	@Pattern(regexp = "[\\w]{4}-[\\w]{4}", message = "The pattern must be like EEEE-JJJJ") //Las 4 primeras letras ayudan a reconocer al empleador y las 4 segundas el trabajo.
	//(Se ruega encarecidamente pero no se puede obligar al usuario a introducirlo de esta manera especifica porque es casi imposible)(Emi)
	private String					reference;

	private JobStatus				status;

	@NotBlank
	private String					title;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date					deadline;

	@NotNull
	@Valid
	private Money					salary;

	@NotBlank
	private String					description;

	@URL
	private String					moreInfo;

	@NotNull
	private boolean					finalMode;

	//Relationships ----------------------------------------------------------------------------------------

	@Valid
	@OneToOne(mappedBy = "job")
	private Jobchallenge			challenge;

	@Valid
	@ManyToOne(optional = false)
	private Employer				employer;

	@Valid
	@OneToOne(optional = true)
	private Descriptor				descriptor;

	@Valid
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private Collection<Application>	application;

	@Valid

	@OneToMany(mappedBy = "job")
	private Collection<Auditrecord>	auditRecord;


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
