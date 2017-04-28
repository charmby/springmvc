create database demo;
use demo;

CREATE TABLE `user_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`user_name` varchar(255) DEFAULT NULL,  
`password` varchar(255) ,
`age` int(11)
) CHARSET=utf8;

insert into user_t values(1,'xiaodonghong','xiaodonghong',20);


CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT,address varchar(200),telphone varchar(20),sex int,note varchar(255))CHARSET=utf8;
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('孤傲苍狼', 27,"北京市海淀区洪城路223号","18765906543",1);
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('白虎神皇', 27,"上海市滨海新区34路","18609876554",0);



CREATE TABLE sextype(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20) )CHARSET=utf8;
INSERT INTO sextype(NAME) VALUES('男');
INSERT INTO sextype(NAME) VALUES('女');
INSERT INTO sextype(NAME) VALUES('未知');

