package br.com.rocketseat.managementjobs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Job for junior developer", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GymPass, Va/VR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Junior", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
