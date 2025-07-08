create user book_ex identified by book_ex
default tablespace users temporary tablespace temp;
-- 계정, 암호 생성 및 기본-temp 테이블 연결
grant connect, dba to book_ex;
-- 접근권한과 dba 권한 부여

select dbms_xdb.gethttpport() from dual; -- 오라클 포트 확인
exec dbms_xdb.sethttpport(9999); -- cmd에서 포트 번호 9999로 바꾸는 구문