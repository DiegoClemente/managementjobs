package br.com.rocketseat.managementjobs.useCases;


import br.com.rocketseat.managementjobs.exceptions.CompanyNotFound;
import br.com.rocketseat.managementjobs.modules.jobs.JobEntity;
import br.com.rocketseat.managementjobs.repository.CompanyRepository;
import br.com.rocketseat.managementjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() ->
                new CompanyNotFound("Company not found"));
        return this.jobRepository.save(jobEntity);
    }
}
