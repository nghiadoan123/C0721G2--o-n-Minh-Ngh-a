create database quan_ly_nhap_xuat_hang;

use quan_ly_nhap_xuat_hang;

create table phieu_xuat(
so_px  int not null auto_increment primary key,
ngay_xuat datetime
);

create table vat_tu(
ma_vtu int not null auto_increment primary key,
ten_vtu varchar(50)

);


create table phieu_nhap(
so_pn int not null auto_increment primary key,
ngay_nhap datetime

);

create table don_dh(
so_dh int not null auto_increment primary key,
ngay_dh datetime
);

create table nha_cc(
ma_ncc int not null auto_increment primary key,
ten_ncc varchar(50),
dia_chi varchar(50),
so_dt int
);