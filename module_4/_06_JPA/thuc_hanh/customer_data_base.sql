drop database if exists customer;

create database customer;

use customer;

create table customers (
id int primary key,
first_name varchar(60),
last_name varchar(60)
);

insert into customers (id, first_name,last_name) 
values 
(1,"Anh","Nguyen"),
(2,"Vu","Gang"),
(3,"Nguyen","Le");


DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;

