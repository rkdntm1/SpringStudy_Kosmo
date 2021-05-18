select *
  from s_party;
  
--카테션 프로덕트. 정보 건수의 곱하기로 건수가 만들어져서 가치없는 것.
select *
  from s_party p , s_contact_point cp
--join
select *
  from s_party p , s_contact_point cp
 where p.user_id = cp.user_id;
--Outer
select *
  from s_party p , s_contact_point cp
 where p.user_id = cp.user_id(+);
 
select *
  from s_party p left outer join s_contact_point cp on p.user_id = cp.user_id;
 --회장님의 정보와 연락처 정보를 조회
select name, birth_dt, sex, descrim, contact_point_type, info
  from s_party p left outer join s_contact_point cp on p.user_id = cp.user_id
 where p.user_id = 'admin';