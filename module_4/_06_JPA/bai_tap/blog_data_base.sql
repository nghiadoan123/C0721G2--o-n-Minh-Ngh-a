drop database if exists blog_management;

create database blog_management;

use blog_management;

create table blog (
id int auto_increment primary key,
title varchar(500),
content varchar(1000)
);


insert into blog (id, title,content) values 
(1,"an vat ", "my quang, banh my, bun, pho"),
(2,"địa điểm du lịch ", "Đà Nẵng, Huế, Hội An"),
(3,"Thành phố ở Việt Nam", "Đà Nẵng, Huế, Sài Gòn, Hà Nội");

