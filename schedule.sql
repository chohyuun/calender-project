-- Create(테이블 생성)
create table schedule(
    schedule_id int not null auto_increment primary key,
    user_name varchar(30) not null, -- user table 생성시 제거 및 이름 변경
    user_password varchar(50) not null, -- user table 생성시 제거 및 이름 변경
    create_date datetime not null,
    modified_date datetime not null,
    contents varchar(300)
);

-- Insert(일정 저장)
insert into schedule (schedule_id, user_name, user_password, create_date, modified_date, contents)
    values (0, '000', '0000', now(), now() , 'contents')
    commit;

-- Select(전체 일정 조회)
select * from schedule;

-- Select(전체 일정 조회; 수정일 순 내림차순)
select * from schedule order by modified_date desc;

-- Select(선택 일정 조회)
select * from schedule where schedule_id=0;

-- Select(선택 일정 조회; 사용자명(내림차순))
select * from schedule where user_name='000' order by modified_date desc;

-- Select(선택 일정 조회; 수정일 순(내림차순))
select * from schedule where date(modified_date)='0000-00-00' order by modified_date desc;

-- Update
update schedule set modified_date=now(), user_name='000', contents='000' where schedule_id=0;

-- Delete
delete from schedule where schedule_id=0;