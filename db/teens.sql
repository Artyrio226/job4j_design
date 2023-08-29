create table teens(
    name varchar(255),
	gender char(1)
);

insert into teens(name, gender) 
values ('Egor', 'm'),
	   ('Maxim', 'm'),
	   ('Mikhail', 'm'),
	   ('Elena', 'f'),
	   ('Svetlana', 'f'),
	   ('Olga', 'f');

select n1.name, n2.name, CONCAT(n1.name, ' ', n2.name) as couple  
from teens n1 cross join teens n2
where n1.gender != n2.gender and n1.gender = 'm';