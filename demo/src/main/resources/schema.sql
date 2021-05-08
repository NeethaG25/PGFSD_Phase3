create table product_master
(
   id int not null primary key auto_increment,
   brand varchar(255),
   colour varchar(255),
   category varchar(255) not null,
   shoe_size double,
   price double
);

create table users
(
   id int not null primary key auto_increment,
   userId varchar(255) not null,
   firstName varchar(255),
   lastName varchar(255),
   password varchar(255) not null,
   role varchar(255),
   contactId int
);

create table purchase_orders
(
   id int not null primary key auto_increment,
   userId varchar(255),
   productId int,
   category varchar(255),
   quantity int,
   amount double, 
   purchase_date Date
);