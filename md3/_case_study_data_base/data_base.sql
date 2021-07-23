drop DATABASE if EXISTS furama_resort;
CREATE DATABASE furama_resort;
use furama_resort;
-- --khoi tao bang
create table vi_tri (id_vi_tri INT AUTO_INCREMENT PRIMARY key not null, ten_vi_tri VARCHAR(45));
create table trinh_do (id_trinh_do int AUTO_INCREMENT PRIMARY key not null, trinh_do varchar(45));
create table bo_phan (id_bo_phan int AUTO_INCREMENT PRIMARY key not null, ten_bo_phan varchar(45));
create table nhan_vien(
	id_nhan_vien int AUTO_INCREMENT PRIMARY key not null,
    ten_nhan_vien varchar(50) not null,
    id_vi_tri int not null,
    id_trinh_do int not null,
    id_bo_phan int not null,
    ngay_sinh date,
    so_cmnd VARCHAR (9),
    so_dien_thoai VARCHAR(45),
    email varchar (45),
    dia_chi VARCHAR (45),
    FOREIGN KEY (id_vi_tri) REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do) REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan) REFERENCES bo_phan (id_bo_phan)
);
-- khach hang
create table loai_khach (
	id_loai_khach int AUTO_INCREMENT PRIMARY key not null,
    ten_loai_khach varchar(45)
);
create table khach_hang (
	id_khach_hang int AUTO_INCREMENT PRIMARY KEY not null,
    id_loai_khach int not null,
    ten_khach_hang VARCHAR (45),
    ngay_sinh date,
    so_cmnd VARCHAR(45),
    email varchar(45),
    dia_chi_khach_hang VARCHAR(45),
    foreign key (id_loai_khach) REFERENCES loai_khach (id_loai_khach)
);
-- dich vu
CREATE table kieu_thue (
	id_kieu_thue int AUTO_INCREMENT PRIMARY key not null,
    ten_kieu_thue VARCHAR (45),
    gia int
);
create table loai_dich_vu (
	id_loai_dich_vu int AUTO_INCREMENT PRIMARY key not null,
    ten_loai_dich_vu VARCHAR(45)
);
create table dich_vu(
	id_dich_vu int AUTO_INCREMENT PRIMARY key not null,
    id_kieu_thue int not null,
    id_loai_dich_vu int not null,
    ten_dich_vu VARCHAR (45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da int,
    chi_phi_thue VARCHAR(45),
    trang_Thai VARCHAR(45),
    foreign key (id_kieu_thue) references kieu_thue (id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu (id_loai_dich_vu)
);

create table dich_vu_di_kem (
	id_dich_vu_di_kem int AUTO_INCREMENT PRIMARY key not null,
    ten_dich_vu_di_kem VARCHAR(45),
    gia int,
    trang_thai_kha_dung VARCHAR(45)
);
create table hop_dong(
	id_hop_dong int AUTO_INCREMENT PRIMARY key not null,
    id_nhan_vien int not null,
    id_khach_hang int not null,
    id_dich_vu int not null,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc_hop_dong date,
    tien_dat_coc int,
    tong_tien int,
    FOREIGN KEY (id_nhan_vien) references nhan_vien (id_nhan_vien),
    FOREIGN KEY (id_khach_hang) references khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu) references dich_vu (id_dich_vu)
);

create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int PRIMARY key AUTO_INCREMENT not null,
    so_luong int,
    id_hop_dong int not null,
    id_dich_vu_di_kem int not null,
    FOREIGN KEY (id_hop_dong) REFERENCES hop_dong (id_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem (id_dich_vu_di_kem)
);


