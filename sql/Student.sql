#STUDENT 학생 테이블 생성 (이미 studentr가 있어서 User로 변경 후 시작)
rename table schooldb.Student to schooldb.User;

create table schooldb.Student(
    id int unsigned not null auto_increment comment '학번',
    createdate timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
	updatedate timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '등록일시',
    name varchar(31) not null COMMENT '학생 이름',
    brithdat varchar(10) not null comment '생년월일',
    major smallint not null comment '학과 id',
    mobile varchar(13) not null comment '휴대전화',
    email varchar(255) not null comment '이메일주소',
    gender tinyint(1) not null comment '성별',
    graduatedt varchar(10) null comment '졸업일',
    PRIMARY KEY (id)
);

create table schooldb.Major(
    id smallint unsigned auto_increment primary key comment '학과번호',
    name varchar(31) not null comment '학과명'
)
select * from schooldb.Major;

insert schooldb.Major(name) values('철학과');
insert schooldb.Major(name) values('컴공과');
insert schooldb.Major(name) values('건축과');

alter table schooldb.Student modify column name varchar(25) not null;

alter table schooldb.Student add constraint foreign key(major) references schooldb.Major(id);

alter table schooldb.Student modify column major smallint unsigned;

desc schooldb.Student;
desc schooldb.Major;