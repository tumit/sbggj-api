DROP TABLE IF EXISTS customers;
CREATE TABLE customers(id INT PRIMARY KEY IDENTITY, first_name VARCHAR(255), last_name VARCHAR(255));
insert into customers (first_name, last_name) values ('trisha', 'gee');
insert into customers (first_name, last_name) values ('marco', 'behler');