package com.sdgesi;

import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contractor")
@AllArgsConstructor
public class ContractorResource {

    @Inject
    ContractorService contractorService;

    @GET
    @Path("/{licenseNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> findOne(@PathParam String licenseNo) {
        return contractorService.findByLicenseNo(licenseNo)
                .onItem().transform(c ->  c != null ? Response.ok(c) : Response.status(Response.Status.NOT_FOUND))
                .onItem().transform(Response.ResponseBuilder::build);

    }
}