package br.com.rocketseat.managementjobs.repository;

import br.com.rocketseat.managementjobs.modules.jobs.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);

    List<JobEntity> findByCompanyId(UUID companyId);
}
