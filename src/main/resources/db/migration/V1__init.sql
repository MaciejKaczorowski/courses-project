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
    name varchar(50),
    course_id bigint
);

CREATE TABLE lessons(
    id BIGINT primary key not null auto_increment,
    topic varchar(200),
    date_time datetime,
    block_id bigint
);

CREATE TABLE roles (
    id bigint primary key not null AUTO_INCREMENT,
    name varchar(30) not null,
    description varchar(200)
);

ALTER TABLE users add column role_id bigint;

ALTER TABLE users add foreign key (role_id) references roles (id);

ALTER TABLE blocks add foreign key (course_id) references courses (id);

ALTER TABLE lessons add foreign key (block_id) references blocks (id);

CREATE TABLE notifications(
    id bigint primary key not null auto_increment,
    subject varchar(100),
    content varchar(500),
    lesson_id bigint
);

ALTER TABLE notifications add foreign key (lesson_id) references lessons (id);


CREATE table courses_blocks
(   course_id BIGINT NOT NULL,
    block_id    BIGINT NOT NULL,
    FOREIGN KEY (course_id) references courses (id) ON DELETE CASCADE,
    FOREIGN KEY (block_id) references blocks (id) ON DELETE CASCADE
);

CREATE table users_courses
(   user_id    BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) references users (id) ON DELETE CASCADE ,
    FOREIGN KEY (course_id) references courses (id) ON DELETE CASCADE
);

CREATE table blocks_lessons
(
    block_id BIGINT NOT NULL,
    lesson_id BIGINT NOT NULL,
    FOREIGN KEY (block_id) references blocks (id),
    FOREIGN KEY (lesson_id) references lessons (id)
);


CREATE TABLE hibernate_sequence (
    next_val bigint
);

INSERT into hibernate_sequence values (1);