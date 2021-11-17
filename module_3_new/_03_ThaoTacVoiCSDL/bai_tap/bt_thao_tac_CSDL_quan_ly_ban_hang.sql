drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int  auto_increment primary key,
c_name varchar(20) not null,
c_age int
);

create table order_(
o_id int auto_increment primary key,
c_id int,
o_date datetime,
o_total_price float,
foreign key (c_id) references customer (c_id)
);

create table product(
p_id int auto_increment primary key,
p_name varchar(50),
p_price float
);

create table detail(
o_id int,
p_id int,
o_quantity int,
primary key (o_id,p_id),
foreign key(o_id) references order_(o_id),
foreign key(p_id) references product(p_id)
);

insert into customer (c_id,c_name,c_age)
values(1,"Minh Quan",10);

insert into customer (c_id,c_name,c_age)
values(2,"Ngoc Oanh",20);

insert into customer (c_id,c_name,c_age)
values(3,"Hong Ha",50);

insert into order_ (o_id,c_id,o_date,o_total_price)
values (1,1,'2006-03/21',Null);

insert into order_ (o_id,c_id,o_date,o_total_price)
values (2,2,'2006-03-23',Null);

insert into order_ (o_id,c_id,o_date,o_total_price)
values (3,1,'2006-03-16',Null);

insert into product (p_id,p_name,p_price)
values (1,"May Giat",3);

insert into product (p_id,p_name,p_price)
values (2,"Tu Lanh",5);

insert into product (p_id,p_name,p_price)
values (3,"Dieu Hoa",7);

insert into product (p_id,p_name,p_price)
values (4,"Quat",1);

insert into product (p_id,p_name,p_price)
values (5,"Bep Dien",2);

insert into detail 
values (1,1,3),
	   (1,3,7),
       (1,4,2),
       (2,1,1),
       (3,1,8),
       (2,5,4),
       (2,3,3);
       
select * from customer;
select * from order_;
select * from product;
select * from detail;

# Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id,o_date,o_total_price
from order_;

#Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
-- select customer.cName,product.pName
select *
from customer join order_ 
on customer.c_id = order_.c_id
join detail 
on order_.o_id = detail.o_id
join product
on product.p_id = detail.p_id;

#Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
-- select customer.cName, customer.cId,order_.oId
select *
from customer left join order_ 
on customer.c_id = order_.c_id
where order_.o_id is null;

# Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
# (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
# Giá bán của từng loại được tính = odQTY*pPrice)

select ct.c_name, od.o_id, od.o_date, sum(dt.o_quantity * pd.p_price) as 'total_price'
from customer ct join order_ od
on ct.c_id = od.o_id
join detail dt
on dt.o_id = od.o_id
join product pd
on pd.p_id = dt.p_id
group by ct.c_name;

-- select now() from customer; hien ngay gio hien tai
-- select length(cName) as lengthofnamecustomer from customer; hien thi chieu dai cua name trong bang
-- select pName,sum(pPrice) from product
-- group by pName 
-- order by pName desc;
-- select ucase(pName) from product; chuyển tát cả sang chữ hoa
-- select lcase(pName) from product;  chuyển tát cả về chữ thường
-- select min(pId) from product; tìm min trong pId
-- select max(pId) from product; tìm max trong pId
-- select count(pId) from detail đếm có bao nhiêu pId với oId =1
-- where oId = 1;


