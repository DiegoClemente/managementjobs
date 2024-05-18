package br.com.rocketseat.managementjobs.models.controllers;

import br.com.rocketseat.managementjobs.dto.CreateJobDTO;
import br.com.rocketseat.managementjobs.exceptions.CompanyNotFound;
import br.com.rocketseat.managementjobs.models.utils.TestUtils;
import br.com.rocketseat.managementjobs.modules.company.CompanyEntity;
import br.com.rocketseat.managementjobs.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CreateJobControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void createNewJob() throws Exception {

        var company = CompanyEntity.builder()
                .description("COMPANY_DESCRIPTION")
                .email("EMAIL@COMPANY.COM")
                .password("1234567890")
                .username("COMPANY_USERNAME")
                .name("COMPANY_NAME").build();

        company = companyRepository.saveAndFlush(company);

        var createJobDTO = CreateJobDTO.builder()
                        .benefits("BENEFITS TEST")
                                .description("DESCRIPTION_TEST")
                                        .level("LEVEL_TEST").build();

        mvc.perform(MockMvcRequestBuilders.post("/company/job/")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.objectToJSON(createJobDTO))

                        .header("Authorization", TestUtils.generateToken(company.getId(), "JAVAGAS_@123#"))
                ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void companyNotFound() throws Exception {
        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TEST").build();
        mvc.perform(MockMvcRequestBuilders.post("/company/job/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectToJSON(createJobDTO))

                .header("Authorization", TestUtils.generateToken(UUID.randomUUID(), "JAVAGAS_@123#")))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
