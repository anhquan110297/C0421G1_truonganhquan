use furama_resort_case_study_servlet;
INSERT INTO position (position_name)
VALUES ('Lễ tân'),
		('Phục vụ'),
        ('Chuyên viên'),
        ('Giám sát'),
        ('Quản lý'),
        ('Giám đốc');
INSERT INTO education_degree(education_degree_name)
VALUES ('Trung cấp'),
		('Cao đẳng'),
		('Đại học'),
		('Sau đại học');
INSERT INTO division(division_name)
VALUES ('Sale-Marketing'),
		('Hành chính'),
		('Phục vụ'),
		('Quản lý');
        
INSERT INTO customer_type(customer_type_name)
VALUES ('Diamond'),
		('Platinium'),
        ('Gold'),
        ('Silver'),
        ('Member');
INSERT INTO attach_service(attach_service_name,attach_service_cost,attach_service_unit, attach_service_status)
VALUES ('Massage',100000, 1, 'Khả dụng'),
		('Karaoke',50000,1, 'Khả dụng'),
        ('Thức ăn', 30000, 1, 'Khả dụng'),
        ('Nước uống', 20000, 1, 'Khả dụng' ),
        ('Thuê xe tham quan resort',250000,1, 'Khả dụng');
INSERT INTO service_type(service_type_name)
VALUES ('Villa'),
		('House'),
        ('Room');
INSERT INTO rent_type(rent_type_name,rent_type_cost)
VALUES ('Năm',600),
		('Tháng',500),
        ('Ngày',600),
        ('Giờ',60);
