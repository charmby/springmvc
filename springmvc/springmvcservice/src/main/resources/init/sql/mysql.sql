create database demo;
use demo;

CREATE TABLE `user_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`user_name` varchar(255) DEFAULT NULL,  
`password` varchar(255) ,
`phone` varchar(255) ,
`age` int(11)
) CHARSET=utf8;

insert into user_t(id,user_name,password,phone,age)  values(1,'xiaodonghong','xiaodonghong','18765432456',20);
insert into user_t(id,user_name,password,phone,age) values(2,'admin','admin','18765532456',18);
insert into user_t(id,user_name,password,phone,age)  values(3,'sa','1','18765432436',10);
insert into user_t(id,user_name,password,phone,age)  values(4,'normal','normal','18765442436',11);
insert into user_t(id,user_name,password,phone,age)  values(5,'sysadmin','sysadmin','18765431436',12);


CREATE TABLE `role_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`role_name` varchar(255) DEFAULT NULL,  
`role_code` varchar(255) ,
`role_desc` varchar(255) 
) CHARSET=utf8;

insert into role_t(id,role_name,role_code,role_desc) values(1,'sa','sa','超级管理员');
insert into role_t(id,role_name,role_code,role_desc) values(2,'sysadmin','sysadmin','系统管理员');
insert into role_t(id,role_name,role_code,role_desc) values(3,'privadmin','privadmin','权限管理员');
insert into role_t(id,role_name,role_code,role_desc) values(4,'normal','normal','普通用户');
insert into role_t(id,role_name,role_code,role_desc) values(5,'normal1','normal1','普通用户');
insert into role_t(id,role_name,role_code,role_desc) values(6,'normal2','normal2','普通用户');
insert into role_t(id,role_name,role_code,role_desc) values(7,'normal2','normal3','普通用户');



CREATE TABLE `user_role_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`role_id` int(11)  ,  
`user_id` int(11) 
) CHARSET=utf8;

ALTER TABLE `user_role_t` ADD  FOREIGN KEY (`role_id`) REFERENCES `role_t`(`id`); 
ALTER TABLE `user_role_t` ADD  FOREIGN KEY (`user_id`) REFERENCES `user_t`(`id`); 





CREATE TABLE `permission_role_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`role_id` int(11)  ,  
`permission_id` int(11) 
) CHARSET=utf8;

ALTER TABLE `permission_role_t` ADD  FOREIGN KEY (`role_id`) REFERENCES `role_t`(`id`); 
ALTER TABLE `permission_role_t` ADD  FOREIGN KEY (`permission_id`) REFERENCES `permission_t`(`id`); 


 ALTER TABLE `user_role_t` ADD CONSTRAINT fk_user_role_user_id FOREIGN KEY (`user_id`) REFERENCES `user_t`(`id`); 


CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT,address varchar(200),telphone varchar(20),sex int,note varchar(255))CHARSET=utf8;
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('孤傲苍狼', 27,"北京市海淀区洪城路223号","18765906543",1);
INSERT INTO person(NAME, age,address,telphone,sex) VALUES('白虎神皇', 27,"上海市滨海新区34路","18609876554",0);


CREATE TABLE `permission_t` ( 
`id`int(11) primary key  AUTO_INCREMENT,  
`permission_name` varchar(255) DEFAULT NULL,  
`permission_code` varchar(255) ,
`permission_url` varchar(255) ,
`permission_desc`  varchar(255) 
) CHARSET=utf8;

insert into permission_t(id,permission_name,permission_code,permission_url,permission_desc) values(1,'新增用户','user:insertUser','/user/insertUser','过滤新增用户的url');
insert into permission_t(id,permission_name,permission_code,permission_url,permission_desc) values(2,'根据用户名查询用户','user:selectUserByUserName','/user/selectUserByUserName','根据用户名查询用户');
insert into permission_t(id,permission_name,permission_code,permission_url,permission_desc) values(3,'根据用户名和密码获取用户信息','user:showUserByUserNameAndPassWord','/user/showUserByUserNameAndPassWord','根据用户名和密码获取用户信息');
insert into permission_t(id,permission_name,permission_code,permission_url,permission_desc) values(4,'删除用户','user:deleteUser','/user/deleteUser','删除用户');



CREATE TABLE sextype(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20) )CHARSET=utf8;
INSERT INTO sextype(NAME) VALUES('男');
INSERT INTO sextype(NAME) VALUES('女');
INSERT INTO sextype(NAME) VALUES('未知');

