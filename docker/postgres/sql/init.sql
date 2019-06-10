CREATE TABLE customers (
 id serial PRIMARY KEY,
 first_name varchar(255) NOT NULL,
 last_name varchar(255) NOT NULL,
 email varchar(255) UNIQUE NOT NULL
);

CREATE TYPE address_type AS ENUM ('SHIPPING','BILLING','LIVING');
CREATE TABLE addresses (
 id serial PRIMARY KEY,
 customer_id integer REFERENCES customers (id),
 street varchar(255) NOT NULL,
 city varchar(255) NOT NULL,
 state varchar(255) NOT NULL,
 zip varchar(255) NOT NULL,
 type varchar(255) NOT NULL
 );

CREATE TABLE products (
 id serial PRIMARY KEY,
 name varchar(255) NOT NULL,
 description varchar(512) DEFAULT NULL,
 weight float DEFAULT NULL
);

CREATE TABLE orders (
 order_number serial PRIMARY KEY,
 order_date date NOT NULL,
 purchaser integer REFERENCES customers (id),
 quantity integer NOT NULL,
 product_id integer REFERENCES products (id)
);

CREATE TABLE products_on_hand (
 product_id serial PRIMARY KEY REFERENCES products (id),
 quantity integer NOT NULL
);
