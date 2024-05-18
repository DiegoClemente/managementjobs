package br.com.rocketseat.managementjobs.security;

import br.com.rocketseat.managementjobs.providers.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    @Autowired
    private JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        logger.info("Received request to {}", request.getRequestURI());

        //SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/company")) {
            logger.info("Received request to /company endpoint");

            if (header != null) {
                logger.info("Authorization header present");

                var token = this.jwtProvider.validateToken(header);

                if (token == null) {
                    logger.warn("Invalid token detected!");

                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                var roles = token.getClaim("roles").asList(Object.class);

                logger.info("User roles: = " + roles);

                var grants = roles.stream()
                                .map(role -> new SimpleGrantedAuthority("ROLE_"
                                        + role.toString().toUpperCase()))
                                        .toList();

                logger.info("Grants = " + grants);

                String companyId = token.getSubject();
                logger.info("Company ID from token: {}", companyId);

                request.setAttribute("company_id", token.getSubject());

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(token.getSubject(),
                                null,
                                grants);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }else {
                logger.warn("Authorization header missing");
            }

        }

        filterChain.doFilter(request, response);
        logger.info("request = " + request);
        logger.info("response = " + response);
    }
}
