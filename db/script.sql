create table user_data(
	id serial primary key,
	name varchar(255),
	age serial,
	married boolean
);
insert into user_data(name, age, married) values('Семён', 32, true);
update user_data set name = 'Иван', age = 43, married = false;
delete from user_data;