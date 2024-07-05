-- Drop existing tables if they exist
DROP TABLE CHAT CASCADE CONSTRAINTS;
DROP TABLE ROOM CASCADE CONSTRAINTS;
DROP TABLE RE_MEETING CASCADE CONSTRAINTS;
DROP TABLE USER_MEETING CASCADE CONSTRAINTS;
DROP TABLE MEETING CASCADE CONSTRAINTS;
DROP TABLE REGION CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;

-- Create USERS table
CREATE TABLE USERS (
                       user_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       phone_number VARCHAR2(50),
                       user_name VARCHAR2(50),
                       password VARCHAR2(50),
                       birth DATE,
                       myself_memo CLOB,
                       reg_dt DATE DEFAULT SYSDATE
);

-- Create REGION table
CREATE TABLE REGION (
                        region_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        region_1depth_name VARCHAR2(10),
                        region_2depth_name VARCHAR2(10),
                        region_3depth_name VARCHAR2(10),
                        region_4depth_name VARCHAR2(10),
                        code VARCHAR2(10),
                        longitude NUMBER,
                        latitude NUMBER
);

-- Create MEETING table
CREATE TABLE MEETING (
                         meeting_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         user_id NUMBER,
                         region_id NUMBER,
                         category VARCHAR2(20),
                         subject VARCHAR2(200),
                         context CLOB,
                         readcount NUMBER default 0,
                         imageUrl VARCHAR2(200),
                         all_meeting_number NUMBER,
                         meeting_number NUMBER,
                         status VARCHAR2(10),
                         reg_dt DATE DEFAULT SYSDATE
);

-- Create RE_MEETING table
CREATE TABLE RE_MEETING (
                            re_meeting_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            meeting_id NUMBER,
                            user_id NUMBER,
                            context CLOB,
                            reg_dt DATE DEFAULT SYSDATE
);

-- Create ROOM table
CREATE TABLE ROOM (
                      room_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      meeting_id NUMBER,
                      room_name VARCHAR2(200)
);

-- Create CHAT table
CREATE TABLE CHAT (
                      chat_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      room_id NUMBER,
                      user_id NUMBER,
                      message CLOB
);

-- Create USER_MEETING table
CREATE TABLE USER_MEETING (
                              user_meeting_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              user_id NUMBER,
                              meeting_id NUMBER,
                              role VARCHAR2(10)
);

-- Add foreign key constraints
ALTER TABLE MEETING
    ADD CONSTRAINT fk_meeting_user FOREIGN KEY (user_id) REFERENCES USERS(user_id);

ALTER TABLE MEETING
    ADD CONSTRAINT fk_meeting_region FOREIGN KEY (region_id) REFERENCES REGION(region_id);

ALTER TABLE RE_MEETING
    ADD CONSTRAINT fk_re_meeting_meeting FOREIGN KEY (meeting_id) REFERENCES MEETING(meeting_id);

ALTER TABLE RE_MEETING
    ADD CONSTRAINT fk_re_meeting_user FOREIGN KEY (user_id) REFERENCES USERS(user_id);

ALTER TABLE ROOM
    ADD CONSTRAINT fk_room_meeting FOREIGN KEY (meeting_id) REFERENCES MEETING(meeting_id);

ALTER TABLE CHAT
    ADD CONSTRAINT fk_chat_room FOREIGN KEY (room_id) REFERENCES ROOM(room_id);

ALTER TABLE CHAT
    ADD CONSTRAINT fk_chat_user FOREIGN KEY (user_id) REFERENCES USERS(user_id);

ALTER TABLE USER_MEETING
    ADD CONSTRAINT fk_user_meeting_user FOREIGN KEY (user_id) REFERENCES USERS(user_id);

ALTER TABLE USER_MEETING
    ADD CONSTRAINT fk_user_meeting_meeting FOREIGN KEY (meeting_id) REFERENCES MEETING(meeting_id);