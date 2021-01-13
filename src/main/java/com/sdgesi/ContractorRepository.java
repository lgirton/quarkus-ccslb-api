package com.sdgesi;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContractorRepository implements ReactivePanacheMongoRepository<Contractor> {

    public Uni<Contractor> findByLicenseNo(String licenseNo) {
        return find("licenseNo", licenseNo).firstResult();
    }

}
