package br.com.rocketseat.managementjobs.useCases;


import br.com.rocketseat.managementjobs.exceptions.JobNotFound;
import br.com.rocketseat.managementjobs.exceptions.UserNotFound;
import br.com.rocketseat.managementjobs.modules.jobs.ApplyJobEntity;
import br.com.rocketseat.managementjobs.repository.ApplyJobRepository;
import br.com.rocketseat.managementjobs.repository.CandidateRepository;
import br.com.rocketseat.managementjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {

        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> new UserNotFound("User not found."));

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> new JobNotFound("Job not found."));

        var applyJob = ApplyJobEntity.builder()
                        .candidateId(idCandidate)
                                .jobId(idJob).build();
        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
