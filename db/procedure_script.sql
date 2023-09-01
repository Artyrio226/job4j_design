CREATE TABLE products (
    id serial PRIMARY KEY,
    name varchar(50),
    producer varchar(50),
    count integer DEFAULT 0,
    price integer
);

CREATE OR REPLACE PROCEDURE delete_by_id(d_id integer)
LANGUAGE 'plpgsql'
AS $$
    BEGIN
    DELETE FROM products WHERE id = d_id;
    END
$$;

CREATE OR REPLACE PROCEDURE delete_zero_count()
LANGUAGE 'plpgsql'
AS $$
    BEGIN
        DELETE FROM products WHERE count = 0;
    END;
$$;

CREATE OR REPLACE FUNCTION f_delete_by_id(fd_id integer)
RETURNS void
LANGUAGE 'plpgsql'
AS $$
    BEGIN
        DELETE FROM products WHERE id = fd_id;
    END;
$$;

CREATE OR REPLACE FUNCTION f_delete_zero_count()
RETURNS void
LANGUAGE 'plpgsql'
AS $$
    BEGIN
         DELETE FROM products WHERE count = 0;
    END;
$$;

INSERT INTO products (name, producer, count, price) 
VALUES ('product_1', 'producer_1', 6, 100),
	   ('product_3', 'producer_3', 0, 40),
	   ('product_4', 'producer_4', 0, 70);
	   
CALL delete_by_id(1);
	
CALL delete_zero_count();

INSERT INTO products (name, producer, count, price) 
VALUES ('product_1', 'producer_1', 6, 100),
	   ('product_3', 'producer_3', 0, 40),
	   ('product_4', 'producer_4', 0, 70);

SELECT f_delete_by_id(1);

SELECT f_delete_zero_count();