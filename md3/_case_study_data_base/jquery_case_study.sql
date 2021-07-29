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
	INNER join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
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

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT hd.id_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc_hop_dong,hd.tien_dat_coc,count(hdct.id_dich_vu_di_kem) as so_luong_dich_vu_di_kem
from hop_dong hd
	inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
GROUP BY hd.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng 
-- bởi những Khách hàng có TenLoaiKhachHang 
-- là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,kh.id_khach_hang,kh.ten_khach_hang,kh.id_loai_khach,lk.ten_loai_khach,kh.dia_chi_khach_hang
from khach_hang kh
	inner join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
    inner join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
    inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where kh.dia_chi_khach_hang in (
	select dia_chi_khach_hang
    from khach_hang
    where dia_chi_khach_hang = 'Vinh' or dia_chi_khach_hang = 'Quảng Trị'
) and kh.id_khach_hang in (
	select id_loai_khach
    from khach_hang
    where id_loai_khach = 1
);

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hd.id_hop_dong,nv.ten_nhan_vien,kh.ten_khach_hang,kh.so_dien_thoai,dv.ten_dich_vu,count(hdct.id_dich_vu_di_kem) as so_luong_dich_vu_di_kem,hd.tien_dat_coc
from khach_hang kh
	right join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
    right join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
    right join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
    right join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    right join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where EXISTS (
	SELECT tien_dat_coc
    from hop_dong
    where  month(ngay_lam_hop_dong) in (10,11,12)
) and not EXISTS (
	SELECT tien_dat_coc
    from hop_dong
    where  month(ngay_lam_hop_dong) in (1,2,3,4,6,7,8,9)
)
GROUP BY hd.id_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, count(hdct.id_dich_vu_di_kem) as dich_vu_di_kem_nhieu_nhat
from khach_hang kh
	inner join hop_dong hd on kh.id_khach_hang = hd.id_hop_dong
    inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
GROUP BY dvdk.ten_dich_vu_di_kem;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm 
-- chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hd.id_hop_dong,ldv.ten_loai_dich_vu,dvdk.ten_dich_vu_di_kem, count(hdct.id_dich_vu_di_kem) as dich_vu_di_kem_nhieu_nhat
from khach_hang kh
	inner join hop_dong hd on kh.id_khach_hang = hd.id_hop_dong
    inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
    inner join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
    inner join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
