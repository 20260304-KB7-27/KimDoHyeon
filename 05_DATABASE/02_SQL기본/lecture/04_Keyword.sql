
use sqldb;

-- DISTINCT
-- 중복된 값을 제거하는데 사용
-- null도 종류로 포함됨
select DISTINCT userID
from buytbl;

select DISTINCT groupName
from buytbl;

-- LIMIT
-- select문의 결과 집합에서 반환할 행의 갯수를 제한할 때 사용
-- 페이징할 때도 사용 가능(offset)
-- limit [offset], [rowcount] : offset행부터 rowcount 만큼
-- limit [rowcount] : rowcount 만큼

select * from buytbl order by price limit 5;

-- offset
select * from buytbl order by price limit 0, 20;

