insert into "categories"
values (1, current_timestamp, current_timestamp, 'Phones & Smartphones categories', 'Phone');

insert into "products"
values (2, current_timestamp, current_timestamp, 'The latest powerful iPhone from Apple', 'iPhone 11 Pro', 999.00, 0,
        'AVAILABLE', 1),
       (3, current_timestamp, current_timestamp, 'The most powerful iPhone from Apple', 'iPhone XS', 759.00, 0,
        'AVAILABLE', 1);

insert into "reviews"
values (4, current_timestamp, current_timestamp, 'I like the product but I found that it''s not perfect', 4,
        'Good but not perfect'),
       (5, current_timestamp, current_timestamp, 'Wonderful product', 5, 'Excellent'),
       (6, current_timestamp, current_timestamp, 'I like the product but not the price', 3, 'Good but very expensive');

insert into "products_reviews"
values (2, 4),
       (2, 5),
       (3, 6);

insert into "customers"
values (7, current_timestamp, current_timestamp, 'jason.bourne@mail.hello', TRUE, 'Jason', 'Bourne', '010203040506'),
       (8, current_timestamp, current_timestamp, 'homer.simpson@mail.hello', TRUE, 'Homer', 'Simpson', '060504030201');

insert into "carts"
values (9, current_timestamp, current_timestamp, 'NEW', 7),
       (12, current_timestamp, current_timestamp, 'NEW', 8);

insert into "orders"
values (10, current_timestamp, current_timestamp, 'Rue Vaugirard', NULL, 'Paris', 'FR', '75015', NULL, 'CREATION',
        999.00, 9),
       (13, current_timestamp, current_timestamp, 'Rue Maupertuis', NULL, 'Le Mans', 'FR', '72100', NULL, 'CREATION',
        759.00, 12);

insert into "order_items"
values (11, current_timestamp, current_timestamp, 1, 10, 2),
       (14, current_timestamp, current_timestamp, 1, 13, 3);
