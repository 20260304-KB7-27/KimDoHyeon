-- SUB QUERY
-- 다른 쿼리에서 실행되는 쿼리 (보조역할)
-- 메인쿼리 실행중에 서브 쿼리를 실행해서 결과 값을 메인쿼리에 전달하는 방식

# 규칙
-- 서브쿼리는 소괄호로 묶어야한다.
-- 서브쿼리는 연산자의 오른쪽에 있어야 한다.
-- 서브쿼리는 order by 지원 안됨.

use employees;

-- employees db에서 각 부서별 관리자의 직원 정보를 출력
-- 조건, 현재 재직자만 (관리자의 코드는 dept_no = d005, 재직중인건 to_date = 9999-01-01)
select *
from employees
where emp_no = (
    select
        emp_no
    from
        dept_manager
    where
        to_date = '9999-01-01'
      and
        dept_no = 'd005');

/*
Common Table Expressions(CTE)
- 서브쿼리와 비슷한 개념으로 코드의 가독성과 재사용성을 위한
- 임시 결과 테이블을 선언
*/

with current_manager as (select
                             emp_no
                         from
                             dept_manager
                         where
                             to_date = '9999-01-01'
                           and
                             dept_no = 'd005')

select * from employees
where emp_no = (select emp_no from current_manager);

-- 재직자 전체 평균 급여 보다 급여를 더 많이 받는 재직자의 정보를 출력

# 재직자의 평균급여
select avg(salary)
from salaries
where to_date='9999-01-01';

# 평균급여보다 많이 받는 재직자의 ID
select emp_no
from salaries
where to_date='9999-01-01'
and salary > (select avg(salary)
               from salaries
               where to_date='9999-01-01');

# 평균 급여보다 많이 받는 재직자의 직원정보
select * from employees
where emp_no in (select emp_no
                 from salaries
                 where to_date='9999-01-01'
                   and salary > (select avg(salary)
                                 from salaries
                                 where to_date='9999-01-01'));

# create table .. select
-- 셀렉트문의 결과를 그대로 새 테이블로 저장하는 문법

# 사용이유
-- 복잡한 쿼리, 결과를 반복 조회하거나, 무거운 쿼리를 실행하는 대신
-- 테이블로 저장해놓으면 이후 조회가 빠름
-- 원본데이터 손상을 방지

-- 컬럼명-데이터타입은 select 한 결과로 복사됨.
-- INDEX, PK, FK등의 제약조건은 복사 안 됨(추가 가능)

-- 연도별 입사자 수를 구하고, 그 중 입사자가 20000명 이상인 연도만 출력
select year(hire_date) as hire_year, count(*) as hire_count
from employees
group by hire_year;

create table yearly_hire
select year(hire_date) as hire_year, count(*) as hire_count
from employees
group by hire_year;

select
    *
from
    yearly_hire
where hire_count >= 20000;