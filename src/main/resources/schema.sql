DROP TABLE IF EXISTS customers;
CREATE TABLE customers(id INT PRIMARY KEY IDENTITY, first_name VARCHAR(255), last_name VARCHAR(255));
insert into customers (first_name, last_name) values ('trisha', 'gee');
insert into customers (first_name, last_name) values ('marco', 'behler');


DROP TABLE IF EXISTS requirement;
CREATE TABLE requirement(id INT PRIMARY KEY IDENTITY, title VARCHAR(255), contact_mobile_no VARCHAR(255), status  VARCHAR(255));
insert into requirement (title, contact_mobile_no, status) values ('Keyboard 5 units', '0881234567', 'PENDING');
insert into requirement (title, contact_mobile_no, status) values ('Mouse 10 units', '0891234567', 'PENDING');
