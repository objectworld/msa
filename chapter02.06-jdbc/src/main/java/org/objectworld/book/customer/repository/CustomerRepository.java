package org.objectworld.book.customer.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.objectworld.book.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomerRepository {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	
	// JDBC Connection 연결
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
	
	private long getId() {
		String sql = "select hibernate_sequence.nextval from dual";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try { 
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long id = rs.getLong(1);
				log.debug("id = {}", id);
				return id;
			}
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(rs).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return -1;
	}
	
	public Customer save(Customer customer) {
		if(customer.getId() == null) {
			return insert(customer);
		}
		Optional<Customer> storedCustomer = findById(customer.getId());
		if(storedCustomer.isPresent()) {
			return update(customer);
		} else {
			return insert(customer);
		}
	}
	
	private Customer insert(Customer customer) {
		String sql = "insert into customers"
			+ " (created_date, last_modified_date, email, enabled, first_name, last_name, telephone, id)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		long id = getId();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setTimestamp(1, Timestamp.from(customer.getCreatedDate()));
			pstmt.setTimestamp(2, Timestamp.from(customer.getLastModifiedDate()));
			pstmt.setString(3, customer.getEmail());
			pstmt.setBoolean(4, customer.getEnabled());
			pstmt.setString(5, customer.getFirstName());
			pstmt.setString(6, customer.getLastName());
			pstmt.setString(7,  customer.getTelephone());
			pstmt.setLong(8, id);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				customer.setId(id);
			}
			log.debug("Customer : {}", customer);
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return customer;
	}

	private Customer update(Customer customer) {
		String sql = "update customers set"
			+ " created_date = ? "
			+ ", last_modified_date = ? "
			+ ", email = ? "
			+ ", enabled = ? "
			+ ", first_name = ? "
			+ ", last_name = ? "
			+ ", telephone = ? "
			+ " where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		long id = getId();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setTimestamp(1, Timestamp.from(customer.getCreatedDate()));
			pstmt.setTimestamp(2, Timestamp.from(customer.getLastModifiedDate()));
			pstmt.setString(3, customer.getEmail());
			pstmt.setBoolean(4, customer.getEnabled());
			pstmt.setString(5, customer.getFirstName());
			pstmt.setString(6, customer.getLastName());
			pstmt.setString(7,  customer.getTelephone());
			pstmt.setLong(8, customer.getId());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				customer.setId(id);
			}
			log.debug("Customer : {}", customer);
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return customer;
	}

	public Optional<Customer> findById(Long id) {
		String sql = "select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone"
			+ " from customers"
			+ " where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Customer customer = null;
		try { 
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setCreatedDate(rs.getTimestamp("created_date").toInstant());
				customer.setLastModifiedDate(rs.getTimestamp("last_modified_date").toInstant());
				customer.setEmail(rs.getString("email"));
				customer.setEnabled(rs.getBoolean("enabled"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setTelephone(rs.getString("telephone"));
			}
			log.debug("customer = {}", customer);
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(rs).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return Optional.of(customer);
	}
	
	public List<Customer> findAll() {
		String sql = "select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone"
			+ " from customers";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Customer> customerList = new ArrayList<Customer>();
		try { 
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setCreatedDate(rs.getTimestamp("created_date").toInstant());
				customer.setLastModifiedDate(rs.getTimestamp("last_modified_date").toInstant());
				customer.setEmail(rs.getString("email"));
				customer.setEnabled(rs.getBoolean("enabled"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setTelephone(rs.getString("telephone"));
				customerList.add(customer);
			}
			log.debug("customerList = {}", customerList);
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(rs).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return customerList;
	}
	
	public List<Customer> findAllByEnabled(boolean enabled) {
		String sql = "select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone"
				+ " from customers" 
				+ " where enabled=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Customer> customerList = new ArrayList<Customer>();
		try { 
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, enabled);
			rs = pstmt.executeQuery();
			pstmt.setBoolean(1, enabled);
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setCreatedDate(rs.getTimestamp("created_date").toInstant());
				customer.setLastModifiedDate(rs.getTimestamp("last_modified_date").toInstant());
				customer.setEmail(rs.getString("email"));
				customer.setEnabled(rs.getBoolean("enabled"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setTelephone(rs.getString("telephone"));
				customerList.add(customer);
			}
			log.debug("customerList = {}", customerList);
		} catch(ClassNotFoundException | SQLException e) {
			log.error("Exception : ", e);
		} finally {
			try {
				Objects.requireNonNull(rs).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(pstmt).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
			try {
				Objects.requireNonNull(con).close();
			} catch(SQLException e) {
				log.error("Exception : ", e);
			}
		}
		return customerList;
	}
}
