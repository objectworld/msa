package org.objectworld.book.customer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.objectworld.book.customer.domain.Customer;

@Mapper
public interface CustomerMapper {
	public long getId();
	public long insert(Customer customer);
	public long update(Customer customer);
	public Optional<Customer> findById(Long id);
	public List<Customer> findAll();
	public List<Customer> findAllByEnabled(boolean enabled);
}
