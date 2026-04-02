drop schema if exists test_jpa;

create schema test_jpa;

use test_jpa;

create table PESSOA (
    ID int not null auto_increment primary key,
    NOME_PESSOA varchar(50) not null,
    IDADE int not null
);

insert into PESSOA (NOME_PESSOA, IDADE)
values ("Juscelino Kubitschek", 132);

CREATE USER 'test'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON test_jpa.* TO 'test'@'localhost';
FLUSH PRIVILEGES;

-- show databases;