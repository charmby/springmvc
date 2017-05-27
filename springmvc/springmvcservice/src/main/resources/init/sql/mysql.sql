/*查询用户对应的权限编码*/
select  pp.* from  	permission_t pp,permission_role_t pr,user_role_t uar,user_t ut
where 
pp.id=pr.permission_id
and pr.role_id=uar.role_id
and uar.user_id = ut.id
and pp.id= pr.permission_id
and ut.user_name='sa';


/*根据用户查询角色信息*/

select rt.* from user_role_t uar,user_t ut,role_t rt
where  rt.id= uar.role_id
and uar.user_id= ut.id
and ut.user_name='sa';