package org.objectworld.book.customer.domain;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Base Entity class for entities which will hold creation and last modification date.
 */
@Data
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private Long id;
    private Instant createdDate = Instant.now();
    private Instant lastModifiedDate = Instant.now();
}