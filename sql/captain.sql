#부서별로 그룹 -> 이름순으로 정렬 
#이름이 가장 빠른 직원의 >>>직원 id<<<를 dept table captain에 넣어라...
select e.id, capname.ename, e.dept, e.auth, e.salary
    from (select min(e.ename) ename, e.dept
            from  Emp e inner join Dept d on e.dept = d.id 
		  group by dept) capname inner join Emp e
						 on capname.ename = e.ename
order by e.dept;

# update -> 오류남... ^ㅁ^
update
   (select e.id, capname.ename, e.dept, e.auth, e.salary
         from (select min(e.ename) ename, e.dept
                from  Emp e inner join Dept d on e.dept = d.id 
		       group by dept) capname inner join Emp e
						     on capname.ename = e.ename) captable inner join Dept dpt on captable.dept = dpt.id
set dpt.captain = captable.id;
   
   
#answer -> 만약에 동명이인이 있다면? 고려하기
update Emp set ename = '김바순' where id = 207;
select * from Emp where ename = '김바순';
select * from Emp where ename = SOME(select min(ename) from Emp group by dept);

#e1.ename > e2.ename  나보다 작은 것이 없으면 내가 제일 작은 것!
#outer join은 부담스럽지만 이렇게 유리할 때가 있다~
select *
    from Emp e1 left outer join Emp e2 on e1.dept = e2.dept and e1.ename > e2.ename
where e2.id is null;

update Dept d
    inner join (select e1.id, e1.dept
			       from Emp e1 left outer join Emp e2
                       on e1.dept = e2.dept and e1.ename > e2.ename
					where e2.id is null) sub
	on d.id = sub.dept
   set d.captain = sub.id
where d.id > 0;

select * from Dept;
select d.*, e.ename from Dept d inner join Emp e on d.captain = e.id;

