create table militaryID(
    id serial primary key,
    seria char(2),
    number int
);

create table soldier(
    id serial primary key,
    name varchar(255)
);

create table soldier_militaryID(
    id serial primary key,
    soldier_id int references passport(id) unique,
    militaryID_id int references people(id) unique
);

insert into soldier(name) values ('Ivan');

insert into militaryID(seria, number) values ('AX', 8034071);

insert into soldier_militaryID(soldier_id, militaryID_id) values (1, 1);