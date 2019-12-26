
package acme.entities.messages;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.messagethread.MessageThread;
import acme.entities.spams.Spamlist;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotNull
	private Boolean				accepted;

	@NotBlank
	private String				tags;

	@NotBlank
	private String				body;

	// Relationships--------------------
	@NotNull
	@Valid
	@ManyToOne
	private MessageThread		messageThread;


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
