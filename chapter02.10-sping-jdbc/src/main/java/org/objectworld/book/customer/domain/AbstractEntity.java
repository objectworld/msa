package org.objectworld.book.customer.domain;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Base Entity class for entities which will hold creation and last modification date.
 */
@Data
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Instant createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;
}