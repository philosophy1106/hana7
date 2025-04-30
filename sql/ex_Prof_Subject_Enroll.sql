create table Prof(
  id smallint unsigned not null primary key comment '교수번호',
  name varchar(31) not null comment '교수명',
  likecnt int not null default 0
  );
  
  desc Prof;
  show create table Prof;
  
  create table Subject(
     id smallint unsigned not null primary key,
     name varchar(31) not null comment '과목명',
     prof smallint unsigned null comment '교수번호',
     foreign key fk_Subject_prof_Prof (prof)
     references Prof(id) on Update cascade on Delete set null
  );
  
  create table Enroll(
     id int unsigned not null primary key,
     subject smallint unsigned not null comment '과목번호',
     student int unsigned not null comment '학번',
     foreign key fk_Enroll_subject(subject)
       references Subject (id) on Update cascade on Delete cascade,
	 foreign key fk_Enroll_student(student)
       references Student (id) on Update cascade on Delete cascade
	);
    
    insert into Student(name, birth, major, mobile, email)
        values('김밀수', '19990123', 1, '01012340001', 'kim@gamil.com');
    insert into Student(name, birth, major, mobile, email)
        values('김이수', '19990124', 1, '01012340201', 'kim2@gamil.com'),
              ('김삼수', '19990124', 1, '01012350301', 'kim3@gamil.com'),
              ('김사수', '19990125', 1, '01012360401', 'kim4@gamil.com'),
              ('김오수', '19990126', 2, '01012370501', 'kim5@gamil.com');
    
    insert into Major(name)
        values('경제학'), ('경영학');
        
	SET SQL_SAFE_UPDATES = 0;
    update Student set major = 1 where name = '김밀수';
    
    rename table Emp to TTT;
    
    select * from Student;
    select * from Subject;
    select * from Major;
    select * from Prof;
    select *, if(likecnt > 5, 'Best', if(likecnt <= 2, 'Worst', 'Good')) as level from Prof;
    select *,
      (case likecnt when 2 then 'two' when 3 then 'three' else 'seven' end) as num,
      (case when likecnt > 5 then 'Best' when likecnt <= 2 then 'worst' else 'good' end)
      as level from Prof;
    select * from Enroll;
    
    select name, substring(name, 1, 1) from Student where name not like '김%';
    
    #number 3
    insert into Prof(name, likecnt)
       select concat(substring(name, 1, 1), '교수'), id from Student
        where name not like '김%';
    #number 4    
    insert into Subject(name, prof)
	  select concat('과목', id), id from Prof order by rand();
      
insert into Enroll(subject, student)      
  select id, (select id from Student order by rand() limit 1) from Subject;

select * from Student order by rand() limit 1;
update Student set graduatedt = curdate()
  order by rand() limit 1;

select ifnull(graduatedt, '재학중') state, name, mobile phone, email as 'email address' from Student;

select * from Prof where id < ANY(select id from Prof);
select id, student, (select name from Subject where id = e.subject)  as subject_name
  from Enroll e;

select e.id, s.name
  from Enroll e join Subject s on e.subject = s.id
  where e.id = 1;