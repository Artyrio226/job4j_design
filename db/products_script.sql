create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()     --  триггерная функция
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2      --  плюс налог 20%
	    where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger           --  триггер
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();
	
create or replace function add_tax_before()    --  функция
    returns trigger as
$$
    BEGIN
        new.price = new.price * 1.2;         --  плюс налог 20%
        return new;
    END;
$$
LANGUAGE 'plpgsql';	

create trigger add_tax_before_trigger         --  триггер
    before insert on products
    for each row
    execute procedure add_tax_before();

create table history_of_price (               --  новая таблица
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function history_of_price_fnc()
    returns trigger as
$$
    BEGIN
        INSERT INTO history_of_price (name, price, date)     --  заносим имя, цену и текущую дату в таблицу history_of_price
        VALUES (NEW.name, NEW.price, now());
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history_of_price_fnc_trigger
    after insert on products                                --  после вставки
    for each row
    execute procedure history_of_price_fnc();