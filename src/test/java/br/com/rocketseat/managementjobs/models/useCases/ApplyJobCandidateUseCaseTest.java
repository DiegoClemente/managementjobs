package br.com.rocketseat.managementjobs.models.useCases;


import br.com.rocketseat.managementjobs.exceptions.JobNotFound;
import br.com.rocketseat.managementjobs.exceptions.UserNotFound;
import br.com.rocketseat.managementjobs.modules.candidate.CandidateEntity;
import br.com.rocketseat.managementjobs.modules.jobs.ApplyJobEntity;
import br.com.rocketseat.managementjobs.modules.jobs.JobEntity;
import br.com.rocketseat.managementjobs.repository.ApplyJobRepository;
import br.com.rocketseat.managementjobs.repository.CandidateRepository;
import br.com.rocketseat.managementjobs.repository.JobRepository;
import br.com.rocketseat.managementjobs.useCases.ApplyJobCandidateUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("If candidate doesn't exists isn't possible to a apply a new job")
    public void candidateNotBeAbleToApplyToJob() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        }catch (Exception e) {
               assertThat(e).isInstanceOf(UserNotFound.class);
        }

    }

    @Test
    public void itsNotPossibleIfJobDoesntExists() {
        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);
        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        }catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFound.class);
        }
    }

    @Test
    public void itsPossibleApplyNewJob() {
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate))
                .thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob))
                .thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob))
                .thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");

    }
}
