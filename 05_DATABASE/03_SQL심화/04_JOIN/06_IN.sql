use employees;

select *
from employees
where emp_no in (1,2,3,4,5,6);

-- 현재 d005 부서에 재직중인 직원들의 상세정보
-- In 안에 서브쿼리 작성
select
    e.emp_no,
    e.first_name,
    e.last_name,
    e.gender
from employees e
where emp_no in (
    select emp_no
    from dept_emp
    where dept_no = 'd005'
    and to_date = '9999-01-01'
    )
limit 5;

-- NOT IN : 서브쿼리로 없는 것 찾기

-- 관리자였던 적이 없는 직원 수
select count(*)
from employees e
where e.emp_no not in (
    select emp_no
    from dept_manager # 관리자를 했던 직원들의 emp_no
);

-- not in의 null 함정
-- != and 비교로 동작하는데 null이랑 비교하면 true/false가 아닌
-- unknown이 나옴. 모든 결과가 전부 제외되는 문제가 발생

use sqldb;

-- 우리가 기대하는거
-- 010, 016, 011이 아닌 나머지 user데이터
select *
from usertbl
where mobile1 not in(
    select mobile1
    from usertbl
    where addr='서울' # null 값으로 인해 아무것도 나오지 않음(공집합)
);

select
    userID,
    mobile1,
    case
        when mobile1 NOT IN (
            select mobile1
            from usertbl
            where addr='서울'
        ) then 'TRUE'

        when mobile1 IN (
            select mobile1
            from usertbl
            where addr='서울'
        ) then 'FALSE'

        else 'UNKNOWN'
        end as check_result
from usertbl;

select *
from usertbl
where mobile1 not in(
    select mobile1
    from usertbl
    where addr='서울' and mobile1 is not null -- null 제외
);

