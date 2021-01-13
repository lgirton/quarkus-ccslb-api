package com.sdgesi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@MongoEntity(collection = "contractors")
@RegisterForReflection
public class Contractor {

    @BsonId
    @JsonIgnore
    ObjectId id;

    private String licenseNo;
    private String lastUpdate;
    private String businessName;
    private String businessName2;
    private String fullBusinessName;
    private String mailingAddress;
    private String city;
    private String state;
    private String county;
    private String country;
    private String businessPhone;
    private String businessType;
    private String issueDate;
    private String reissueDate;
    private String expirationDate;
    private String inactivationDate;
    private String reactivationDate;
    private String pendingSuspension;
    private String pendingClassRemoval;
    private String pendingClassReplace;
    private String primaryStatus;
    private String secondaryStatus;
    private String classifications;
    private String asbestosReg;
    private String workersCompCoverageType;
    private String dateRequired;
    private String discpCaseRegion;
    private String nameTP2;
    private String wcinsuranceCompany;
    private String wcpolicyNumber;
    private String wceffectiveDate;
    private String wcexpirationDate;
    private String wccancellationDate;
    private String wcsuspendDate;
    private String cbsuretyCompany;
    private String cbnumber;
    private String cbeffectiveDate;
    private String cbcancellationDate;
    private String cbamount;
    private String wbsuretyCompany;
    private String wbnumber;
    private String wbeffectiveDate;
    private String wbcancellationDate;
    private String wbamount;
    private String dbsuretyCompany;
    private String dbnumber;
    private String dbeffectiveDate;
    private String dbcancellationDate;
    private String dbamount;
    private String dbbondReason;
    private String dbcaseNo;
    private String zipcode;
}
