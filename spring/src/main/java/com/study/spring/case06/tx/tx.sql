-- 交易 Demo 所需的資料表

create table if not exists book(
	bid INTEGER NOT NULL auto_increment, -- 主鍵序號
    bname varchar(20) not null, -- 書名
    price INTEGER, -- 價格
	ct timestamp default current_timestamp, -- 建檔時間
    PRIMARY KEY (bid)
);

create table if not exists stock(-- 庫存
	sid INTEGER not null auto_increment,-- 主鍵序號
	bid INTEGER not null,-- Book主鍵
	amount INTEGER,-- 數量
	PRIMARY KEY (sid)
);

create table if not exists wallet(-- 錢包
	wid INTEGER not null auto_increment,-- 主鍵序號
	money INTEGER,-- 錢數量
	PRIMARY KEY (wid)
);

insert into book(bname,price) values('Java',80);
insert into stock(bid,amount) values(1,3);
insert into wallet(money) values(100);