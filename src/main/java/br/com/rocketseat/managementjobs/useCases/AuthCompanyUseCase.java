package br.com.rocketseat.managementjobs.useCases;

import br.com.rocketseat.managementjobs.dto.AuthCompanyDTO;
import br.com.rocketseat.managementjobs.dto.AuthCompanyResponseDTO;
import br.com.rocketseat.managementjobs.exceptions.UserAlreadyExists;
import br.com.rocketseat.managementjobs.repository.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class AuthCompanyUseCase {

    private static final Logger logger = LoggerFactory.getLogger(AuthCompanyUseCase.class);

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        logger.info("AuthCompanyUseCase: Executing authentication for username {}", authCompanyDTO.getUsername());

        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> new UserAlreadyExists("Username/password incorrect")
        );

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches) {
            throw new AuthenticationException("Password doesn't match!");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofHours(2));


        var token = JWT.create().withIssuer("javagas")
                .withExpiresAt(expiresIn)
                .withSubject(company.getId().toString())
                .withClaim("roles", List.of("COMPANY"))
                .sign(algorithm);

        var roles = List.of("COMPANY");



        return AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .roles(roles)
                .build();
    }
}
