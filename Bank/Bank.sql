--------------------------------------------------------
--  DDL for Table ACCOUNTS
--------------------------------------------------------
CREATE TABLE accounts (
    id        NUMBER NOT NULL,
    approved  NUMBER(1, 0) DEFAULT 0 NOT NULL,
    balance   FLOAT(126) DEFAULT 0 NOT NULL,
    CONSTRAINT accounts_pk PRIMARY KEY ( id )
        USING INDEX (
            CREATE UNIQUE INDEX accounts_pk ON
                accounts (
                    id
                ASC )
                    LOGGING TABLESPACE users PCTFREE 10 INITRANS 2
                        STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
                        NOPARALLEL
        )
    ENABLE
)
LOGGING TABLESPACE users PCTFREE 10 INITRANS 1
    STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
NOCOMPRESS NO INMEMORY
    NOPARALLEL;

--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

CREATE TABLE users (
    username       VARCHAR2(20 BYTE) NOT NULL,
    password_hash  BLOB NOT NULL,
    salt           BLOB NOT NULL,
    address        VARCHAR2(20 BYTE),
    permission     NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY ( username )
        USING INDEX (
            CREATE UNIQUE INDEX users_pk ON
                users (
                    username
                ASC )
                    LOGGING TABLESPACE users PCTFREE 10 INITRANS 2
                        STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
                        NOPARALLEL
        )
    ENABLE
)
LOGGING TABLESPACE users PCTFREE 10 INITRANS 1
    STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
NOCOMPRESS NO INMEMORY
        NOPARALLEL
        LOB ( password_hash ) STORE AS sys_lob0000020792c00002$$ (
            ENABLE STORAGE IN ROW
            CHUNK 8192
            NOCACHE LOGGING
            TABLESPACE users
            STORAGE ( INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
        )
        LOB ( salt ) STORE AS sys_lob0000020792c00003$$ (
            ENABLE STORAGE IN ROW
            CHUNK 8192
            NOCACHE LOGGING
            TABLESPACE users
            STORAGE ( INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
        );

ALTER TABLE users
    ADD CONSTRAINT perm_check CHECK ( permission >= 0
                                      AND permission < 3 ) ENABLE;

--------------------------------------------------------
--  DDL for Table HOLDINGS
--------------------------------------------------------

CREATE TABLE holdings (
    username    VARCHAR2(20 BYTE) NOT NULL,
    account_id  NUMBER NOT NULL
)
LOGGING TABLESPACE users PCTFREE 10 INITRANS 1
    STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS UNLIMITED BUFFER_POOL DEFAULT )
NOCOMPRESS NO INMEMORY

noparallel;

ALTER TABLE holdings
    ADD CONSTRAINT accounts_fk FOREIGN KEY ( account_id )
        REFERENCES accounts ( id )
            ON DELETE CASCADE
    ENABLE;

ALTER TABLE holdings
    ADD CONSTRAINT users_fk FOREIGN KEY ( username )
        REFERENCES users ( username )
            ON DELETE CASCADE
    ENABLE;
    
--------------------------------------------------------
--  DDL for Sequence GENID
--------------------------------------------------------

CREATE SEQUENCE "BANK"."GENID" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER NOCYCLE;

--------------------------------------------------------
--  DDL for Procedure CREATE_ACCOUNT
--------------------------------------------------------

SET DEFINE OFF;

CREATE OR REPLACE EDITIONABLE PROCEDURE "BANK"."CREATE_ACCOUNT" (
    usrname   IN   users.username%TYPE,
    newaccid  OUT  accounts.id%TYPE
) IS
BEGIN
    newaccid := genid.nextval;
    INSERT INTO accounts ( id ) VALUES ( newaccid );

    INSERT INTO holdings VALUES (
        usrname,
        newaccid
    );
END;
/