WITH RECURSIVE cte(n , p) AS
(
    SELECT 1, 1
    UNION ALL
    SELECT n + 1, pow(n + 1, 2) FROM cte WHERE n < 5
)

SELECT * FROM cte;

select d.dname, e.dept, avg(e.salary) avgsal
    from Emp e inner join Dept d on e.dept = d.id
    group by dept
    order by avgsal desc;
    
WITH AvgSal AS
    (select d.dname, e.Dept, avg(e.salary) avgsal
        from Emp e inner join Dept d on e.dept = d.id
    group by dept),
    MaxSal AS (select * from AvgSal order by avgsal desc limit 1),
    MinSal AS (select * from AvgSal order by avgsal limit 1),
    SumUp AS
     (select * from MaxSal
        UNION
     select * from MinSal)
select * from SumUp
UNION
select '평균 차액', ' - ',  max(avgsal) - min(avgsal) from SumUp;

select * from Dept;

select * from Dept where pid = 0;
select * from Dept where pid in (1, 2);
select * from Dept where pid in (3,4,5,6,7);
select * from Dept where pid between 3 and 700;
select * from Dept where pid > 0 or pid < 10;


insert into Dept(pid, dname) values(6, '인프라셀');
insert into Dept(pid, dname) values(6, 'DB셀');
insert into Dept(pid, dname) values(7, '모바일셀');

select * from Dept;

select * from Dept d1 inner join Dept d2 on d1.id = d2.pid;

WITH RECURSIVE CteDept(id, pid, pname, dname, dx, h) AS
(
    select id, pid, cast('' as char(31)), dname, 0, cast(id as char(10))
        from Dept where pid = 0
    UNION ALL
    select d.id, d.pid, cte.dname, d.dname, dx + 1, concat(cte.h, '-', d.id)
        from Dept d inner join CteDept cte on d.pid = cte.id
)
select concat(repeat('↳', dx), dname), id, dname, h from CteDept order by h;

show variables like '%max';

select dept, ename, salary, avg(salary) avgsal, sum(salary) totsal
    from EMP where ename like '박%'
    group by dept, ename, salary
    order by dept, salary desc;
    
select dept, ename, salary
    from Emp 
    where ename like '박%'
    order by dept, salary desc;
    
select row_number() over (order by dept, salary desc) '순번',
    dept, salary, ename, id,
    lead(dept, 1) over w next_dept,
    lead(dept, 2) over w next_dept2,
    round(avg(salary) over w) avgsal,
    sum(salary) over w sumsal
   from Emp e where ename like '박%'
   window w as (partition by dept order by salary);
   
   
select p.id pid, d.id did,
        (case when d.id is not null then max(p.dname)  else '-총계-' end) '상위 부서', 
        (case when d.id is not null then max(d.dname)  else '-소계-' end) '하위 부서', 
        format(sum(e.salary), 0) '급여합'
    from Dept p inner join Dept d on p.id = d.pid
        inner join Emp e on e.dept = d.id
    group by p.id, d.id
    with rollup;
    
-- pivot
select e.dept, max(d.dname) 부서,
      format(round(avg(e.salary) * 10000), 0) '평균 급여',
      format(sum(e.salary) * 10000, 0) '총 급여',
      format(min(e.salary) * 10000, 0) '최대 급여', 
      format(max(e.salary) * 10000, 0) '최소 급여'
    from Emp e inner join Dept d on e.dept = d.id
    where d.pid <> 0
   group by e.dept
   order by d.id;

select ename, dept, (case when dept = 3 then salary else 0 end)
    from Emp;
   
select '평균급여' as '구분', 
    format(avg(case when dept = 3 then salary end) * 10000, 0) '영업1팀',
    avg(case when dept = 4 then salary end) '영업2팀'
    from Emp
 UNION
select '급여합계', sum(case when dept = 3 then salary end),
             sum(case when dept = 4 then salary end) from Emp
  UNION  
select '최소급여', min(case when dept = 3 then salary end),
            min( if(dept = 4, salary, ~0)) from Emp
  UNION
select '최대급여', max(case when dept = 3 then salary end),
            max(case when dept = 4 then salary end) from Emp;
 
select '평균급여' as '구분',
   format(avg(case when dept = 3 then salary end) * 10000, 0) '영업1팀',
   format(avg(case when dept = 4 then salary end) * 10000, 0) '영업2팀',
   format(avg(case when dept = 5 then salary end) * 10000, 0) '영업3팀',
   format(avg(case when dept = 6 then salary end) * 10000, 0) '서버팀',
   format(avg(case when dept = 7 then salary end) * 10000, 0) '클라팀'
 from Emp
UNION
select '급역합계',
   format(sum(salary * (dept = 3)) * 10000, 0),
   format(sum(salary * (dept = 4)) * 10000, 0),
   format(sum(salary * (dept = 5)) * 10000, 0),
   format(sum(salary * (dept = 6)) * 10000, 0),
   format(sum(salary * (dept = 7)) * 10000, 0)
 from Emp
UNION
select '최소급여',   
   format(min(IF(dept = 3, salary, ~0)) * 10000, 0),
   format(min(IF(dept = 4, salary, ~0)) * 10000, 0),
   format(min(IF(dept = 5, salary, ~0)) * 10000, 0),
   format(min(IF(dept = 6, salary, ~0)) * 10000, 0),
   format(min(IF(dept = 7, salary, ~0)) * 10000, 0)
 from Emp
UNION
select '최대급여',   
   format(max(IF(dept = 3, salary, 0)) * 10000, 0),
   format(max(IF(dept = 4, salary, 0)) * 10000, 0),
   format(max(IF(dept = 5, salary, 0)) * 10000, 0),
   format(max(IF(dept = 6, salary, 0)) * 10000, 0),
   format(max(IF(dept = 7, salary, 0)) * 10000, 0)
 from Emp
 ;
 
select 0, +0, ~0;