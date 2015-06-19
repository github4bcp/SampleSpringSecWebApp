DROP TABLE person IF EXISTS;
CREATE TABLE person(id varchar(3) PRIMARY KEY not null, email varchar(20) not null, password_hash varchar(20) not null,role varchar(20) not null);
INSERT INTO person (id,email, password_hash, role)
VALUES (1,'demo', 'demo', 'ADMIN');
