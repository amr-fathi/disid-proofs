package org.springframework.roo.clinictests.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Enumerated;
import org.springframework.roo.clinictests.domain.reference.Specialty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.roo.addon.jpa.annotations.audit.RooJpaAudit;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;

/**
 * = Vet
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{lastName} (#{specialty})")
@RooJpaAudit
@RooJaxbEntity
public class Vet extends AbstractPerson {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @NotNull
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar employedSince;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Enumerated
    private Specialty specialty;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "vet")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Visit> visits = new HashSet<Visit>();

    /**
     * TODO Auto-generated field documentation
     *
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdDate;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @CreatedBy
    private String createdBy;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modifiedDate;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @LastModifiedBy
    private String modifiedBy;
}
