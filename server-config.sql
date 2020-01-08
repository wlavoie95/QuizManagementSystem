DROP USER quiz CASCADE;

CREATE USER quiz
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT CONNECT TO quiz;
GRANT RESOURCE TO quiz;
GRANT CREATE SESSION TO quiz;
GRANT CREATE TABLE TO quiz;
GRANT CREATE VIEW TO quiz;

conn quiz/p4ssw0rd;

--------------------------------------------------------------------------------------------------------------------------------
-- CONFIGURATION
--------------------------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE user_id_seq;
CREATE TABLE user_account (
    u_id INT PRIMARY KEY,
    username VARCHAR2(25) UNIQUE NOT NULL,
    password VARCHAR2(25) NOT NULL,
    u_type INT DEFAULT 0 NOT NULL -- 0 is a user, 1 is a manager
);

CREATE SEQUENCE quiz_id_seq;
CREATE TABLE quizzes (
    q_id INT PRIMARY KEY,
    subject VARCHAR2(30) NOT NULL,
    description VARCHAR2(200)
);

CREATE SEQUENCE question_id_seq;
CREATE TABLE questions (
    question_id INT PRIMARY KEY,
    question VARCHAR2(200)UNIQUE NOT NULL,
    correct_answer VARCHAR2(100) NOT NULL,
    false_one VARCHAR2(100) NOT NULL,
    false_two VARCHAR2(100) NOT NULL,
    false_three VARCHAR2(100) NOT NULL
);

CREATE TABLE grades (
    u_id REFERENCES user_account(u_id) NOT NULL,
    q_id REFERENCES quizzes(q_id) NOT NULL,
    score NUMBER(5,2),
    CONSTRAINT quiz_results_pk PRIMARY KEY(u_id, q_id)
);

--------------------------------------------------------------------------------------------------------------------------------
-- LOOKUP TABLES
--------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE quizzes_with_questions (
    q_id REFERENCES quizzes(q_id) NOT NULL,
    question_id REFERENCES questions(question_id) NOT NULL,
    CONSTRAINT quiz_and_question_pk PRIMARY KEY(q_id, question_id)
);

--------------------------------------------------------------------------------------------------------------------------------
-- DEFAULT DATA
--------------------------------------------------------------------------------------------------------------------------------

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'admin', 'password', 1);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'FullStackOne', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'FullStackTwo', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'PerfEngrOne', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'PerfEngrTwo', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'SalesForceOne', 'password', 0);
    
INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'SalesForceTwo', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'CyberSecOne', 'password', 0);

INSERT INTO user_account(u_id, username, password, u_type)
    VALUES(user_id_seq.nextval, 'CyberSecTwo', 'password', 0);
    
INSERT INTO questions(question_id, question, correct_answer, false_one, false_two, false_three)
    VALUES(question_id_seq.nextval, 'Which answer says test?', 'test', 'wrong 1', 'wrong 2', 'wrong 3');
    
INSERT INTO questions(question_id, question, correct_answer, false_one, false_two, false_three)
    VALUES(question_id_seq.nextval, 'Which of the following should you never use?', 'Sysout', 'Null Object', 'Servlets', 'Reflection');
    
INSERT INTO quizzes(q_id, subject, description)
    VALUES(quiz_id_seq.nextval, 'Core Java', 'Covers the fundamentals of Java');
    
INSERT INTO quizzes_with_questions(q_id, question_id)
    VALUES(1, 1);

INSERT INTO grades(u_id, q_id, score)
    VALUES(2, 1, 100.00);
    
INSERT INTO grades(u_id, q_id, score)
    VALUES(3, 1, 0.00);

commit;