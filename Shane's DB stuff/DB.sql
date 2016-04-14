insert into scrum.INVENTORY (itemid, name, price, qty) values (1, 'bread', 5.00, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (2, 'Cereal', 3.30, 160);
insert into scrum.INVENTORY (itemid, name, price, qty) values (3, 'Oreos', 1.10, 120);
insert into scrum.INVENTORY (itemid, name, price, qty) values (4, 'Soup', 1.20, 200);
insert into scrum.INVENTORY (itemid, name, price, qty) values (5, 'Milk', 2.70, 70);
insert into scrum.INVENTORY (itemid, name, price, qty) values (6, 'Juice', 5.10, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (7, 'Water Pack', 9.99, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (8, 'Orange Juice', 2.30, 140);
insert into scrum.INVENTORY (itemid, name, price, qty) values (9, 'Pizza', 5.55, 160);
insert into scrum.INVENTORY (itemid, name, price, qty) values (10, 'Apple', 1.50, 175);
insert into scrum.INVENTORY (itemid, name, price, qty) values (11, 'Banana', 1.50, 175);
insert into scrum.INVENTORY (itemid, name, price, qty) values (12, 'Salt', 0.80, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (13, 'Pepper', 0.80, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (14, 'Chicken', 7.25, 90);
insert into scrum.INVENTORY (itemid, name, price, qty) values (15, 'Steak', 15.33, 60);
insert into scrum.INVENTORY (itemid, name, price, qty) values (16, 'Fish', 9.30, 70);
insert into scrum.INVENTORY (itemid, name, price, qty) values (17, 'Lobster', 12.00, 30);
insert into scrum.INVENTORY (itemid, name, price, qty) values (18, 'Canned Beans', 4.99, 200);
insert into scrum.INVENTORY (itemid, name, price, qty) values (19, 'Shovel', 14.00, 40);
insert into scrum.INVENTORY (itemid, name, price, qty) values (20, 'Keg Shell', 70.99, 20);
insert into scrum.INVENTORY (itemid, name, price, qty) values (21, 'Beer', 24.00, 50);
insert into scrum.INVENTORY (itemid, name, price, qty) values (22, 'Wine', 12.00, 50);
insert into scrum.INVENTORY (itemid, name, price, qty) values (23, 'Choco Milk', 2.35, 90);
insert into scrum.INVENTORY (itemid, name, price, qty) values (24, 'Tea', 3.25, 120);
insert into scrum.INVENTORY (itemid, name, price, qty) values (25, 'Coffee', 7.45, 160);
insert into scrum.INVENTORY (itemid, name, price, qty) values (26, 'Brownies', 6.00, 150);
insert into scrum.INVENTORY (itemid, name, price, qty) values (27, 'Cheese', 5.15, 170);
insert into scrum.INVENTORY (itemid, name, price, qty) values (28, 'Cold Cuts', 6.20, 200);
insert into scrum.INVENTORY (itemid, name, price, qty) values (29, 'Clams', 12.50, 70);
insert into scrum.INVENTORY (itemid, name, price, qty) values (30, 'Lemonade', 4.25, 110);
update scrum.INVENTORY set rentprice=price/2;
insert into scrum.users (userid, name, password, level) values (1, 'Bill', '1', 1);
insert into scrum.users (userid, name, password, level) values (2, 'Henry', '2', 2);
insert into scrum.users (userid, name, password, level) values (3, 'Joe', '3', 3);
insert into scrum.users (userid, name, password, level) values (4, 'Ian', '4', 4);
insert into scrum.users (userid, name, password, level) values (5, 'Shane', '5', 1);
insert into scrum.users (userid, name, password, level) values (6, 'Steve', '6', 2);
insert into scrum.users (userid, name, password, level) values (7, 'Ryan', '7', 3);
insert into scrum.creditinfo (creditnum, expdate) values ('1234567891234567', '2017-06-01');
insert into scrum.creditinfo (creditnum, expdate) values ('1234567899876543', '2017-01-01');
insert into scrum.creditinfo (creditnum, expdate) values ('1234567891826344', '2018-03-01');
insert into scrum.creditinfo (creditnum, expdate) values ('6666666666666666', '2015-12-01');
insert into scrum.creditinfo (creditnum, expdate) values ('9999999999999999', '2017-03-01');
insert into scrum.returninv (itemid, name, price, qty) values (1, 'bread', 5.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (2, 'Cereal', 3.30, 0);
insert into scrum.returninv (itemid, name, price, qty) values (3, 'Oreos', 1.10, 0);
insert into scrum.returninv (itemid, name, price, qty) values (4, 'Soup', 1.20, 0);
insert into scrum.returninv (itemid, name, price, qty) values (5, 'Milk', 2.70, 0);
insert into scrum.returninv (itemid, name, price, qty) values (6, 'Juice', 5.10, 0);
insert into scrum.returninv (itemid, name, price, qty) values (7, 'Water Pack', 9.99, 0);
insert into scrum.returninv (itemid, name, price, qty) values (8, 'Orange Juice', 2.30, 0);
insert into scrum.returninv (itemid, name, price, qty) values (9, 'Pizza', 5.55, 0);
insert into scrum.returninv (itemid, name, price, qty) values (10, 'Apple', 1.50, 0);
insert into scrum.returninv (itemid, name, price, qty) values (11, 'Banana', 1.50, 0);
insert into scrum.returninv (itemid, name, price, qty) values (12, 'Salt', 0.80, 0);
insert into scrum.returninv (itemid, name, price, qty) values (13, 'Pepper', 0.80, 0);
insert into scrum.returninv (itemid, name, price, qty) values (14, 'Chicken', 7.25, 0);
insert into scrum.returninv (itemid, name, price, qty) values (15, 'Steak', 15.33, 0);
insert into scrum.returninv (itemid, name, price, qty) values (16, 'Fish', 9.30, 0);
insert into scrum.returninv (itemid, name, price, qty) values (17, 'Lobster', 12.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (18, 'Canned Beans', 4.99, 0);
insert into scrum.returninv (itemid, name, price, qty) values (19, 'Shovel', 14.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (20, 'Keg Shell', 70.99, 0);
insert into scrum.returninv (itemid, name, price, qty) values (21, 'Beer', 24.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (22, 'Wine', 12.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (23, 'Choco Milk', 2.35, 0);
insert into scrum.returninv (itemid, name, price, qty) values (24, 'Tea', 3.25, 0);
insert into scrum.returninv (itemid, name, price, qty) values (25, 'Coffee', 7.45, 0);
insert into scrum.returninv (itemid, name, price, qty) values (26, 'Brownies', 6.00, 0);
insert into scrum.returninv (itemid, name, price, qty) values (27, 'Cheese', 5.15, 0);
insert into scrum.returninv (itemid, name, price, qty) values (28, 'Cold Cuts', 6.20, 0);
insert into scrum.returninv (itemid, name, price, qty) values (29, 'Clams', 12.50, 0);
insert into scrum.returninv (itemid, name, price, qty) values (30, 'Lemonade', 4.25, 0);
