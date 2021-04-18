package org.objectworld.book.customer.repository;

import java.sql.SQLException;

import org.objectworld.book.customer.domain.AbstractEntity;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AbstractEntitySequenceSelector implements BeforeConvertCallback<AbstractEntity> {
	private final JdbcTemplate jdbcTemplate;
	
	public AbstractEntitySequenceSelector(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public AbstractEntity onBeforeConvert(AbstractEntity aggregate) {
		log.debug("AbstractEntity beforeConvertCallback={}", aggregate);
	    if (aggregate.getId() == null) {
	        Long id = jdbcTemplate.query("SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL", resultSet -> {
	            if (resultSet.next()) {
	                return resultSet.getLong(1);
	            } else {
	                throw new SQLException("Fehler beim Abrufen der Sequence");
	            }
	        });
	        aggregate.setId(id);
	    }
	    return aggregate;
	}
}
