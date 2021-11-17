drop database if exists quan_ly_nhap_xuat_hang;

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

create table nha_cc(
ma_ncc int not null auto_increment primary key,
ten_ncc varchar(50),
dia_chi varchar(50)
);

create table chitiet_phieuxuat(
so_px int,
ma_vtu int,
dg_xuat float,
sl_xuat float,
primary key(so_px,ma_vtu),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table chitiet_phieunhap(
so_pn int,
ma_vtu int,
dg_nhap float,
sl_nhap float,
primary key(so_pn,ma_vtu),
foreign key(so_pn) references phieu_nhap(so_pn),
foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table don_dh(
so_dh int not null auto_increment primary key,
ngay_dh datetime,
nha_cc_ma_ncc int, 
foreign key(nha_cc_ma_ncc) references nha_cc(ma_ncc)
);

create table chitiet_donhang(
so_dh int,
ma_vtu int,
primary key(so_dh,ma_vtu),
foreign key(so_dh) references don_dh(so_dh),
foreign key(ma_vtu) references vat_tu(ma_vtu)
);


create table ncc_sdt(
ma_ncc int,
sdt int,
primary key(ma_ncc,sdt),
foreign key(ma_ncc) references nha_cc(ma_ncc)
);