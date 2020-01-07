
package acme.features.administrator.dashboard;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select p.sector, count(p) from Companyrecord p group by p.sector")
	Collection<Object[]> findAllCompanies();

	@Query("select p.sector, count(p) from Register p group by p.sector")
	Collection<Object[]> findAllRegisters();

	@Query("select j.status, count(j) from Job j group by j.status")
	Collection<Object[]> findAllJobsByStatus();

	@Query("select 1.0 * count(j) / (select count(b) from Job b) from Job j where j.status = acme.entities.jobs.JobStatus.PUBLISHED")
	Double getJobsPublished();

	@Query("select 1.0 * count(j) / (select count(b) from Job b) from Job j where j.status = acme.entities.jobs.JobStatus.DRAFTED")
	Double getJobsDraft();

	@Query("select count(j) from Job j")
	Double getTotalJobs();

	@Query("select 1.0 *  count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.applications.ApplicationStatus.PENDING")
	Double getApplicationsPending();

	@Query("select 1.0 * count(a) /(select count(b) from Application b) from Application a where a.status = acme.entities.applications.ApplicationStatus.ACCEPTED")
	Double getApplicationsAccepted();

	@Query("select 1.0 *  count(a) / (select count(b) from Application b)from Application a where a.status = acme.entities.applications.ApplicationStatus.REJECTED")
	Double getApplicationsRejected();

	@Query("select a.moment, count(a) from Application a where a.status = acme.entities.applications.ApplicationStatus.PENDING and a.moment >= ?1 group by a.moment")
	List<String[]> getPendingApplicationsPerDayLastFourWeeks(Date date);

	@Query("select a.moment, count(a) from Application a where a.status = acme.entities.applications.ApplicationStatus.ACCEPTED and a.moment >= ?1 group by a.moment")
	List<String[]> getAcceptedApplicationsPerDayLastFourWeeks(Date minimumdate);

	@Query("select a.moment, count(a) from Application a where a.status = acme.entities.applications.ApplicationStatus.REJECTED and a.moment >= ?1 group by a.moment")
	List<String[]> getRejectedApplicationsPerDayLastFourWeeks(Date minimumdate);

	@Query("select 1.0*count(j) / (select count(a) from Job a) from Passfa j where j.job.id is not null")
	Double getRatioJobsWithChallenge();

	@Query("select 1.0 * count(c) / (select count(b) from Passfa b) from Passfa c where c.trackNumber is not null")
	Double getRatioPassfasWithTrackNumber();

	@Query("select 1.0 * count(a) / (select count(c) from Application c) from Application a where a.password is not null")
	Double getRatioOfApplicationsWithPasworedXXX();
}
