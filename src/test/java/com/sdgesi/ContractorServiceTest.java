package com.sdgesi;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@QuarkusTest
class ContractorServiceTest {

    @InjectMock
    ContractorRepository repository;

    private ContractorService contractorService;

    @BeforeEach
    void setUp() {
        contractorService = new ContractorService(repository);
    }


    @Test
    @DisplayName("givenDataExistWhenExistingLicenseNoThenReturnResults")
    void shouldReturnContractorWhenExists() {
        //Arrange
        Contractor contractor = new Contractor();
        contractor.setLicenseNo("1000001");
        contractor.setBusinessName("PERSONAL HOLDINGS");

        when(repository.findByLicenseNo(anyString())).thenReturn(Uni.createFrom().item(contractor));

        //Act
        contractorService = new ContractorService(repository);
        Uni<Contractor> result = contractorService.findByLicenseNo("1000001");

        //Then
        assertThat(result.await().indefinitely().getLicenseNo()).isEqualTo("1000001");


    }

    @Test
    @DisplayName("shouldReturnEmptyWhenNotFound")
    void shouldReturnEmptyWhenNotFound() {
        //Arrange
        when(repository.findByLicenseNo(anyString())).thenReturn(Uni.createFrom().nothing());

        //Act
        contractorService = new ContractorService(repository);
        Uni<Contractor> result = contractorService.findByLicenseNo("1000001");

        //Then
        result.onItem().ifNotNull().invoke(() -> fail("Should fail"));
    }
}