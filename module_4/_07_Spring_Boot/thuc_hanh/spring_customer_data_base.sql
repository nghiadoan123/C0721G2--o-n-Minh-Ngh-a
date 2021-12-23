drop database if exists customer_spring;

create database customer_spring;

use customer_spring;

create table provinces (
province_id int primary key auto_increment,
name varchar(60)
);

insert into provinces (province_id, name) 
values 
(1,"Ha Noi"),
(2,"Hue"),
(3,"Da Nang");


-- SET SQL_SAFE_UPDATES = 0;
create table customers (
id int primary key,
first_name varchar(60),
last_name varchar(60),
province_id int,
foreign key(province_id) references provinces (province_id)
);

insert into customers (id, first_name,last_name,province_id) 
values 
(1,"Anh","Nguyen",1),
(2,"Vu","Gang",2),
(3,"Nguyen","Le",3);

