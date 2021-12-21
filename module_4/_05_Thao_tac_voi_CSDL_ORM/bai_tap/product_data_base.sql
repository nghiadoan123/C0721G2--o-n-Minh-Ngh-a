drop database if exists product_management;

create database product_management;

use product_management;

create table product (
id int  auto_increment primary key,
name varchar(60),
price double,
description varchar(100),
producer varchar(100)
);

insert into product (id, name, price, description, producer) values
(1,"iphone",20.0,"iphone 6","USA"),
(2,"nokia",30.0,"nokia 6","EN"),
(3,"sam sung",40.0,"sam sung 6","France"),
(4,"Lg",50.0,"Lg 6","AUS");



