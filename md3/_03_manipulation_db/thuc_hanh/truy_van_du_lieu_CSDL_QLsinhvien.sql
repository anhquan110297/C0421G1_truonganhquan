use QuanLySinhVien;
SELECT * from student;

SELECT *
FROM Student
WHERE Status = true;
--  lay ra danh sach cac mon hoc co thoi gian hoc lon hon 10
SELECT *
FROM Subject
WHERE Credit < 10;
-- join 2 bang va student bang cau lenh
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID;

SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
