package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Audit {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant ssCreatedOn;
    @LastModifiedDate
    @Column(nullable = false)
    private Instant ssModifiedOn;
}
