package org.objectworld.book.customer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.objectworld.book.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomerRepository {
	private NamedParameterJdbcOperations db;
	private RowMapper<Customer> rowMapper = BeanPropertyRowMapper.newInstance(Customer.class);
	private SimpleJdbcInsertOperations insertion;
	
	@Autowired
	public CustomerRepository(@Qualifier("datasource") DataSource dataSource) {
		this.db = new NamedParameterJdbcTemplate(dataSource);
		this.insertion = new SimpleJdbcInsert(dataSource)
			.withTableName("customers");
	}
	
	private long getId() {
		Map<String, Object> params = new HashMap<>();
		final SqlRowSet  sqlRowSet = db.queryForRowSet(CustomerRepositorySQL.getId, params);
		sqlRowSet.next();
		return sqlRowSet.getLong(1);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Customer insert(Customer customer) {
		customer.setId(getId());
		SqlParameterSource params = new BeanPropertySqlParameterSource(customer);
		insertion.execute(params);
		return customer;
	}

	public Customer update(Customer customer) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(customer);
		db.update(CustomerRepositorySQL.update, params);
		return customer;
	}

	public Optional<Customer> findById(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		Customer customer = db.queryForObject(CustomerRepositorySQL.findById, params, rowMapper);
		return Optional.of(customer);
	}
	
	public List<Customer> findAll() {
		Map<String, Object> params = new HashMap<>();
		
		List<Customer> customerList = db.query(CustomerRepositorySQL.findAll, params, rowMapper);
		return customerList;
	}
	
	public List<Customer> findAllByEnabled(boolean enabled) {
		Map<String, Object> params = new HashMap<>();
		params.put("enabled", enabled);
		
		List<Customer> customerList = db.query(CustomerRepositorySQL.findAllByEnabled, params, rowMapper);
		return customerList;
	}
}
