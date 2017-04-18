CREATE TABLE `user_t` ( 
`id`int(11) primary key ,  
`user_name` varchar(255) DEFAULT NULL,  
`password` varchar(255) ,
`age` int(11)
) CHARSET=utf8;

insert into user_t values(1,'xiaodonghong','xiaodonghong',20);