CREATE TABLE IF NOT EXISTS results (
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_name VARCHAR(100),
  course VARCHAR(100),
  marks INT
);

INSERT INTO results (student_name, course, marks) VALUES
('Alice', 'Math', 95),
('Bob', 'Science', 88);
