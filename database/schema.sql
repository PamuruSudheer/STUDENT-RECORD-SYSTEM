-- ============================
-- STUDENT RECORD SYSTEM
-- PostgreSQL Schema
-- ============================

CREATE TABLE student (
    student_id     SERIAL PRIMARY KEY,
    student_name   VARCHAR(100) NOT NULL,
    student_age    INT          NOT NULL,
    student_course VARCHAR(100) NOT NULL,
    student_email  VARCHAR(100) UNIQUE
);
