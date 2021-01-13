package com.sdgesi;

import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@AllArgsConstructor
public class ContractorService {

    @Inject
    ContractorRepository repository;

    public Uni<Contractor> findByLicenseNo(String licenseNo) {
        return repository.findByLicenseNo(licenseNo);
    }

}
