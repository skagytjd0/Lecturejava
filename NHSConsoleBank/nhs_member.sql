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
