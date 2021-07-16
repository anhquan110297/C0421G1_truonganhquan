CREATE DATABASE teachers;
USE teachers;
CREATE TABLE teacher (
	id INT PRIMARY KEY,
    teacher_name VARCHAR(50),
    age INT,
    country VARCHAR(50)
);

INSERT INTO teacher
VALUES (
	1,
    "Minh dep trai",
    30,
    "Laos"
);

INSERT INTO teacher
VALUES (
	2,
    "Quan dep trai",
    18,
    "viet nam"
);