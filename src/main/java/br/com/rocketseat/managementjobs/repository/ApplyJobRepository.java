package br.com.rocketseat.managementjobs.repository;

import br.com.rocketseat.managementjobs.modules.jobs.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
