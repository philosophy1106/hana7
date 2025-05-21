set @x = 0;
set @y = 0;

call sp_ttt(@x, @y);

select @x, @y;

call sp_emplist(10);

select d.id, d.dname, ifnull(e.ename, '공석') captainName,
    (select format(avg(salary) * 10000, 0) from Emp where dept = d.id) avgsal
     from Dept d left outer join Emp e on d.id = e.dept and d.captain = e.id
    where d.dname like concat('영업', '%');

call sp_deptinfo('영업');
call sp_deptinfo('개발');

prepare XP from 'select * from Emp where id = ?';

set @z = 11;
execute XP using @y;
execute XP using @z;

call sp_dept_salary();

select id, ename from Emp limit 10;
select id, dname, captain from Dept;