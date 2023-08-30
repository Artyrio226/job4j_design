create table car_bodies(
    id serial primary key,
    name varchar(255)
);

create table car_engines(
    id serial primary key,
    name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) 
values ('Hatchback'),
 	   ('Minivan'),
	   ('Sedan'),
 	   ('Cross Over'),
	   ('Coupe');
	   
insert into car_engines(name) 
values ('V8 Engine'),
 	   ('Electric Motor'),
 	   ('W Engine'),
	   ('In-line engine');
	   
insert into car_transmissions(name) 
values ('Manual'),
 	   ('Automatic'),
 	   ('Semi-automatic'),
	   ('Tiptronic');	   

insert into cars(name, body_id, engine_id, transmission_id) 
values ('Tesla', 3, 2, 2),
	   ('Audi', 1, 3, null),
	   ('BMW', 4, 1, 3),
	   ('Chevrolet', 2, null, 2),
	   ('Mercedes-Benz', 3, 3, 1),
	   ('Toyota', 1, null, 1);

select c.id, c.name, cb.name, ce.name, ct.name 
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id 
left join car_transmissions ct on c.transmission_id = ct.id;

select cb.id, cb.name, c.body_id
from car_bodies cb left join cars c on cb.id = c.body_id
where c.body_id is null;

select ce.id, ce.name, c.engine_id
from car_engines ce left join cars c on ce.id = c.engine_id
where c.engine_id is null;

select ct.id, ct.name, c.transmission_id
from car_transmissions ct left join cars c on ct.id = c.transmission_id
where c.transmission_id is null;