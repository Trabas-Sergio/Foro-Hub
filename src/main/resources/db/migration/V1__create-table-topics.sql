create table topics (
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    message varchar(300) not null unique,
    creation_date datetime not null,
    status tinyint,
    author varchar(100) not null,
    course varchar(100) not null,

    primary key(id)
);