use furama_resort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một 
-- trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select *
from nhan_vien
WHERE (ten_nhan_vien like 'h%' or 
ten_nhan_vien like 't%' 
or ten_nhan_vien like 'k%') 
and length(ten_nhan_vien) < 16;

-- 3.	Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT *
from khach_hang
where (
(SELECT DATEDIFF(curdate(), khach_hang.ngay_sinh) / 365)
BETWEEN 18 and 50) and 
(khach_hang.dia_chi_khach_hang ='Đà Nẵng' or khach_hang.dia_chi_khach_hang = 'Quảng trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ten_khach_hang,kh.id_khach_hang, count(hd.id_khach_hang) as hihi
from khach_hang kh
    inner join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
	right join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
WHERE kh.id_loai_khach = 1
group by hd.id_khach_hang
ORDER BY hihi;

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT kh.id_khach_hang,kh.ten_khach_hang,lk.ten_loai_khach,hd.id_hop_dong,
ten_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,
sum(dv.chi_phi_thue +(hdct.so_luong*dvdk.gia) ) as Tong_Tien
from khach_hang kh
	LEFT join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
    LEFT join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
    LEFT join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
    LEFT join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    LEFT join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem     
GROUP BY kh.id_khach_hang;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
-- từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select kh.ten_khach_hang,dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
	LEFT JOIN loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
	LEFT JOIN hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
	LEFT JOIN khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
WHERE hd.ngay_lam_hop_dong not in 
(SELECT ngay_lam_hop_dong
from hop_dong
WHERE (year(hd.ngay_lam_hop_dong) = '2019' and month(hd.ngay_lam_hop_dong) in (1,2,3))
);
-- QUÂN NON QUÁ
-- QUÂN NON QUÁ
-- QUÂN NON QUÁ
-- QUÂN NON QUÁ

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng 
-- trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
SELECT kh.ten_khach_hang,dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
	LEFT JOIN loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
	LEFT JOIN hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
	LEFT JOIN khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
WHERE hd.ngay_lam_hop_dong NOT in (
SELECT ngay_lam_hop_dong
FROM hop_dong
WHERE year(ngay_lam_hop_dong) = '2019'
) and hd.ngay_lam_hop_dong IN (
SELECT ngay_lam_hop_dong
FROM hop_dong
WHERE year(ngay_lam_hop_dong) = '2018'
);
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống,
--  với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select ten_khach_hang
FROM khach_hang
GROUP BY ten_khach_hang;

select DISTINCT ten_khach_hang
FROM khach_hang;

select ten_khach_hang
FROM khach_hang
UNION
select ten_khach_hang
FROM khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select kh.id_khach_hang,kh.ten_khach_hang,hd.ngay_lam_hop_dong,month(hd.ngay_lam_hop_dong) as `Month`
from khach_hang kh
	inner JOIN hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
WHERE year(hd.ngay_lam_hop_dong) = 2019
group by month(hd.ngay_lam_hop_dong);




    

    
