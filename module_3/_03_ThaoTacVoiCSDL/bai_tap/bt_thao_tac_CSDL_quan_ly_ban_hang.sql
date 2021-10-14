drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
cId int  auto_increment primary key,
cName varchar(20) not null,
cAge int
);

create table order_(
oId int auto_increment primary key,
cId int,
oDate datetime,
oTotalPrice float,
foreign key (cId) references customer (cId)
);

create table product(
pId int auto_increment primary key,
pName varchar(50),
pPrice float
);

create table detail(
oId int,
pId int,
oQuantity int,
primary key (oId,pId),
foreign key(oId) references order_(oId),
foreign key(pId) references product(pId)
);

insert into customer (cId,cName,cAge)
values(1,"Minh Quan",10);

insert into customer (cId,cName,cAge)
values(2,"Ngoc Oanh",20);

insert into customer (cId,cName,cAge)
values(3,"Hong Ha",50);

insert into order_ (oId,cId,oDate,oTotalPrice)
values (1,1,'2006-03/21',Null);

insert into order_ (oId,cId,oDate,oTotalPrice)
values (2,2,'2006-03-23',Null);

insert into order_ (oId,cId,oDate,oTotalPrice)
values (3,1,'2006-03-16',Null);

insert into product (pId,pName,pPrice)
values (1,"May Giat",3);

insert into product (pId,pName,pPrice)
values (2,"Tu Lanh",5);

insert into product (pId,pName,pPrice)
values (3,"Dieu Hoa",7);

insert into product (pId,pName,pPrice)
values (4,"Quat",1);

insert into product (pId,pName,pPrice)
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
select oId,oDate,oTotalPrice
from order_;

#Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
-- select customer.cName,product.pName
select *
from customer join order_ 
on customer.cId = order_.cId
join detail 
on order_.oId = detail.oId
join product
on product.pId = detail.pId;

#Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
-- select customer.cName, customer.cId,order_.oId
select *
from customer left join order_ 
on customer.cId = order_.cId
where order_.oId is null;

# Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
# (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
# Giá bán của từng loại được tính = odQTY*pPrice)

select customer.cName,order_.oId,order_.oDate,sum(detail.oQuantity * product.pPrice) as 'total_price'
from customer join order_
on customer.cId = order_.oId
join detail 
on detail.oId = order_.oId
join product 
on product.pId = detail.pId
group by customer.cName;

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


