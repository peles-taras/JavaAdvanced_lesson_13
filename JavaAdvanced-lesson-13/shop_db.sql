DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;
USE shop;

CREATE TABLE user(
id INT NOT NULL PRIMARY KEY auto_increment,
email VARCHAR(255) NOT NULL UNIQUE,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
role VARCHAR(255),
password VARCHAR(255) NOT NULL
);

CREATE TABLE product(
id INT NOT NULL PRIMARY KEY auto_increment,
name VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
price decimal(9,2) NOT NULL
);
CREATE TABLE bucket(
id INT NOT NULL PRIMARY KEY auto_increment,
user_id INT NOT NULL,
product_id INT NOT NULL,
purchase_date timestamp DEFAULT NULL,
CONSTRAINT user_id_FK FOREIGN KEY(user_id) REFERENCES shop.user(id) ON DELETE CASCADE ON UPDATE RESTRICT,
CONSTRAINT product_id_FK FOREIGN KEY(product_id) REFERENCES shop.product(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

SELECT * FROM user;
SELECT * FROM product;
SELECT * FROM bucket;

INSERT INTO product(name, description, price) VALUES('product name 1', 'desc', 1);
INSERT INTO user(email, first_name, last_name, role, password) VALUES('admin', 'admin_name', 'admin_surname', 'ADMINISTRATOR', 'admin')
