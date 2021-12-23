drop database if exists data_base_module;

create database data_base_module;

use data_base_module;

create table benh_an (
id_ma_benh_an varchar(60) primary key,
ten_benh_an varchar(50)
);

insert into benh_an (id_ma_benh_an,ten_benh_an) values ('BA-001','gan');
insert into benh_an (id_ma_benh_an,ten_benh_an) values ('BA-002','than');

create table benh_nhan (
id_ma_benh_nhan varchar(60) primary key,
ten_benh varchar(50)
);

insert into benh_nhan (id_ma_benh_nhan,ten_benh) values ('BN-001','gan');
insert into benh_nhan (id_ma_benh_nhan,ten_benh) values ('BN-002','than');


create table danh_sach_benh_an (
id_danh_sach_benh_an int primary key auto_increment,
id_ma_benh_an varchar(50),
id_ma_benh_nhan varchar(50),
ten_benh_nhan varchar(50),
ngay_mhap_vien date,
ngay_ra_vien date,
ly_do_nhap_vien varchar(60),
foreign key (id_ma_benh_an) references benh_an(id_ma_benh_an),
foreign key (id_ma_benh_nhan) references benh_nhan(id_ma_benh_nhan)
);

SET SQL_SAFE_UPDATES = 0;

insert into danh_sach_benh_an (id_danh_sach_benh_an,id_ma_benh_an,id_ma_benh_nhan,ten_benh_nhan,ngay_mhap_vien,ngay_ra_vien,ly_do_nhap_vien) 
values (1,'BA-001','BN-001','Nguyen Van A','2021-12-11','2021-12-15','dau gan'),
		(2,'BA-001','BN-002','Nguyen Van A','2021-12-10','2021-12-17','dau than');
-- SET SQL_SAFE_UPDATES = 0;












