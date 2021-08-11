drop DATABASE if EXISTS furama_resort_case_study_servlet;
create database furama_resort_case_study_servlet;
use furama_resort_case_study_servlet;
create table position (
	position_id int not null AUTO_INCREMENT PRIMARY KEY,
    position_name varchar(50)
    );
CREATE table education_degree (
	education_degree_id int not null AUTO_INCREMENT PRIMARY key,
    education_degree_name varchar(45)
    );
    CREATE table division (
	division_id int not null AUTO_INCREMENT PRIMARY key,
    division_name varchar(45)
    ); 
    
    create table `role`(
		role_id int not null primary key auto_increment,
        role_name varchar(50) not null
    );
    create table `user` (
		user_name varchar(255) not null primary key,
        `password` varchar(255) not null
    );
        create table  user_role (
		role_id int,
        user_name varchar(255),
        PRIMARY key (role_id,user_name),
        FOREIGN KEY (role_id) REFERENCES `role` (role_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN KEY (user_name) references `user` (user_name)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    create table employee (
		employee_id int not null primary key AUTO_INCREMENT,
        employee_name varchar (45),
        employee_birthday date,
        employee_id_card varchar(45),
        employee_salary double,
        employee_phone varchar(45),
        employee_email varchar(45),
        employee_address varchar (45),
		position_id int,
        education_degree_id int,
        division_id int,
        user_name varchar (50),
        FOREIGN key (position_id) REFERENCES position (position_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN key (education_degree_id) REFERENCES education_degree (education_degree_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN key (division_id) REFERENCES division (division_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN key (user_name) REFERENCES `user` (user_name)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    create table attach_service(
		attach_service_id int not null PRIMARY key AUTO_INCREMENT,
        attach_service_cost double,
        attach_service_name VARCHAR(45),
        attach_service_unit int,
        attach_service_status varchar(50)
    );
    create table rent_type (
		rent_type_id int not null primary key AUTO_INCREMENT,
        rent_type_name varchar (45),
        rent_type_cost double
    );
    create table service_type (
		service_type_id int not null primary key AUTO_INCREMENT,
        service_type_name varchar(45)
	);
    create table service (
		service_id int not null PRIMARY key AUTO_INCREMENT,
        service_name varchar(45),
        service_are int,
        service_coost double,
        service_max_people int,
        standar_room VARCHAR (45),
        description_other_converience varchar(45),
        pool_area double,
        number_of_floors int,
        rent_type_id int,
        service_type_id int,
        FOREIGN KEY (rent_type_id) REFERENCES rent_type (rent_type_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN KEY (service_type_id) REFERENCES service_type (service_type_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    create table customer_type (
		customer_type_id int not null primary key AUTO_INCREMENT,
        customer_type_name varchar(45)
    );
    create table customer (
		customer_id int not null PRIMARY key AUTO_INCREMENT,
        customer_name varchar(45),
        customer_birthday DATE,
        customer_gender BIT(1),
        customer_id_card VARCHAR (45),
        customer_phone varchar(45),
        customer_email VARCHAR(45),
        customer_address varchar (45),
        customer_type_id int,
        FOREIGN KEY (customer_type_id) REFERENCES customer_type (customer_type_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    create table contract (
		contract_id int not null AUTO_INCREMENT PRIMARY key,
        contract_start_date DATETIME,
        contract_end_date datetime,
        contract_deposit double,
        contract_taltal_money double,
        employee_id int,
        customer_id int,
        service_id int,
        FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN KEY (service_id) REFERENCES service (service_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    create table contract_detail (
		contract_detail_id int not null AUTO_INCREMENT PRIMARY key,
        quantity int,
        contract_id int,
        attach_service_id int,
        FOREIGN KEY (contract_id) REFERENCES contract (contract_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE,
        FOREIGN KEY (attach_service_id) REFERENCES attach_service (attach_service_id)
        ON UPDATE CASCADE 
		ON DELETE CASCADE
    );
    
    
    