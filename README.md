CREATE TABLE Doctor(

IdDoctor varchar2(100) default SYS_GUID() PRIMARY KEY,

NombreDoctor varchar2(100) NOT NULL,

EdadDoctor int NOT NULL,

PesoDoctor number(5,2) NOT NULL,

CorreoDoctor varchar2(100) NOT NULL

);

ALTER SESSION SET "_ORACLE_SCRIPT" = true;

create user Doctores identified by "DOCS";

grant "CONNECT" TO Doctores;
