create table birthplace(
    id serial primary key,
    place varchar(255)
);

create table person(
    id serial primary key,
    name varchar(255),
    birthplace_id int references birthplace(id)
);

insert into birthplace(place) values ('Москва');

insert into person(name, birthplace_id) VALUES ('Степан', 1);