drop database if exists student_management;
create database student_management;
use student_management;

create table type_of_class(
	id int PRIMARY key,
    `name` varchar(10)
);

create table instructor (
	id int PRIMARY key AUTO_INCREMENT,
    `name` VARCHAR(50),
    date_of_birth date
);

create table account_james (
	`account` varchar(50) PRIMARY key,
    `password` VARCHAR(50)
);

create table class (
	id int AUTO_INCREMENT,
    `name` VARCHAR (7),
    type_of_class_id int,
    
    PRIMARY KEY (id),
    FOREIGN KEY (type_of_class_id) REFERENCES type_of_class (id)
);

create table student (
	id int PRIMARY key AUTO_INCREMENT,
    `name` VARCHAR (50),
    date_of_birth date,
    email varchar (50),
    account_james_account varchar (50),
    class_id int,
    
    FOREIGN KEY (account_james_account)
		REFERENCES account_james (`account`),
    CONSTRAINT fk_student_class FOREIGN KEY (class_id)
		REFERENCES class (id)
);

CREATE table instructor_teach_class (
	class_id INT,
    instructor_id int,
    
    PRIMARY KEY (Class_id, instructor_id),
    FOREIGN KEY (class_id)
		REFERENCES class (id),
    FOREIGN KEY (instructor_id)
		REFERENCES instructor (id)
);