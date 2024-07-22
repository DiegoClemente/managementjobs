package br.com.rocketseat.managementjobs.useCases;

import br.com.rocketseat.managementjobs.modules.jobs.JobEntity;
import br.com.rocketseat.managementjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListAllJobsByCompanyUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(UUID companyId) {
        return this.jobRepository.findByCompanyId(companyId);
    }
}
