drop schema if exists test_jpa;

create schema test_jpa;

use test_jpa;

create table PESSOA (
    ID int not null auto_increment primary key,
    NOME_PESSOA varchar(50) not null,
    IDADE int not null
);

insert into PESSOA (NOME_PESSOA, IDADE) values 
	("Cândido Portinari", 122),
    ("Pablo Picasso", 144),
    ("Pintor 3", 72),
    ("Pintor 4", 56),
    ("Pintor 5", 45);

drop user if exists 'test'@'localhost';
CREATE USER 'test'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON test_jpa.* TO 'test'@'localhost';
FLUSH PRIVILEGES;

-- show databases;
