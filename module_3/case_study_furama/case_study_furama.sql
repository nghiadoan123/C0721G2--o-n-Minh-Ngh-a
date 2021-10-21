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
(1,'Diamond'),(2,'Gold'),(3,'Sliver'),(4,'Member'),(5,'Platinum');

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

insert into nhan_vien (id_nhan_vien, ho_ten,id_vitri,id_trinh_do, id_bo_phan, ngay_sinh, so_CMTND, luong, sdt, email, dia_chi) values
(1001,'Truong Hung',1,2,3,'1989-09-09', 'A123456', 10, 0905112112, 'TruongHung@gmail.com', 'Hải Châu'),
(1002,'Nguyen Thao',2,3,3,'1990-09-08', 'A123457', 20, 0863159875, 'NguyenThao@gmail.com', 'Liên Chiểu'),
(1003,'Hoang Khoi',3,3,2,'1989-08-08', 'A123458', 30, 0121589789, 'HoangKhoi@gmail.com', 'Hải Châu'),
(1004,'Nguyen Hung',3,2,3,'1986-08-08', 'A123459', 30, 0987154698, 'NguyenHung@gmail.com', 'Hòa phú'),
(1005,'Nguyen Hoang',3,2,3,'1988-01-01', 'A123489', 30, 0121458987, 'NguyenHoang@gmail.com', 'Hòa Vang');

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


insert into khach_hang(id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, dia_chi) values
(101,5,'Nguyen Anh', '1981-10-20', 'Da Nang'),
(102,1,'Nguyen Binh', '1988-11-20', 'Quang Ngai'),
(103,2,'Nguyen An', '1963-10-20', 'Quang Nam'),
(104,1,'Nguyen Trai', '1982-09-20', 'Quang Ngai'),
(105,4,'Doan Truong', '1983-11-20', 'Hue'),
(106,2,'Nguyen Anh', '1981-10-20', 'Da Nang'),
(107,5,'Dinh Thang', '1985-06-20', 'Ho Chi Minh');

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
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) on delete set null,
foreign key(id_khach_hang) references khach_hang(id_khach_hang) on delete set null,
foreign key(id_dich_vu) references dich_vu(id_dich_vu) on delete set null 
);

insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hd,ngay_ket_thuc,tien_dat_coc,tong_tien)
values (1,1001,101,1,'2015-08-11','2016-12-16',20,12000),
       (2,1002,101,2,'2018-07-21','2018-10-10',30,300),
	   (3,1003,103,3,'2021-05-01','2021-08-12',5,50),
	   (4,1004,107,3,'2019-12-12','2019-12-19',10,1000),
	   (5,1003,107,2,'2019-10-10','2019-10-11',50,5000),
	   (6,1003,107,3,'2019-12-12','2019-12-15',50,11000);

create table dich_vu_di_kem(
id_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung bit default 0
);

insert into dich_vu_di_kem (id_dich_vu_di_kem, ten_dich_vu_di_kem, gia,don_vi,trang_thai_kha_dung) values
(1,'Freepool',50,3,1),(2,'Free Breakfast',20,5,1);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int auto_increment primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
-- unique(id_hopdong,id_dich_vu_di_kem),
foreign key(id_hop_dong) references hop_dong(id_hop_dong) on delete set null,
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem) on delete set null
);

insert into hop_dong_chi_tiet(id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong)
values (1,1,2,3),
       (2,2,1,4),
       (3,3,2,9),
       (4,5,1,25),
       (5,4,2,25),
       (6,6,2,5)
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
where lk.ten_loai_khach = 'Diamond'
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


# 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
 # nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from hop_dong hd
	join dich_vu dv
		on hd.id_dich_vu = dv.id_dich_vu
	join loai_dich_vu ldv
		on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
where year(hd.ngay_lam_hd) = '2018';

# 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
# cách 1
select distinct ho_ten
from khach_hang;

# cách 2
select ho_ten
from khach_hang 
group by ho_ten;

# cách 3

# 9.Thực hiện thống kê doanh thu theo tháng, 
# nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hd) as monthofyear, count(kh.id_khach_hang), kh.id_khach_hang
from hop_dong hd
	join khach_hang kh
			on hd.id_khach_hang = kh.id_khach_hang
