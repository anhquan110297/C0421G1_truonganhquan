CREATE DATABASE ScoreManagement;
USE ScoreManagement;
CREATE TABLE students(
	student_id VARCHAR(20) PRIMARY KEY,
    student_name VARCHAR(20),
    date_of_birth DATETIME,
    class VARCHAR (20),
    gt VARCHAR (20)
);

CREATE TABLE subjects (
	subject_id VARCHAR (20) PRIMARY KEY,
    subject_name VARCHAR (50)

);

CREATE TABLE transcript (
	student_id VARCHAR(20),
    subject_id VARCHAR (20),
    score INT,
    exam_day DATETIME,
    PRIMARY KEY (student_id, subject_id),
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (subject_id) REFERENCES subjects (subject_id)
);

CREATE TABLE teachers(
    teacher_id VARCHAR(20) PRIMARY KEY,
    teacher_name VARCHAR(20),
    phone_number VARCHAR(10)
);

ALTER TABLE subjects ADD teacher_id VARCHAR(20);
ALTER TABLE subjects ADD CONSTRAINT FK_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);
