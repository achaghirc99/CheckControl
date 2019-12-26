
package acme.entities.dashboards;

import java.util.List;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	String[]					labels;
	String[]					numberRegisters;
	String[]					numberCompanies;

	String[]					ratioJobsByStatus;
	String[]					ratioApplicationsByStatus;

	List<Integer>				numberPendingApplications; //Pending applications per day the last four weeks
	List<Integer>				numberAcceptedApplications;//Accepted applications per day the last four weeks
	List<Integer>				numberRejectedApplications;//Rejected applications per day the last four weeks

}
