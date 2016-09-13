-- 系统参数表
CREATE TABLE hrm_sys(
       ID NUMBER(3) NOT NULL,
       text Varchar2(10) NOT NULL,
       tid NUMBER(3) NOT NULL
)
ALTER TABLE hrm_sys ADD state varchar2(20);

-- 部门表
create table HRM_DEPT
(
  dept_id       INTEGER,
  dept_name     VARCHAR2(25),
  location_name VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table HRM_DEPT
  is '部门表';

-- 员工信息分析表
create table HRM_EMPDATA
(
  eid    NUMBER(3),
  ename  VARCHAR2(25),
  percen NUMBER(4,1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
-- 用户表
create table HRM_USER
(
  user_id   NUMBER(4) not null,
  user_name VARCHAR2(25),
  passwd    VARCHAR2(15),
  alevel    NUMBER(2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );  

select * from HRM_DEPT;