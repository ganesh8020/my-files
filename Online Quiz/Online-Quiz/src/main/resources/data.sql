CREATE TABLE IF NOT EXISTS questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question VARCHAR(255),
  optionA VARCHAR(100),
  optionB VARCHAR(100),
  optionC VARCHAR(100),
  optionD VARCHAR(100),
  correctAnswer VARCHAR(100)
);

INSERT INTO questions (question, optionA, optionB, optionC, optionD, correctAnswer) VALUES
('What is Java?', 'Programming Language', 'Database', 'OS', 'IDE', 'Programming Language'),
('Spring Boot is used for?', 'Frontend', 'Database', 'Backend', 'Testing', 'Backend'),
('Which keyword is used to inherit a class in Java?', 'this', 'super', 'extends', 'implements', 'extends'),
('What is JVM?', 'Java Virtual Machine', 'Java Variable Method', 'Join Variable Memory', 'Java Version Model', 'Java Virtual Machine');
