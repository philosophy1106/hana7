alter table Emp add column remark json;
alter table Emp add column remark2 text;

update Emp set remark = '{"id": 1, "age": 30, "fam": [{"id": 1, "name": "유세차"}]}',
                remark2 = '{"id": 1, "age": 30, "fam": [{"id": 1, "name": "유세차"}]}'
 where id = 2;
 
 update Emp set remark = '{"id": 3, "age": 33, "fam": [{"id": 1, "name": "유세차"}, {"id":2, "name": "홍길숭"}]}'
 where id = 3;

update Emp set remark = '{"id": 4, "age": 34, "fam": [{"id": 1, "name": "유세차"}]}'
 where id = 4;

update Emp set remark = json_object( 'id', 5, 'age', 44, 
                  'fam', json_array(
                                json_object('id', 1, 'name', '지세차'),
                                json_object('id', 2, 'name', '지세창')   )  )
 where id = 5;

select json_pretty(remark), e.* from Emp where id <= 5;

select id, remark -> '$.id', remark ->> '$.age',
        remark ->> '$.fam[0 to 2].name', remark ->> '$.fam[last].name',
        remark ->> '$.fam[last - 1 to last].name',
        json_valid(remark)
    from Emp 
    where json_object('id', 1, 'name', "유세차") member of (remark->'$.fam');
    #where remark ->> '$.fam[0].name' = '유세차';
    
explain select JSON_EXTRACT(remark, "$.id"),   remark->'$.id', 
        JSON_UNQUOTE(JSON_EXTRACT(remark, "$.fam[0].name")), remark->>'$.id',
        json_value(remark, '$.id'), JSON_TYPE(remark ->'$.age')
  from Emp 
  where '유세차' member of (remark->>'$.fam[*].name');

select JSON_EXTRACT(remark, "$.id"),   remark->'$.id', 
        JSON_UNQUOTE(JSON_EXTRACT(remark, "$.fam[0].name")), remark->>'$.id',
        json_value(remark, '$.id'), JSON_TYPE(remark ->'$.age')
  from Emp 
  where '유세차' member of (json_extract(remark->>'$.fam', '$[0].name'));
    
explain select * from Emp
 where '유세차' member of (remark->>'$.fam[*].name');
 
analyze table Emp;
optimize table Emp;

create table TTT(name varchar(31));
drop table TTT;

select * from Emp where remark->>'$.fam[0].name' like '%세차';

alter table Emp add index index_Emp_remark_fam ((
  cast(remark->>'$.fam[*].name' as char(255) array)
));

show index from Emp;

select json_search(remark, 'one', '유세차'), 
    json_extract(remark, '$.fam', '$[*]'), remark->>'$.fam[0].name'
  from Emp where id <= 5;
  
select json_value(remark, json_search(remark, 'one', '유세차'))
  from Emp where json_search(remark, 'all', '유세차');

update Emp set remark = json_object('id', 1, 'age', 55, 'name', 'Hong')
    where id = 2;

update Emp set remark = json_insert(remark, '$.addr', 'Seoul')
    where id = 2;
    
update Emp set remark = json_insert(remark, '$.fam', 
    json_array(json_object('id', 1,'name', '유세홍')))
    where id = 2;
    
update Emp set remark
    = json_array_append(remark, '&.fam', json_object('id', 2, 'name', '유세이'))
    where id = 2;
    
update Emp set remark
        = json_set('$.fam[1].name', '새로이')
    where id = 2;
    
update Emp set remark = JSON_REMOVE(remark, '$.addr') where id = 2;
update Emp set remark = '[1,2,3]' where id = 4;
select * from Emp where 2 member of (remark->'$');

select remark from Emp where id in (2, 3);
select remakr from Emp where remark -> '$.fam[1].name' = '새로이';

select JSON_STORAGE_SIZE(remark) from Emp;

select e.*, d.dname
    from Emp e inner join Dept d on e.remark -> '$.fam[0].id' = d.id
where json_length(e.remark -> '$.fam') > 0;

select json_objectagg(danme, id) from Dept d;
select * from Dept;
