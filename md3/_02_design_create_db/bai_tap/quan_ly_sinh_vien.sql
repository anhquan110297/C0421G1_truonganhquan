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
    customer_id int not null unique,
    order_date datetime not null,
    order_price float not null,
    foreign key (customer_id) references customer(customer_id)
);
create table product (
	product_id int auto_increment not null primary key,
    product_name varchar(30) not null,
    product_price float not null
);
create table order_details (
	order_id int not null unique,
    product_id int not null unique,
    order_quantity int not null,
    primary key (order_id, product_id),
	foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product (product_id)
);

