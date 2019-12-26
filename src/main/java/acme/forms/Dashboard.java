
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	//Serialisation identifier--------------------------
	private static final long	serialVersionUID	= 1L;

	//Attributes

	Double						averageRewardOfRequest;
	Double						minimumRewardOfRequest;
	Double						maximumRewardOfRequest;
	Double						standardDeviationRewardOfRequest;

}
