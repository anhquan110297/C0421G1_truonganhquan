use quanlysinhvien;
SELECT address, count(studentid) as 'student_amount'
FROM student
GROUP BY address;

SELECT student.studentid, student.studentname, AVG(mark)
FROM student join Mark on student.studentid = mark.studentid
GROUP BY student.studentid, student.studentname
having avg(mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);