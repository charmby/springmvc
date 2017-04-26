CREATE TABLE `user_t` ( 
`id`int(11) primary key ,  
`user_name` varchar(255) DEFAULT NULL,  
`password` varchar(255) ,
`age` int(11)
) CHARSET=utf8;

insert into user_t values(1,'xiaodonghong','xiaodonghong',20);



create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
INSERT INTO users(NAME, age) VALUES('孤傲苍狼', 27);
INSERT INTO users(NAME, age) VALUES('白虎神皇', 27);