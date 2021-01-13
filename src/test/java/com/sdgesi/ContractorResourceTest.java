package com.sdgesi;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
@Tag("integration")
public class ContractorResourceTest {

    @InjectMock
    ContractorService contractorService;

    @Test
    void shouldReturnContractorWhenExists() {
        //Arrange
        Contractor contractor = Contractor.builder()
                .licenseNo("1000001")
                .businessName("PERSONAL HOLDINGS")
                .build();

        when(contractorService.findByLicenseNo("1000001")).thenReturn(Uni.createFrom().item(contractor));

        //Act/Assert
        given()
                .pathParam("licenseNo", "1000001")
                .when().get("/contractor/{licenseNo}")
                .then()
                    .statusCode(200)
                    .body(is("{\"licenseNo\":\"1000001\",\"businessName\":\"PERSONAL HOLDINGS\"}"));
    }

    @Test
    void shouldReturnNotFoundWhenContracExists() {
        //Arrange
        when(contractorService.findByLicenseNo("1000002")).thenReturn(Uni.createFrom().nullItem());

        //Act/Assert
        given()
                .pathParam("licenseNo", "1000002")
                .when().get("/contractor/{licenseNo}")
                .then()
                .statusCode(is(404));
    }
}
