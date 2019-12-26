
package acme.features.authenticated.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditRecordsRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id=?1")
	Auditrecord findOneAuditRecordById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1")
	Collection<Auditrecord> findManyByJobId(int id);

}
