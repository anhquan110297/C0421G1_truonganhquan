USE quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select *
from `subject`
order by credit desc
limit 1;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from mark
	inner join `subject` on mark.subid = `subject`.subid
where mark_hihi =(
	select MAX(mark_hihi) from mark
);

select s.studentname,s.studentid , avg (mark_hihi) as avgscore
from student s
 inner join mark m on s.studentid = m.studentid
GROUP BY s.studentid
order by avgscore desc;
    