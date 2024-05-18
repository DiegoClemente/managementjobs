package br.com.rocketseat.managementjobs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Developer Java")
    private String description;

    @Schema(example = "justin")
    private String username;

    @Schema(example = "justin@bieber.com")
    private String email;

    private UUID id;

    @Schema(example = "Justin Bieber")
    private String name;
}
