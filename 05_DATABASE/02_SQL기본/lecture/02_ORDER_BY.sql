use employees;

-- ORDER BY
-- 특정 칼럼이나 값에 따라 정렬하는데 사용
-- 주의! 데이터가 많을 때 정렬하면 매우 오래 걸릴 수 있다.

-- 칼럼에 따라 정렬을 여러 기준으로 가능
-- first_name으로 내림차순 정렬하고,
-- 같은 값이 있으면 last_name 기준으로 오름차순정렬
select
    emp_no,
    first_name,
    last_name
from employees
order by
#   emp_no; -- 기본
#     emp_no desc; -- 내림차순
    first_name desc,
    last_name;

