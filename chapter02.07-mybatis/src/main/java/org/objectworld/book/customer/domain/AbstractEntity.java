package org.objectworld.book.customer.domain;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Base Entity class for entities which will hold creation and last modification date.
 */
@Data
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonIgnore
    private Instant createdDate = Instant.now();

    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();
}