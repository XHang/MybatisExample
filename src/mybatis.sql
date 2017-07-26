create table user(
	id int auto_increment primary key,
	username varchar(20)
)
insert into user values(null,'林克');

create table Article(
	id int auto_increment primary key,
	userid int not null,
	title varchar(12),
	content text not null
)