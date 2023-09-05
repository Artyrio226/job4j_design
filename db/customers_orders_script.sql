CREATE TABLE customers(
    id serial PRIMARY KEY,
    first_name text,
    last_name text,
    age int,
    country text	
);

CREATE TABLE orders(
    id serial PRIMARY KEY,
    amount int,
    customer_id int REFERENCES customers(id)
);

INSERT INTO customers VALUES (1, 'Ivan', 'Tarov', 21, 'Russia'),
                             (2, 'Irina', 'Tarasova', 33, 'Korea'),
                             (3, 'Sara', 'Smith', 28, 'USA'),
                             (4, 'Mark', 'Olsen', 19, 'Sweden'),
                             (5, 'Gretta', 'Cuper', 37, 'Italy');
							 
INSERT INTO orders 
VALUES (1, 20, 1),
       (2, 10, 2),
       (3, 40, 3);
INSERT INTO orders (id, customer_id) 
VALUES (4, 4),
       (5, 5);
						  
SELECT first_name, last_name, age FROM customers WHERE age = (SELECT MIN(age) FROM customers);

SELECT first_name, last_name
FROM customers WHERE id NOT IN (SELECT c.id FROM customers c
								  JOIN orders o ON c.id = o.customer_id 
								  WHERE o.amount IS NOT NULL);
