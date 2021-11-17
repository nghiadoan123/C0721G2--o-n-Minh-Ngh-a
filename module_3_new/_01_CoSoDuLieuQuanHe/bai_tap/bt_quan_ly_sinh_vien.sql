create table student_management.class(
id int not null,
name varchar(45) null,
primary key (id)
);

create table student_management.teacher(
id int not null primary key,
name varchar(45) null,
age int null,
country varchar(45) null
);

