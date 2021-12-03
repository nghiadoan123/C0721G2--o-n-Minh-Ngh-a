drop database if exists student;

create database student;

use student;


create table student (
id int primary key auto_increment,
`name` varchar(60),
gender varchar(60),
age int,
average double 
);

insert into student values 
('1', 'Nam', 'male', '18', '5.9'),
('2', 'Anh', 'male', '20', '7.0'),
('3', 'Mai', 'female', '26', '8.0'),
('4', 'Hoa', 'female', '21', '9.0');






