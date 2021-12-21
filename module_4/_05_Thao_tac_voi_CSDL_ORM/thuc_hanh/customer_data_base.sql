drop database if exists customer_management;

create database customer_management;

use customer_management;

create table customer(
id int auto_increment primary key,
name varchar(60),
email varchar(60),
address varchar(60)
);

insert into customer(id,name,email,address) 
values 
(1,"Anh","anh@gmail.com","Da Nang"),
(2,"Vu","Vu@gmail.com","Da Nang"),
(3,"Nguyen","Nguyen@gmail.com","Da Nang");
