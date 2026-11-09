create table nhs_member(
    id varchar2(200),
    password varchar2(200),
    name varchar2(200),
    email varchar2(200),
    mobile varchar2(20),
    type varchar2(1)
);

insert into nhs_member values ('admin', '1234', 'admin', null, null, 'A');

select * from nhs_member;

commit;

insert into nhs_member(id, password, name, email, mobile, type)
values (?, ?, ?, ?, ?, ?);

select id, password, name, email, mobile, type
from nhs_member
where id = ?;

update nhs_member
set password = ?,
    name = ?,
    email = ?,
    mobile = ?,
    type = ?
where id = ?;

delete from nhs_member
where id = ?;

select * from nhs_member;

