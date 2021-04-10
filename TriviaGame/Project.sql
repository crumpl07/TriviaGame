CREATE DATABASE TriviaGame;

CREATE TABLE Users(
			username VARCHAR(20),
            password VARCHAR(20),
            PRIMARY KEY(username)
);

CREATE TABLE Quiz(
			ID INT,
            category VARCHAR(20),
            title VARCHAR(30),
            PRIMARY KEY (ID)
);

CREATE TABLE Question(
			ID INT,
            answer VARCHAR(10),
            question VARCHAR(160),
            PRIMARY KEY (ID)
);

INSERT INTO Users 
	(username, password )
VALUES ('crumpl','password'),
	   ('dangv', 'otherpas'),
       ('Stansb', 'thispas'),
       ('Garfk', 'thatpas');

INSERT INTO Quiz 
	(ID, category, title)
VALUES (1,'history', 'World War 2'),
	   (2, 'math', 'Geomotry'),
       (3, 'science', 'Computer'),
       (4, 'engineering', 'Computer');

INSERT INTO Question 
	(ID, answer, question)
VALUE (1,'tanks', 'What was used during blitzkreig'),
	  (2, 'turtles', 'Lays their egg in the ground'),
      (3, 'whale', 'Largest mammal on the plannet'),
      (4, 'turkey', 'The animal that is eaten during a holiday in November');
      
UPDATE Users
SET username = 'bob'
WHERE username = 'crumpl';

DELETE FROM Users WHERE Users.username = 'bob';

INSERT INTO Users 
VALUES ('crumpl', 'password');

SELECT username FROM Users WHERE username = 'crumpl';