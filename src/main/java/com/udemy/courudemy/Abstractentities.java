package com.udemy.courudemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Abstractentities implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @CreatedDate
    @Column(name = "creationDate ", nullable = false)
    @JsonIgnore
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "lastemodifieDate ")
    private Instant updatedAt;


}
