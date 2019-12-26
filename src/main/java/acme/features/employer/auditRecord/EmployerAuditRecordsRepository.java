
package acme.features.employer.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerAuditRecordsRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id=?1")
	Auditrecord findOneAuditRecordById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1")
	Collection<Auditrecord> findManyByJobId(int id);

}
