drop database if exists quan_ly_ban_hang;

create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
cId int not null auto_increment primary key,
cName varchar(20) not null,
cAge int
);

create table order_(
oId int not null auto_increment primary key,
cId int not null,
oDate datetime,
oTotalPrice float,
foreign key (cId) references customer (cId)
);

create table product(
pId int not null auto_increment primary key,
pName varchar(50),
pPrice float
);

create table detail(
oId int not null,
pId int not null,
oQuantity int,
primary key (oId,pId),
foreign key(oId) references order_(oId),
foreign key(pId) references product(pId)
);


