package br.com.rocketseat.managementjobs.modules.controllers;

import br.com.rocketseat.managementjobs.exceptions.UserAlreadyExists;
import br.com.rocketseat.managementjobs.modules.company.CompanyEntity;
import br.com.rocketseat.managementjobs.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        }catch (UserAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
