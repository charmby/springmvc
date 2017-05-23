create database demo;
use demo;

CREATE TABLE `user_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`user_name` varchar(255) DEFAULT NULL,  
`password` varchar(255) ,
`phone` varchar(255) ,
`age` int(11)
) CHARSET=utf8;

insert into user_t values(1,'xiaodonghong','xiaodonghong','18765432456',20);
insert into user_t values(2,'admin','admin','18765532456',18);
insert into user_t values(2,'sa','1','18765432436',10);



CREATE TABLE `role_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`role_name` varchar(255) DEFAULT NULL,  
`role_code` varchar(255) ,
`role_desc` varchar(255) 
) CHARSET=utf8;

insert into role_t values(1,'sa','sa','超级管理员');
insert into role_t values(2,'sysadmin','sysadmin','系统管理员');
insert into role_t values(3,'privadmin','privadmin','权限管理员');
insert into role_t values(4,'normal','normal','普通用户');




CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT,address varchar(200),telphone varchar(20),sex int,note varchar(255))CHARSET=utf8;
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('孤傲苍狼', 27,"北京市海淀区洪城路223号","18765906543",1);
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('白虎神皇', 27,"上海市滨海新区34路","18609876554",0);



CREATE TABLE sextype(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20) )CHARSET=utf8;
INSERT INTO sextype(NAME) VALUES('男');
INSERT INTO sextype(NAME) VALUES('女');
INSERT INTO sextype(NAME) VALUES('未知');

