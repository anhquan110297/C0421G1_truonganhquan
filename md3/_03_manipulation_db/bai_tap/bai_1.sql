use quanlysinhvien;
-- truy vấn ra sinh viên bắt đầu bằng chữ h
SELECT studentName FROM student WHERE StudentName like 'h%';
-- truy vấn thông tin lớp học bắt đầu băng tháng 12
SELECT * from class where month(startdate) = 12;
-- truy vấn thông tin môn học có credit ở giữa 3 và 5
SELECT * from `subject` where credit BETWEEN 3 and 5;
-- lại 1 trường của sinh viênsubjectsubject
update student set Classid = 2 where studentname = 'hung';
-- truy vấn tên học viên, điểm, môn học theo thứ tự giảm dần, nếu trùng thì sắp xếp tên theo tăng dần-- 
SELECT studentname,mark,SubName
FROM student s
	INNER join mark on s.studentid = mark.StudentId
    inner join `subject` on `subject`.subid = mark.subid
order by mark desc, studentname asc;