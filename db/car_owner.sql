create table owner(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255)
);

create table auto(
    id serial primary key,
    name varchar(255),
    owner_id int references owner(id) unique
);

insert into owner(firstname, lastname) 
values ('Oleg', 'Ionov'),
       ('Elena', 'Tarasova'),
       ('Stas', 'Kravtsov');

insert into auto(name, owner_id) 
values ('Opel', 1),
       ('Mersedes', 2),
       ('Lada', 3);
insert into auto(name) values ('Toyota'),
							  ('Mazda');
							  
select a.name, o.firstname, o.lastname 
from auto a join owner o on a.owner_id = o.id;

select a.name Марка, o.firstname Имя, o.lastname Фамилия 
from auto a join owner o on a.owner_id = o.id;

select a.name as "Марка авто", o.lastname Фамилия 
from auto a join owner o on a.owner_id = o.id;							  