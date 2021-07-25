drop DATABASE IF EXISTS demo;
create database demo;
use demo;
create table products (
	id int PRIMARY key not null AUTO_INCREMENT,
    product_name VARCHAR(50),
    product_code VARCHAR(50),
    product_price FLOAT,
    product_amount int,
    product_description VARCHAR (50),
    product_status BOOLEAN
);

INSERT INTO products (product_name,product_code,product_price,product_amount,product_description,product_status)
values ('gaugau','TLHT-1234',500,2,'hihihi',1),
		('meowmeow','TLHT-3234',300,3,'hahahah',1),
        ('chipchip','TLHT-1235',200,5,'hohohoho',1);
        
ALTER TABLE products ADD INDEX idx_products(product_name,product_price);        
ALTER TABLE products ADD INDEX idx_product(product_code);
EXPLAIN SELECT * FROM products WHERE product_name = 'gaugau';         
EXPLAIN SELECT * FROM products WHERE product_code = 'TLHT-3234';


-- Tạo view lấy về các thông tin: productCode, productName, 
-- productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

create VIEW new_view
as
select product_code,product_name,product_price,product_status
from products;

CREATE OR REPLACE VIEW new_view AS
SELECT product_price,product_name
FROM products
WHERE product_price > 200; 

DROP VIEW new_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

delimiter //
create PROCEDURE get_all_profile ()
BEGIN
	select *
    from products;
end;
// delimiter ;

call get_all_profile();
	
delimiter //
-- Tạo store procedure thêm một sản phẩm mới
create PROCEDURE add_new_product (
    new_product_name VARCHAR(50),
    new_product_code VARCHAR(50),
    new_product_price FLOAT,
    new_product_amount int,
    new_product_description VARCHAR (50),
    new_product_status BOOLEAN
)
begin
	INSERT INTO products (product_name,product_code,product_price,product_amount,product_description,product_status)
    values (
		new_product_name,new_product_code,new_product_price,new_product_amount,new_product_description,new_product_status
    );
end;
// delimiter ;

CALL add_new_product ('anhquan','hihihiihih',400,2,'test',1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create PROCEDURE edit_by_id (
	id_hihi INT,
    new_product_name VARCHAR(50),
    new_product_code VARCHAR(50),
    new_product_price FLOAT,
    new_product_amount int,
    new_product_description VARCHAR (50),
    new_product_status BOOLEAN
)
begin
	UPDATE products
	SET product_name = new_product_name, product_code = new_product_code, product_price = new_product_price,
		product_price = new_product_price, product_amount = new_product_amount , product_description = new_product_description,
        product_status = product_status
	WHERE id = id_hihi;
end;
// delimiter ;

call edit_by_id(4,'hihihi','hihiconcac','111',2,'testconcac',1);
call get_all_profile();

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create PROCEDURE delete_product_by_id (id_input int )
BEGIN
DELETE FROM products 
WHERE id = id_input;
end;
// delimiter ;
call delete_product_by_id (4);
call get_all_profile();
         