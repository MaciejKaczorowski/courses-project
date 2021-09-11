CREATE table users(
    id BIGINT primary key not null auto_increment,
    login varchar(50) not null unique,
    password varchar(50) not null,
    name varchar(100) not null,
    surname varchar (100) not null,
    is_active tinyint(1) not null default 1
);

CREATE TABLE courses(
    id BIGINT primary key not null auto_increment,
    name varchar(50)
);

CREATE TABLE blocks(
    id BIGINT primary key not null auto_increment,
    name varchar(50)
);

CREATE TABLE lessons(
    id BIGINT primary key not null auto_increment,
    topic varchar(200),
    date datetime
);

CREATE TABLE roles (
    id bigint primary key not null AUTO_INCREMENT,
    name varchar(30) not null,
    description varchar(200)
);

ALTER TABLE users add column id_role bigint;

ALTER TABLE users add foreign key (id_role) references roles (id);