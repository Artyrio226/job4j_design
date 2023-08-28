create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) 
values ('clouded leopard', 4000, '1862-06-01'),
	   ('alpaca', 5000, null),
	   ('reedwarbler', 3000, '1804-06-01'),
	   ('amazon dolphin', 4000, '1834-06-01'),
	   ('southern elephant seal', 5000, '1758-06-01'),
	   ('chimpanzee', 18000, '1799-06-01'),
	   ('fish-crawler', 2000, '1792-06-01');
	   
select * from fauna where name like '%fish%';

select * from fauna where avg_age > 10000 and avg_age < 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '1950-01-01';