create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	expired_date date,
	price float,
    type_id int references type(id)
);

insert into type(name) values ('СЫР'),
							  ('ХЛЕБ'),
							  ('КОЛБАСА'),
							  ('МОРОЖЕНОЕ'),
							  ('МОЛОКО');
insert into product(name, expired_date, price, type_id) 
values ('Пармезан', '2023-08-20', 174, 1),
	   ('Сливочный', '2023-10-03', 149, 1),
	   ('Ламбер', '2023-07-29', 86, 1),
	   ('Моцарелла', '2023-09-17', 312, 1),
	   ('Ржаной', '2023-09-09', 66, 2),
	   ('Батон', '2023-09-05', 28, 2),
	   ('Багет', '2023-09-03', 85, 2),
	   ('Ветчина', '2023-11-17', 149, 3),
	   ('Докторская', '2023-11-24', 163, 3),
	   ('Сервелат', '2023-11-13', 312, 3),
	   ('Мороженое Пломбир', '2023-10-03', 99, 4),
	   ('Мороженое Сливочное', '2023-10-03', 62, 4),
	   ('Мороженое Эскимо', '2023-10-11', 79, 4),
	   ('Эконива', '2023-09-17', 94, 5),
	   ('Авида', '2023-09-04', 79, 5),
       ('Можайское', '2023-08-27', 86, 5);	

select p.name, p.expired_date, p.price, t.name
from product p join type t on p.type_id = t.id 
where t.name = 'СЫР';

select p.name, p.expired_date, p.price, t.name
from product p join type t on p.type_id = t.id 
where p.name like '%Мороженое%';

select name, expired_date, price
from product  
where expired_date < current_date;

select name, expired_date, price
from product  
where price = (select max(price) from product);

select t.name, count(t.name)
from product p join type t on p.type_id = t.id 
group by t.name;

select p.name, p.expired_date, p.price, t.name
from product p join type t on p.type_id = t.id 
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(t.name)
from product p join type t on p.type_id = t.id 
group by t.name
having count(t.name) < 10;

select p.name, p.expired_date, p.price, t.name
from product p join type t on p.type_id = t.id;
   