insert into "categories" (id, created_date, last_modified_date, description, name) 
values (1, current_timestamp, current_timestamp, 'Phones & Smartphones categories', 'Phone');

insert into "products" (id, created_date, last_modified_date, description, name, price, sales_counter, status, category_id)  
values (2, current_timestamp, current_timestamp, 'The latest powerful iPhone from Apple', 'iPhone 11 Pro', 999.00, 0,
        'AVAILABLE', 1),
       (3, current_timestamp, current_timestamp, 'The most powerful iPhone from Apple', 'iPhone XS', 759.00, 0,
        'AVAILABLE', 1);

insert into "reviews" (id, created_date, last_modified_date, description, rating, title) 
values (4, current_timestamp, current_timestamp, 'I like the product but I found that it''s not perfect', 4,
        'Good but not perfect'),
       (5, current_timestamp, current_timestamp, 'Wonderful product', 5, 'Excellent'),
       (6, current_timestamp, current_timestamp, 'I like the product but not the price', 3, 'Good but very expensive');

insert into "products_reviews" (product_id, reviews_id)
values (2, 4),
       (2, 5),
       (3, 6);

insert into "customers" (id, created_date, last_modified_date, email, enabled, first_name, last_name, telephone, 
	home_address_1, home_address_2, home_city, home_country, home_postcode, 
	office_address_1, office_address_2, office_city, office_country, office_postcode)
values (7, current_timestamp, current_timestamp, 'jason.bourne@mail.hello', TRUE, 'Jason', 'Bourne', '010203040506', 'Rue Vaugirard', NULL, 'Paris', 'FR', '75015', 'Rue Maupertuis', NULL, 'Le Mans', 'FR', '72100'),
       (8, current_timestamp, current_timestamp, 'homer.simpson@mail.hello', TRUE, 'Homer', 'Simpson', '060504030201', 'Rue Maupertuis', NULL, 'Le Mans', 'FR', '72100', 'Rue Maupertuis', NULL, 'Le Mans', 'FR', '72100');

insert into "carts" (id, created_date, last_modified_date, status, customer_id)
values (9, current_timestamp, current_timestamp, 'NEW', 7),
       (12, current_timestamp, current_timestamp, 'NEW', 8);

insert into "orders" (id, created_date, last_modified_date, address_1, address_2, city, country, postcode, shipped, status, total_price, cart_id)
values (10, current_timestamp, current_timestamp, 'Rue Vaugirard', NULL, 'Paris', 'FR', '75015', current_timestamp, 'HOLD',
        999.00, 9),
       (13, current_timestamp, current_timestamp, 'Rue Maupertuis', NULL, 'Le Mans', 'FR', '72100', NULL, 'CREATION',
        759.00, 12);

insert into "order_items" (id, created_date, last_modified_date, quantity, order_id, product_id)
values (11, current_timestamp, current_timestamp, 1, 10, 2),
       (14, current_timestamp, current_timestamp, 1, 13, 3);
	   
insert into "payments" (id, created_date, last_modified_date, paypal_payment_id, status, order_id)
values (15, current_timestamp, current_timestamp, 1234, 'ACCEPTED', 10);

alter sequence hibernate_sequence increment by 15;
select hibernate_sequence.nextval from dual;
alter sequence hibernate_sequence increment by 1;
	   
	   
	  
