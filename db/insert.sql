insert into roles(role) values ('Editor');

insert into rules(rule) values ('Edit and delete');

insert into roles_rules(roles_id, rules_id) values (1, 1);

insert into users(name, roles_id) values ('Egor', 1);

insert into categories(category) values ('Refund');

insert into states(status) values ('Approved');

insert into items(item, users_id, categories_id, states_id) values ('Please return the money.', 1, 1, 1);

insert into attachs(attachment, items_id) values ('screen1.png', 1);

insert into comments(comment, items_id) values ('Incorrect transaction', 1);