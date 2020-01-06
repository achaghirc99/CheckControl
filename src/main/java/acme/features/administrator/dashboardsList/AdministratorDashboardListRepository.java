
package acme.features.administrator.dashboardsList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardListRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer getTotalNumberAnnouncement();

	@Query("select count(i) from Register i")
	Integer getTotalNumberInvestor();

	@Query("select count(c) from Companyrecord c")
	Integer getTotalNumberCompany();

	@Query("select min(reward.amount) from Requeststore r where now()<=r.deadline")
	Double getMinimumRequest();

	@Query("select max(reward.amount) from Requeststore r where now()<=r.deadline")
	Double getMaximumRequest();

	@Query("select avg(reward.amount) from Requeststore r where now()<=r.deadline")
	Double getAverageRequest();

	@Query("select stddev(reward.amount) from Requeststore r where now()<=r.deadline")
	Double getDesviationRequest();

	@Query("select min(reward.amount) from Requeststore r where now()<=r.deadline")
	Double getMinimumOffers();

	@Query("select max(reward.amount) from Offer o where now()<=o.deadline")
	Double getMaximumOffers();

	@Query("select avg(reward.amount) from Offer o where now()<=o.deadline")
	Double getAverageOffers();

	@Query("select stddev(reward.amount) from Offer o where now()<=o.deadline")
	Double getDesviationOffers();

	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double averageNumberOfJobsPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double averageNumberOfApplicationsPerWorker();

	@Query("select avg(select count(a) from Application a where " + "exists(select j from Job j where j.employer.id = e.id and a.job.id = j.id)) " + "from Employer e")
	Double averageNumberOfApplicationsPerEmployer();

	@Query("select 1.0*count(j) / (select count(a) from Job a) from Jobchallenge j where j.job.id is not null")
	Double getRatioJobsWithChallenge();

	@Query("select 1.0 * count(c) / (select count(b) from Jobchallenge b) from Jobchallenge c where c.xxx4 is not null")
	Double getRatioChallengeWithXxx4();

	@Query("select 1.0 * count(a) / (select count(c) from Application c) from Application a where a.xxx4.password is not null")
	Double getRatioOfApplicationsWithPasworedXXX4();

}
