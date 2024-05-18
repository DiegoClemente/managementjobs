package br.com.rocketseat.managementjobs.modules.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Justin Bieber")
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "Don't use space in username")
    @Schema(example = "justinbieber", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @Email(message = "It's necessary use a valid e-mail")
    @Schema(example = "justin@bieber.com")
    private String email;

    @Length(min = 10, max = 100)
    @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(example = "Java Developer")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