where year(hd.ngay_lam_hd) = '2019'
group by kh.id_khach_hang, monthofyear
order by hd.ngay_lam_hd;

# 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
# Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
# (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong,hd.ngay_lam_hd, hd.ngay_ket_thuc, hd.tien_dat_coc, hdct.so_luong, count(hdct.id_dich_vu_di_kem) as count
from hop_dong hd
	join hop_dong_chi_tiet hdct
			on hd.id_hop_dong = hdct.id_hop_dong
	join dich_vu_di_kem dvdk
			on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hd.id_hop_dong;


# 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
# TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select kh.ho_ten,kh.dia_chi,lk.ten_loai_khach,dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem
from loai_khach lk 
	join khach_hang kh
		on lk.id_loai_khach = kh.id_loai_khach
	join hop_dong hd
		on kh.id_khach_hang = hd.id_khach_hang
	join dich_vu dv
		on dv.id_dich_vu = hd.id_dich_vu
	join hop_dong_chi_tiet hdct
		on hdct.id_hop_dong = hd.id_hop_dong
	join dich_vu_di_kem dvdk
		on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi = 'Vinh' or kh.dia_chi = 'Quang Ngai');

# 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
#(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
#nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019

select hd.id_hop_dong as id_hop_dong, nv.ho_ten as ten_nhan_vien, kh.ho_ten as ten_khach_hang,dv.id_dich_vu as id_dich_vu,
		dv.ten_dich_vu as ten_dich_vu, count(hdct.id_hop_dong_chi_tiet) as so_luong, hd.tong_tien
from khach_hang kh
	join hop_dong hd 
		on kh.id_khach_hang =  hd.id_khach_hang
    join nhan_vien nv 
		on nv.id_nhan_vien = hd.id_nhan_vien
    join dich_vu dv 
		on dv.id_dich_vu = hd.id_dich_vu
    join hop_dong_chi_tiet hdct 
		on hdct.id_hop_dong = hd.id_hop_dong
where hd.ngay_lam_hd  between '2019-10-01' and '2019-12-31' 
	group by  hd.id_hop_dong
		having id_dich_vu not in (
	select dv.id_dich_vu from  dich_vu dv
		join hop_dong hd  
			on dv.id_dich_vu = hd.id_dich_vu
        where hd.ngay_lam_hd between '2019-01-01' and '2019-06-30'
);

# 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng
	
select dvdk.id_dich_vu_di_kem , dvdk.ten_dich_vu_di_kem , dvdk.gia, dvdk.trang_thai_kha_dung ,  count(hdct.id_hop_dong_chi_tiet) as so_lan_su_dung
from dich_vu_di_kem dvdk
	join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem 
having so_lan_su_dung = (select max(t2.so_lan_su_dung) 
							from (select count(hdct.id_hop_dong_chi_tiet) as so_lan_su_dung
								from dich_vu_di_kem dvdk 
									join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem =  hdct.id_dich_vu_di_kem
								group by dvdk.id_dich_vu_di_kem
							) as t2
						);

#14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
# Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select kh.id_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,dv.id_dich_vu,hd.ngay_lam_hd,hd.ngay_ket_thuc,count(dvdk.id_dich_vu_di_kem) as count
from loai_khach lk 
	join khach_hang kh
		on lk.id_loai_khach = kh.id_loai_khach
	join hop_dong hd
		on kh.id_khach_hang = hd.id_khach_hang
	join dich_vu dv
		on dv.id_dich_vu = hd.id_dich_vu
	join hop_dong_chi_tiet hdct
		on hdct.id_hop_dong = hd.id_hop_dong
	join dich_vu_di_kem dvdk
		on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dv.ten_dich_vu
	having count=1;

