create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values ('Anna'), ('Semyon'), ('Boris');

insert into devices(name, price) values ('Xiaomi', 6990), 
										('Digma', 2490), 
										('Itel', 4000),
										('Redmi', 5490),
										('Realme', 10990);

insert into devices_people(device_id, people_id) values (2, 1), (4, 1),
														(3, 2), (4, 2),
														(1, 3), (3, 3), (5, 3);

select avg(price) from devices;

select p.name, avg(d.price) 
from devices_people dp
join devices d 
on dp.device_id = d.id
join people p
on dp.people_id = p.id 
group by p.name

select p.name, avg(d.price) 
from devices_people dp 
join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id 
group by p.name
having avg(d.price) > 5000;