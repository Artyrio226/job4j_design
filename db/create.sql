create table roles (
    id serial primary key,
    role varchar(30)
);

create table rules (
    id serial primary key,
    rule text
);

create table roles_rules (
    id serial primary key,
    roles_id int references roles(id),
    rules_id int references rules(id)
);

create table users (
    id serial primary key,
    name varchar(255),
	roles_id int references roles(id)
);

create table categories (
    id serial primary key,
    category text
);

create table states (
    id serial primary key,
    status text
);

create table items (
    id serial primary key,
	item text,
    users_id int references users(id),
	categories_id int references categories(id),
    states_id int references states(id)
);

create table attachs (
    id serial primary key,
    attachment varchar(255),
	items_id int references items(id)
);

create table comments (
    id serial primary key,
    comment text,
	items_id int references items(id)
);