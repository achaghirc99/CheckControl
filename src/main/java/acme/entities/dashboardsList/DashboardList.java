
package acme.entities.dashboardsList;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardList extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Attributes

	Integer						totalNumberAnnouncement;

	Integer						totalNumberInvestor;

	Integer						totalNumberCompany;

	Double						minimumRequest;

	Double						maximumRequest;

	Double						averageRequest;

	Double						desviationRequest;

	Double						minimumOffers;

	Double						maximumOffers;

	Double						averageOffers;

	Double						desviationOffers;

}
