use test_db;

/*
AUTO INCREMENT
- 행이 INSERT 될 때마다 자동으로 1씩 증가하는 고유번호 생성
- 적용하기 위해서는 PK, UNIQUE INDEX 이어야 함.
*/

create table board(
    board_no int not null auto_increment,
    title varchar(100) not null,
    content text,
    author varchar(50) not null,
    created_at datetime default now(),
    primary key (board_no)
);

insert into board (title, content, author)
values ('첫 번째 글','안녕하세요 첫 번째 게시글입니다.','홍길동');

insert into board (title, content, author)
values ('두 번째 글','안녕하세요 두 번째 게시글입니다.','홍길동');

insert into board (title, content, author)
values ('세 번째 글','안녕하세요 세 번째 게시글입니다.','홍길동');

-- null 또는 0을 넣어도 auto_increment가 동작한다.
insert into board
values (null, '네 번째 글','안녕하세요 네 번째 게시글입니다.','홍길동', now());

insert into board
values (0, '다섯 번째 글','안녕하세요 다섯 번째 게시글입니다.','홍길동', now());

insert into board
values (25, '여섯 번째 글','안녕하세요 여섯 번째 게시글입니다.','홍길동', now());

-- auto increment 시작값 변경
alter table board auto_increment = 100;

insert into board(title, content, author)
values ('100부터 시작','시작값을 100으로 변경 후 삽입','dodo');

select * from board;

-- last_insert_id()
-- 현재 세션에서 마지막으로 insert된 auto_increment 값을 반환
insert into board(title, content, author)
values ('100부터 시작','시작값을 100으로 변경 후 삽입','dodo');
select last_insert_id();
