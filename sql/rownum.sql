select *
   from Prof p inner join(
     select 1 x from dual
       UNION
     select 2 from dual
        UNION ALL
     select 5 from dual) sub
     on p.id = sub.x;

select * from Prof where id = 1
UNION
select * from Prof where id = 2;

select s.*, (@rownum := @rownum + 1)
    from Student s, (select @rownum := 0) rn;