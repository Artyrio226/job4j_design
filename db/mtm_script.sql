create table restaurant(
    id serial primary key,
    meal varchar(255)
);

create table person(
    id serial primary key,
    name varchar(255)
);

create table person_restaurant(
    id serial primary key,
    name_id int references name(id),
    meal_id int references meal(id)
);

insert into person(name) values ('Ирина');
insert into person(name) values ('Маша');
insert into person(name) values ('Илья');

insert into restaurant(meal) values ('Салат');
insert into restaurant(meal) values ('Рыба');
insert into restaurant(meal) values ('Сок');

insert into person_restaurant(name_id, meal_id) values (1, 1);
insert into person_restaurant(name_id, meal_id) values (1, 2);
insert into person_restaurant(name_id, meal_id) values (1, 3);
insert into person_restaurant(name_id, meal_id) values (2, 1);
insert into person_restaurant(name_id, meal_id) values (2, 2);
insert into person_restaurant(name_id, meal_id) values (3, 3);