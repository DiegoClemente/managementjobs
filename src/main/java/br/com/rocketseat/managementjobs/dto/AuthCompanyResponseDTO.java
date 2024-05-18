package br.com.rocketseat.managementjobs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCompanyResponseDTO {

    private String access_token;
    private Long expires_in;
}
