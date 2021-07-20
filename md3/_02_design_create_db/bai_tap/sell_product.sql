DROP DATABASE IF EXISTS sell_management;
CREATE DATABASE sell_management;
USE sell_management;
create table customer (
	customer_id int auto_increment not null primary key,
    customer_name varchar(50) not null,
    customer_age int check (customer_age between 18 and 100)
);
create table `order` (
	order_id int auto_increment not null primary key,
    customer_id int not null,
    order_date datetime not null,
    order_price float,
    foreign key (customer_id) references customer(customer_id)
);
create table product (
	product_id int auto_increment not null primary key,
    product_name varchar(30) not null,
    product_price float not null
);
create table order_details (
	order_id int not null,
    product_id int not null,
    order_quantity int not null,
    primary key (order_id, product_id),
	foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product (product_id)
);

INSERT into customer (customer_name,customer_age)
values ('Minh Quan',18),('Ngoc Oanh',20),('Hong Ha',50);

INSERT into `order` (customer_id,order_date)
values (1,'2006-3-21'),(2,'2006-3-23'),('1','2006-3-16');

INSERT into product (product_name,product_price)
values ('May Giat',3),('Tu Lanh',5),('Dieu Hoa',7),('Quat',1),('Bep Dien',2);

INSERT into `order_details` (order_id,product_id,order_quantity)
values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);