# 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
# mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi, count(hd.id_hop_dong) as so_hop_dong
from vitri vt
	join nhan_vien nv
			on vt.id_vitri = nv.id_vitri
	join bo_phan bp
			on bp.id_bo_phan = nv.id_bo_phan
	join trinh_do td 
			on td.id_trinh_do = nv.id_trinh_do
	join hop_dong hd
			on hd.id_nhan_vien = nv.id_nhan_vien
	where hd.ngay_lam_hd between '2018-01-01' and '2019-12-30'
    group by nv.id_nhan_vien
		having  so_hop_dong <=3
		order by nv.ho_ten;
        
# 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhan_vien 
where nhan_vien.id_nhan_vien not in 
(select * from (select nv.id_nhan_vien 
from hop_dong hd
	join nhan_vien nv
		on hd.id_nhan_vien = nv.id_nhan_vien
where year(hd.ngay_lam_hd)  between '2017' and '2019'
group by nv.ho_ten) as id_nhan_vien);

# 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
# chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

SET SQL_SAFE_UPDATES = 0;
update khach_hang
set id_loai_khach = '5'
where khach_hang.id_loai_khach in (
select * from (select khach_hang.id_loai_khach
		from loai_khach lk 
			join khach_hang kh 
				on kh.id_loai_khach = lk.id_loai_khach
			join hop_dong hd
				on hd.id_khach_hang = kh.id_khach_hang
where year(hd.ngay_lam_hd) = '2019' and hd.tong_tien > 10000 and kh.id_loai_khach = '1'
	group by kh.id_khach_hang) as loai_khach
);
select * from khach_hang;


# 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

delete from  khach_hang kh
where kh.id_khach_hang in (
select * from (select kh.id_khach_hang
from hop_dong hd
	join khach_hang kh
		on kh.id_khach_hang = hd.id_khach_hang
where year(hd.ngay_lam_hd) < '2016'
	group by kh.id_khach_hang) as kh
);
 
 select * from khach_hang;

# 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dich_vu_di_kem dvdk
set dvdk.gia = dvdk.gia*2
where id_dich_vu_di_kem in(
select * from (select dvdk.id_dich_vu_di_kem
from loai_khach lk 
	join khach_hang kh
		on lk.id_loai_khach = kh.id_loai_khach
	join hop_dong hd
		on kh.id_khach_hang = hd.id_khach_hang
	join dich_vu dv
		on dv.id_dich_vu = hd.id_dich_vu
	join hop_dong_chi_tiet hdct
		on hdct.id_hop_dong = hd.id_hop_dong
	join dich_vu_di_kem dvdk
		on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where hdct.so_luong > 10) as hd
     group by dvdk.ten_dich_vu_di_kem
     ) ;

select * from dich_vu_di_kem;
# 20.Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
# thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select nv.id_nhan_vien, nv.ho_ten as ho_ten_nv, nv.email, nv.sdt, nv.ngay_sinh, nv.dia_chi ,
       kh.id_khach_hang, kh.ho_ten as ho_ten_kh, kh.email, kh.sdt, kh.ngay_sinh, kh.dia_chi

from nhan_vien nv 
	left join hop_dong hd
		on nv.id_nhan_vien = hd.id_nhan_vien
	right join khach_hang kh
		on kh.id_khach_hang = hd.id_khach_hang
group by nv.id_nhan_vien, kh.id_khach_hang
	order by nv.id_nhan_vien;

#21.Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và 
# đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ với ngày lập hợp đồng là “12/12/2019”

drop view if exists v_nhan_vien;
create view v_nhan_vien 
as
select nv.id_nhan_vien, nv.dia_chi as nvdc, hd.id_hop_dong as idhd, count(kh.id_khach_hang) as count_
from nhan_vien nv 
	join hop_dong hd
		on nv.id_nhan_vien = hd.id_nhan_vien
	join khach_hang kh
		on hd.id_khach_hang = kh.id_khach_hang
where hd.ngay_lam_hd = '2019-12-12'
group by nv.id_nhan_vien
    having  count_ > 0;

select * from v_nhan_vien;

#22.Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
# đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.

update nhan_vien nv
set nv.dia_chi = 'Liển  Chiểu'
where nv.id_nhan_vien in (
		select bang_gia.id_nhan_vien from (
			select v.id_nhan_vien from v_nhan_vien as v
            ) as bang_gia
	);
select * from v_nhan_vien;

