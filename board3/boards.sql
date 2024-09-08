create database board_db;
use board_db;

CREATE TABLE boards
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL,
    content  VARCHAR(200) NOT NULL,
    author   VARCHAR(50)  NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO boards(title, content, author)
VALUES ('제목1', '내용1', 'test1'),
       ('제목2', '내용2', 'test2'),
       ('제목3', '내용3', 'test3'),
       ('제목4', '내용4', 'test4'),
       ('제목5', '내용5', 'test5');


SELECT * FROM boards;
