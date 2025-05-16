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
select * from Prof where id <= SOME(select id from Prof);
select * from Prof where id <= ALL(select id from Prof);

select * from Student where major not in (1, 2, 3);
select * from Student where name like '김사_';
select * from Student where name like '김사%';
select * from Student where major between 1 and 3;
explain select * from Student where major between 1 and 3 order by id;


select id, student, (select name from Subject where id = e.subject)  as subject_name
  from Enroll e;

select e.id, s.name
  from Enroll e inner join Subject s on e.subject = s.id
  where e.id = 1;

select * from Subject s, Prof p
    where s.prof = p.id;

select p.*, ifnull(s.name, '담당 교과 없음') subject_name
    from Prof p left join Subject s on s.prof = p.id;  
  
insert into Prof(name) values('김교수');

#여기서부터 실행 5:16~ 
insert into Enroll(subject, student)
   select 1, id from Student where id not in (select student from Enroll where subject = 1);

insert into Enroll(subject, student)
   select 2, id from Student where id not in (select student from Enroll where subject = 2);

insert into Enroll(subject, student)
   select 3, id from Student where id not in (select student from Enroll where subject = 3);
   
alter table Enroll add column iscaptain boolean default 0 comment '반장여부';

select * from Enroll order by Subject, student;

select en.subject, group_concat(s.name), group_concat(s.id)
    from Enroll en inner join Student s on en.student = s.id
where s.name like '김%'
group by en.subject;

#select * from;

    update
	    (select en.subject,
             (case subject when 1 then max(s.id) when 2 then min(s.id) else 6 end) captain
	    	 from Enroll en inner join Student s on en.student = s.id
             where s.name like '김%'
             group by en.subject) sub inner join Enroll en 
								  on sub.subject = en.subject and sub.captain = en.student
	set en.iscaptain = 1;

select * from Enroll where iscaptain = 1;


#view 생성 문제
select * from Subject;

select s.*, p.name
    from Subject s left outer join Prof p on s.prof = p.id;
    
update Subject set prof = null where id = 2;

select * from Subject;
select * from Prof;

select * from v_subject where profName = '이교수';
insert into Prof(name) values('김교수');
insert into Subject(name, prof) values('김과목', 4);
insert into Subject(name, prof) values('과목5', 4), ('과목6',2) ;

-- ex) trigger
alter table Prof add column subjectcnt tinyint unsigned not null default 0;

update Prof p
    set subjectcnt = (select count(*) from Subject where prof = p.id);
select count(*) from Subject where prof = 1;


show triggers;

insert into Subject(name, prof) values('과목7', 3);
delete from Subject where id = 7;

update Subject set prof = 2 where id = 5;