-- update v_nhan_vien
-- set v_nhan_vien.dia_chi = 'Liên Chiểu';
-- select * from v_nhan_vien;

#23.Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng 
# được truyền vào như là 1 tham số của Sp_1

drop procedure if exists sp_1; 
delimiter //
create procedure sp_1(id int)
begin
	delete from khach_hang
	where id_khach_hang = id;
	select* from khach_hang;
end//
delimiter ;
call sp_1(104);

#24.Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu 
# Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
# với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

drop procedure if exists sp_2;
delimiter //
create procedure sp_2(ip_id_nhan_vien int, ip_id_hop_dong int, ip_id_khach_hang int, ip_id_dich_vu int,ip_ngay_lam_hd date, ip_ngay_ket_thuc date, ip_tien_dat_coc int, ip_tong_tien int)
begin
	if ip_id_nhan_vien in (select id_nhan_vien from nhan_vien) and ip_id_khach_hang in (select id_khach_hang from khach_hang)
		then 
			insert into hop_dong(id_nhan_vien, id_hop_dong,id_khach_hang, id_dich_vu
                         , ngay_lam_hd, ngay_ket_thuc, tien_dat_coc, tong_tien)
    values(ip_id_nhan_vien, ip_id_hop_dong, ip_id_khach_hang, ip_id_dich_vu, 
              ip_ngay_lam_hd, ip_ngay_ket_thuc, ip_tien_dat_coc,ip_tong_tien);
	else 
		select concat('id nhan vien khong ton tai',ip_id_nhan_vien ) as id_nv;
         select concat('id khach hang khong ton tai',ip_id_khach_hang ) as id_kh;
	end if;
end //
delimiter ;

call sp_2(1004,13, 1010, 1, '2021-10-10', '2021-10-19', 200,2000);
select * from hop_dong;


# 25.Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong 
# thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

-- delimiter //
-- create trigger tr_1
-- after delete
-- on hop_dong for each row
-- begin
-- create temporary table bang_tam (select count(id_hop_dong) as count_
--      from hop_dong);
-- 	 set @temp= (select count_ from bang_tam);
-- end //
-- delimiter ;

-- drop trigger tr_1;

-- delete from hop_dong
-- where id_hop_dong = 5;

-- select @temp;

-- #26.Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, 
-- #cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- #Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- #Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo
--  #“Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
--  
-- delimiter //
-- CREATE TRIGGER  tr_2
-- before update
-- ON hop_dong FOR EACH ROW 
-- BEGIN
-- 	if datediff(new.ngay_ket_thuc,old.ngay_lam_hd) >2
--     then set  @bien_tam = (select "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày");
--     end if;
-- END //
-- delimiter ;

-- DROP TRIGGER tr_2;

-- update hop_dong
-- set hop_dong.ngay_ket_thuc = "2019-12-01"
-- where id_hop_dong = 6;

-- select @bien_tam;
 
 
# 27.Tạo user function thực hiện yêu cầu sau:
# a.Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
# b.Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu 
# làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ 
# (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng).
# Mã của Khách hàng được truyền vào như là 1 tham số của function này.


# b.Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu 
-- delimiter //
-- create function func_2(id_kh int)
-- returns int
-- deterministic
-- begin
-- 	declare count_max int;
--     set count_max = (select max(datediff(ngay_lam_hd,ngay_ket_thuc)) as max_day
--     from hop_dong hd
-- 		join khach_hang kh
-- 			on hd.id_khach_hang = hd.id_khach_hang
-- 		where id_kh = kh.id_khach_hang);
--         return count_max;
-- end //
-- delimiter ;

-- drop function func_2;

-- select func_2(102);

 #a.Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
-- delimiter //
-- create function func_1()
-- returns int
-- deterministic
-- begin
-- 	declare sum int;
--     set sum = (select count(dv.id_dich_vu) as count_
--     from dich_vu dv
-- 		join hop_dong hd
-- 			on hd.id_dich_vu = dv.id_dich_vu
-- 		where hd.tong_tien > 50);
--         return sum;
-- end //
-- delimiter ;

-- drop function func_1;
-- select func_1();

#28.Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
#từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) 
#và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.



















