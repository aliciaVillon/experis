ALTER SESSION SET "_ORACLE_SCRIPT"=true;

-- USER SQL
CREATE USER "venta" IDENTIFIED BY "123456"  ;

-- QUOTAS

-- ROLES
GRANT "DBA" TO "venta" WITH ADMIN OPTION;
GRANT "CONNECT" TO "venta" WITH ADMIN OPTION;
ALTER USER "venta" DEFAULT ROLE "DBA","CONNECT";

 

