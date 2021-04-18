package org.objectworld.book.customer.repository

class CustomerRepositorySQL {
	public static final String getId = """
		select hibernate_sequence.nextval from dual;
	""";
	
	public static final String update = """
		update customers set
			created_date = :createdDate
			, last_modified_date = :lastModifiedDate
			, email = :email
			, enabled = :enabled
			, first_name = :firstName
			, last_name = :lastName
			, telephone = :telephone
		where id = :id
		;
	""";
	
	public static final String findById = """
		select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone
		from customers
		where id = :id
		;
    """;
	
	public static final String findAll = """
		select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone
		from customers
		;
     """;
	 
	 public static final String findAllByEnabled = """
		select id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone
		from customers
		where enabled = :enabled
		;
     """;
}
