
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.id in (select a.job.id from Auditrecord a where a.auditor.id = ?1) and j.status = acme.entities.jobs.JobStatus.PUBLISHED")
	Collection<Job> findManyByJobWhitAuditRecord(int auditorId);

	@Query("select j from Job j where j.id not in (select a.job.id from Auditrecord a where a.auditor.id = ?1) and j.status = acme.entities.jobs.JobStatus.PUBLISHED")
	Collection<Job> findManyByJobWhitoutAuditRecord(int auditorid);

	@Query("select a from Auditrecord a where a.job.id = ?1 and a.auditor.id = ?2")
	Auditrecord findManyAuditorByJobIdAndAuditorId(int jobId, int auditorid);

}
