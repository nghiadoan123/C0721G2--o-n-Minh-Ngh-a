drop database if exists data_base_module;

create database data_base_module;

use data_base_module;

create table class (
id_class int primary key auto_increment,
class_name varchar(50)
);

-- SET SQL_SAFE_UPDATES = 0;
create table benhAn (
id int primary key auto_increment,
name varchar(60),
gender varchar(60),
age int,
average double ,
id_class int,
foreign key (id_class) references class(id_class)
);

insert into class (id_class,class_name) values (1,'ClassDay' );
insert into class (id_class,class_name) values (2,'ClassNight');
insert into class (id_class,class_name) values (3,'Part Time');



insert into benhAn (name,gender,age,average,id_class) values ('Nam', 'male', 18, 6,1);
insert into benhAn (name,gender,age,average,id_class) values ('Anh', 'male', 20, 7,2);
insert into benhAn (name,gender,age,average,id_class) values ('Mai', 'female', 26, 8,2);
insert into benhAn (name,gender,age,average,id_class) values ('Hoa', 'female', 21, 9,3);





