--建立web資料庫
CREATE database web character set utf8mb4 collate utf8mb4_croatian_ci;

--建立emp資料表
create table emp(
	eid int not null auto_increment, -- auto_increment自動遞增 主鍵 (自行產生序號 1,2,3,...)
    ename varchar(50) not null unique, -- unique不能重複	員工姓名
    eage int, -- 員工年齡
    createtime timestamp default current_timestamp,-- 建檔時間
    primary key(eid)-- primaary key(eid) 主鍵
);

--建立emp範例資料
insert into emp (ename,eage) value('John','28');
insert into emp (ename,eage) value('Mary','25');
insert into emp (ename,eage) value('Helen','30');

--查詢emp資料
select eid,ename,eage,createtime from emp; 



