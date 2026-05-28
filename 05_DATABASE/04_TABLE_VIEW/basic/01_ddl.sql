-- DDL (Data Definition Language)
-- 데이터베이스 구조를 정의하는 언어

DROP DATABASE tabledb; -- 삭제

CREATE DATABASE tabledb; -- 생성

use tabledb;

drop table if exists usertbl;

show table status;

-- auto-generated definition
create table usertbl
(
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthYear int         not null,
    addr      char(2)     not null,
    mobile1   char(3)     null,
    mobile2   char(8)     null,
    height    smallint    null check(height < 500),
    mDate     date        default (now())
);

drop table if exists buytbl;
-- auto-generated definition
create table buytbl
(
    num       int auto_increment primary key,
    userID    char(8)  not null,
    prodName  char(6)  not null,
    groupName char(4)  null,
    price     int      not null,
    amount    smallint not null

-- FOREIGN KEY (현재 테이블컬럼명)
        -- REFERENCES 참조할 테이블명 (참조할 칼럼명)
#     constraint buytbl_ibfk_1
#         foreign key (userID) references usertbl (userID)
);

-- 테이블 구조 변경
ALTER TABLE buytbl
    ADD CONSTRAINT fk_usertbl_buytbl
        FOREIGN KEY (userID) -- 외래키로 설정할 칼럼
        REFERENCES usertbl(userID); -- 참조할 부모테이블(컬럼)

