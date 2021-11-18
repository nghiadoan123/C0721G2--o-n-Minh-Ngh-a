drop database if exists view_index_store_procedure;

create database view_index_store_procedure;

use view_index_store_procedure;

create table product(
id int primary key auto_increment,
product_code varchar(45) unique,
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status bit
);

insert into product(id, product_code, product_name, product_price, product_amount, product_description, product_status)
values (1, 1001, 'product1', 200, 2, 'sony_1', 1),
	   (2, 1002, 'product2', 100, 1, 'sony_2', 1),
       (3, 1003, 'product3', 300, 2, 'nokia_1', 1),
       (4, 1004, 'product4', 400, 2, 'nokia_2', 1);
       

-- BUOC 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
explain select * from product where product_code = '1004';
-- khi chua tao index thi tim kiem theo IMPLICIT INDEX

create unique index product_code_index 
	on product(product_code);
explain select * from product where product_code = '1004';
-- sau khi tao index thi tim kiem theo product_code_index

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index idx_name_price
	on product (product_name, product_price);
explain select * from product where product_name = 'product3' and product_price = 300;


-- BUOC 4:
-- Tạo view lấy về các thông tin: product_code, product_name, product_price, product_status từ bảng products.
create view view_product as
select product_code,product_name,product_price,product_status 
from product;
select *
from view_product;

-- cap nhap view
update view_product
set product_price = 1000
where product_name = 'product4'; 
select *
from view_product;

-- xoa view
-- drop view view_product;
drop view view_product;


# Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id

drop procedure if exists find_all_product;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //

create procedure find_all_product()

begin

  select * from product;

end //

delimiter ;

call find_all_product();

-- Tạo store procedure thêm một sản phẩm mới
drop procedure if exists insert_product;
delimiter //

create procedure insert_product(id int ,product_code varchar(45), product_name varchar(45), product_price double,
product_amount int, product_description varchar(45), product_status bit)

begin

  insert into product(id, product_code, product_name, product_price, product_amount, product_description, product_status)
  values (id, product_code, product_name, product_price, product_amount, product_description, product_status);

end //

delimiter ;

call insert_product(5,1005,'product10',20000,3,'samsung1',0);
call find_all_product();


-- Tạo store procedure sửa thông tin sản phẩm theo id
drop procedure if exists edit_id_product;
delimiter //

create procedure edit_id_product(input_id int ,input_product_code varchar(45), input_product_name varchar(45), input_product_price double,
input_product_amount int, input_product_description varchar(45), input_product_status bit)

begin

	update product
    set id = input_id, product_code= input_product_code, product_name = input_product_name, product_price = input_product_price,
    product_amount = input_product_amount, product_description = input_product_description, product_status = input_product_status
     where id = input_id;
    
end //

delimiter ;

call edit_id_product(1, 1001001, 'product100', 200020, 20, 'sony_121', 0);
call find_all_product();

-- Tạo store procedure xoá sản phẩm theo id
drop procedure if exists delete_product;
delimiter //

create procedure delete_product(input_id int)

begin

	delete from product
    where id = input_id;
    
end //

delimiter ;

call delete_product(1);
call  find_all_product();












