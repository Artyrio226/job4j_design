create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) 
values ('Financial'),
 	   ('Marketing'),
 	   ('Sales'),
	   ('Accounting');

insert into employees(name, department_id) 
values ('Manager', 1),
 	   ('Creator', 2),
	   ('Sales Manager', 3),
 	   ('Sales Trainer', null),
 	   ('Director', null),
 	   ('Analyst', 1);

select * from employees e left join departments d on e.department_id = d.id;

select * from employees e right join departments d on e.department_id = d.id;

select * from employees e full join departments d on e.department_id = d.id;

select * from employees cross join departments;

select * from departments d left join employees e on d.id = e.department_id
where e.department_id is null;

select e.id, e.name, e.department_id, d.id, d.name
from employees e left join departments d on e.department_id = d.id;

select e.id, e.name, e.department_id, d.id, d.name
from departments d right join employees e on d.id = e.department_id;	   