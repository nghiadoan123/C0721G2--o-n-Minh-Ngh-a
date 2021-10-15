drop database if exists furama;
create database furama;
use furama;
SET SQL_SAFE_UPDATES = 0;
create table vitri(
id_vitri int auto_increment primary key,
ten_vi_tri varchar(45)
);

insert into vitri 
values (1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');


create table trinh_do(
id_trinh_do int auto_increment primary key,
trinh_do varchar(45)
);


insert into trinh_do  values
(1,'DH'),(2,'CD'),(3,'TC');


create table bo_phan(
id_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);

insert into bo_phan values 
(1,'operation'),(2,'kitchen'),(3,'restaurant');

create table loai_khach(
id_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45)
);

insert into loai_khach values
(1,'Diamond'),(2,'Gold'),(3,'Sliver'),(4,'Member');

create table kieu_thue(
id_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45),
gia int
);

insert into kieu_thue values (1,'Day',1000),(2,'Week',5000),(3,'Month',1500);

create table loai_dich_vu(
id_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);

insert into loai_dich_vu(id_loai_dich_vu,ten_loai_dich_vu) values 
(1,'Villa'),(2,'House'),(3,'Room');

create table nhan_vien(
id_nhan_vien int auto_increment primary key,
ho_ten varchar(45),
id_vitri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_CMTND varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_vitri) references vitri(id_vitri),
foreign key(id_trinh_do) references trinh_do(id_trinh_do),
foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

insert into nhan_vien (id_nhan_vien, ho_ten,id_vitri,id_trinh_do, id_bo_phan, ngay_sinh) values
(1001,'Truong Hung',1,2,3,'1989-09-09'),
(1002,'Nguyen Thao',2,3,3,'1990-09-08'),
(1003,'Hoang Khoi',3,3,2,'1989-08-08'),
(1004,'Nguyen Hung',3,2,3,'1989-08-08');

create table khach_hang(
id_khach_hang int auto_increment primary key,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,dia_chi) values
(101,2,'Nguyen Anh', '1981-10-20', 'Da Nang'),
(102,3,'Nguyen Binh', '1988-11-20', 'Quang Tri'),
(103,2,'Nguyen An', '1963-10-20', 'Quang Nam'),
(104,4,'Nguyen Trai', '1982-09-20', 'Da Nang'),
(105,4,'Doan Truong', '1983-11-20', 'Hue'),
(106,4,'Dinh Thang', '1985-06-20', 'Ho Chi Minh');

create table dich_vu(
id_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
dien_tich_ho_boi int,
so_nguoi_toi_da int,
chi_phi_thue int,
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai bit,
foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);


insert dich_vu(id_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,id_kieu_thue,dien_tich_ho_boi,so_tang,id_loai_dich_vu,trang_thai)
values
(1,'Villa',500,500,6,1,30,2,1,1);
insert dich_vu(id_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,id_kieu_thue,so_tang,id_loai_dich_vu,trang_thai)
values
(2,'House',300,300,5,2,3,2,1);
insert dich_vu(id_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,id_kieu_thue,id_loai_dich_vu,trang_thai)
values
(3,'Room',200,200,2,3,3,1);


create table hop_dong(
id_hop_dong int auto_increment primary key,
id_nhan_vien int ,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hd date ,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key(id_khach_hang) references khach_hang(id_khach_hang),
foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);

insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hd,ngay_ket_thuc,tien_dat_coc,tong_tien)
values (1,1001,101,1,'2021-08-11','2021-12-16',20,200),
       (2,1002,101,2,'2021-07-21','2021-10-10',30,300),
	   (3,1003,103,3,'2021-05-01','2021-08-12',5,50),
	   (4,1004,104,3,'2021-06-17','2021-09-13',10,1000),
	   (5,1003,105,3,'2019-01-10','2019-02-11',50,5000);

create table dich_vu_di_kem(
id_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung bit default 0
);

insert into dich_vu_di_kem (id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values
(1,'Freepool',50,3,1),(2,'Free Breakfast',20,5,1);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int auto_increment primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
-- unique(id_hopdong,id_dich_vu_di_kem),
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

insert into hop_dong_chi_tiet(id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong)
values (1,1,2,3),
       (2,2,1,4),
       (3,3,2,9),
       (4,2,1,5)
       ;
       


# 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống
# có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhan_vien;
select * from nhan_vien
where(ho_ten like 'H%' or ho_ten like'T%' or ho_ten like 'K%') and length(ho_ten) <=15;

# 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang;
select * from khach_hang
where  YEAR(current_date()) -YEAR(ngay_sinh)  >18 and YEAR(current_date()) -YEAR(ngay_sinh)<50 
and dia_chi like 'Da Nang' or dia_chi like 'Quang Tri' ;
-- where ((DATEDIFF(current_date(),khach_hang.ngay_sinh)/365) <50); -- cach 2
select * from hop_dong;
select * from dich_vu;

# 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
# Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Gold”.
select lk.ten_loai_khach,kh.ho_ten,hd.id_hop_dong,dv.ten_dich_vu,ldv.ten_loai_dich_vu,count(kh.ho_ten) as solanthue
from loai_khach lk 
join khach_hang kh
on lk.id_loai_khach = kh.id_loai_khach
join hop_dong hd
on kh.id_khach_hang = hd.id_khach_hang
join dich_vu dv
on dv.id_dich_vu = hd.id_dich_vu
join loai_dich_vu ldv
on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
where lk.ten_loai_khach = 'Gold'
group by kh.id_khach_hang
order by solanthue;


# 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
# cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hd,hd.ngay_ket_thuc,sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) as tongtien
from loai_khach lk 
left join khach_hang kh
on lk.id_loai_khach = kh.id_loai_khach
 left join hop_dong hd
on kh.id_khach_hang = hd.id_khach_hang
left join dich_vu dv
on dv.id_dich_vu = hd.id_dich_vu
left join hop_dong_chi_tiet hdct
on hdct.id_hop_dong = hd.id_hop_dong
left join dich_vu_di_kem dvdk
on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hd.id_hop_dong
order by kh.id_khach_hang;


# 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
# chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from hop_dong hd
join dich_vu dv
on hd.id_dich_vu = dv.id_dich_vu
join loai_dich_vu ldv
on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
where year(hd.ngay_lam_hd) <> '2019' and (month(hd.ngay_lam_hd) <> '1' or month(hd.ngay_lam_hd) <> '2' or month(hd.ngay_lam_hd) <> '3');

























