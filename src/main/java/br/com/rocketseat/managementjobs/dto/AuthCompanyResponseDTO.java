package br.com.rocketseat.managementjobs.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCompanyResponseDTO {

    private String access_token;
    private Long expires_in;
    private List<String> roles;
}