GROUP BY dvdk.ten_dich_vu_di_kem
having count(hdct.id_dich_vu_di_kem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
--  mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nv.id_nhan_vien,nv.ten_nhan_vien,td.trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi,hd.ngay_lam_hop_dong,count(hd.id_nhan_vien) as nhan_vien_lap_toi_da_3_hop_dong
from nhan_vien nv
	inner join vi_tri vt on nv.id_vi_tri = vt.id_vi_tri
	inner join trinh_do td on nv.id_trinh_do = td.id_trinh_do
	inner join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan
    inner join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where year(hd.ngay_lam_hop_dong) in (2018,2019)    
GROUP BY nv.id_nhan_vien
having count(hd.id_nhan_vien)  <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019--
create TEMPORARY table temp (
	SELECT nv.id_nhan_vien
    from nhan_vien nv
		left join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
    where hd.id_hop_dong is null or year(hd.ngay_lam_hop_dong) not in (2017,2018,2019)    
);
DELETE
from nhan_vien
where id_nhan_vien in (
	select * from temp
); 
drop TEMPORARY table temp;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng 
-- với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

create TEMPORARY table sum (
	select sum(dv.chi_phi_thue +(hdct.so_luong*dvdk.gia) ) as 'Tong_Tien',hd.id_khach_hang 'id_khach_hang'    
    from dich_vu dv
		inner join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
        inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
        inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
        inner join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
    where year(hd.ngay_lam_hop_dong) = 2019 and id_loai_khach = 2    
    GROUP BY hd.id_hop_dong
    having Tong_Tien > 500
);
update khach_hang
set id_loai_khach = 1
WHERE id_khach_hang in (
	select id_khach_hang
    from sum
);
drop TEMPORARY table sum;


-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
create TEMPORARY table temp (
	select year(hd.ngay_lam_hop_dong) as 'condition'
	from khach_hang kh
		inner join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
);

DELETE
from temp
where `condition` < 2016;   

drop TEMPORARY table temp;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi

create TEMPORARY table temp (
	SELECT sum(hdct.so_luong) `so_lan_su_dung`
    from hop_dong hd
		inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
        inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
	WHERE year(hd.ngay_lam_hop_dong) = 2019
    GROUP BY dvdk.id_dich_vu_di_kem
    HAVING so_lan_su_dung > 10
);
update dich_vu_di_kem
set gia = gia * 2
WHERE EXISTS (
	SELECT so_lan_su_dung
    from temp
);
drop TEMPORARY table temp;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select id_nhan_vien,ten_nhan_vien,email,ngay_sinh,so_dien_thoai,dia_chi
from nhan_vien
union all
SELECT id_khach_hang,ten_khach_hang,email,ngay_sinh,so_dien_thoai,dia_chi_khach_hang
from khach_hang;

-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” 
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với năm lập hợp đồng là “2019”
-- CREATE VIEW view_name AS
-- SELECT column1, column2, ...
-- FROM table_name
-- WHERE condition;
create view v_nhanvien as 
select nv.id_nhan_vien,nv.ten_nhan_vien,nv.dia_chi
from nhan_vien nv
	inner join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where nv.dia_chi = 'Đà Nẵng' and year(hd.ngay_lam_hop_dong) = 2019;

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhanvien
set dia_chi = 'Liển Chiểu';

-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó 
-- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
 delimiter //
create PROCEDURE xoa_khach_hang (id INT )
BEGIN
	delete
    from khach_hang
    WHERE id_khach_hang = id;
end;
// delimiter ;
call xoa_khach_hang();

-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create PROCEDURE sp_2(
	new_id_hop_dong int,
    new_id_nhan_vien int,
    new_id_khach_hang int,
    new_id_dich_vu int,
    new_ngay_lam_hop_dong date,
    new_ngay_ket_thuc_hop_dong date,
    new_tien_dat_coc float,
    new_tong_tien float
)
BEGIN
if (new_id_nhan_vien in (select id_nhan_vien from nhan_vien) AND
	new_id_hop_dong not in (SELECT id_hop_dong from hop_dong) and
	new_id_khach_hang in (SELECT id_khach_hang FROM khach_hang)AND
    new_id_dich_vu IN (SELECT id_dich_vu FROM dich_vu)) THEN
	INSERT into hop_dong (id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,new_tien_dat_coc,tong_tien)
    VALUEs (new_id_hop_dong,new_id_nhan_vien,new_id_khach_hang,new_id_dich_vu,new_ngay_lam_hop_dong,new_ngay_ket_thuc_hop_dong,new_tien_dat_coc,new_tong_tien);
 ELSE
	SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Wrong';
    end if;
end;
// delimiter ;
call sp_2(4,3,2,3,'2019-4-12','2019-4-12',500,1500);

-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong 
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
delimiter //
create trigger tr_1	
after DELETE
on hop_dong for each row
begin
	set @anhquan = (select count(id_hop_dong) from hop_dong);
end;
// delimiter ;
-- set @anhquan = 0;
DELETE
from hop_dong
WHERE id_hop_dong = 5;
SELECT @anhquan;

-- SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = ''

-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau:
--  Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
--  Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
--  nếu dữ liệu không hợp lệ thì in ra thông báo
--  “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
delimiter //
create trigger tr_2
before update
on hop_dong for each row
begin
	DECLARE thong_bao_sai VARCHAR(250);
    set thong_bao_sai = 'sai rồi ngày kết thúc hợp đồng phải cách ít nhất 2 ngày với ngày làm hợp đồng';
    if datediff(new.ngay_ket_thuc_hop_dong,old.ngay_lam_hop_dong) <= 2 then
    SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = thong_bao_sai;
    end if;
end;
// delimiter ;
DROP TRIGGER IF EXISTS tr_2;
update hop_dong
set ngay_ket_thuc_hop_dong = '2019-07-21'
where id_hop_dong = 7;

update hop_dong
set ngay_ket_thuc_hop_dong = '2019-07-26'
where id_hop_dong = 7;

-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến 
-- lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào 
-- từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được 
-- truyền vào như là 1 tham số của function này.-- 

-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
-- từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu)
--  và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong)
--  và những bản liên quan khác.
create TEMPORARY table temp 
create PROCEDURE sp_3 ()
BEGIN
	select *
    from hop_dong hd
		inner join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
		inner join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
    where (year(ngay_lam_hop_dong) = 2015 and year(ngay_ket_thuc_hop_dong) = 2019 )    
end;
// delimiter ;
call sp_3();






    




    
