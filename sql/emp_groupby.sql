select * from Emp order by id desc limit 10;
select * from Emp order by id desc limit 10, 10;
select * from Emp order by id desc limit 20, 10;

select * from Emp order by id desc limit 250, 10; 
#select * from Emp order by id desc limit (page - 1) * 10, 10;

select floor(count(*) / 10), count(*) % 10 from Emp;

select (select min(dname) from Dept where id = dept) dept_name,
    dept, count(*), sum(salary) totsal,  avg(salary) avgsal
  from Emp group by dept;

select * from Emp where salary = (select max(salary) from Emp);
select count(*)/10, count(*) % 10 from Emp;

#부서 별 급여 평균이 전체 평균보다 높은 부서의 id와 평균 급여를 구하시오.
#Answer 1 - 서브쿼리 사용해서 해결 (서브쿼리 2번 사용)
select * 
  from(select dept, avg(salary) avgsal from Emp group by dept) s
where avgsal > (select avg(salary) from Emp);

#Answer 2 Having절 사용  (서브쿼리 한 번 사용)
select dept, avg(salary) avgsal from Emp
  group by dept having avgsal > (select avg(salary) from Emp);
  
#위의 쿼리 결과에서 부서명도 같이 출력하기
#1. 서브쿼리 방식
select (select dname from Dept where id = dept)
    dept, avg(salary) avgsal from Emp
group by dept having avgsal > (select avg(salary) from Emp);
    
#2. 조인 방식
select e.dept, avg(salary) avgsal, d.dname 
  from Emp e inner join Dept d on e.dept = d.id
group by e.dept having avgsal > (select avg(salary) from Emp);

select e.*, d.dname
    from Emp e inner join Dept d on e.dept = d.id;
    
#전체 급여 평균보다 더 높은 급여를 가진 직원 목록 출력
update Emp set salary = 901
  where id in (152, 97,18,80,133,47,128);
  
update Emp set salary = 901
  where id in (9, 11, 104, 115, 239, 152, 97,18,80,133,47,128);
  
update Emp set salary = 901 + dept
  where id in (152, 97,18,80,133,47,128);

#join 1번 문제 부서 별
select d.id, d.dname, e.id, e.ename
   from Emp e left outer join Dept d on e.dept = d.id
where e.salary > (select avg(salary) from Emp);

#join 2번 문제 부서 별 최고 급여자 목록을 추출하시오.
#그룹별 최대 급여를 구해서, 급여가 동일한 사람을 찾아서 출력하기
select e.dept, DeptMaxSal.dname, e.id, e.ename, e.salary
    from Emp e 
      inner join 
       (select d.dname, e.dept, max(salary) maxsal 
         from Emp e inner join Dept d on e.dept = d.id
       group by dept) DeptMaxSal
	  on e.dept = DeptMaxSal.dept and e.salary = DeptMaxSal.maxsal
	order by e.dept;
    
#1. 부서별 최대 급여 테이블 서브쿼리로 작성, 이 테이블과 비교해서 dept, maxsal 일치하는 것 뽑아내기 
select d.dname, e.dept, max(salary) maxsal 
	from Emp e inner join Dept d on e.dept = d.id
group by dept;

#view를 사용해서 조회
explain select * from v_emp_groupby_dept;

select id, f_empinfo(id) from Emp limit 10;