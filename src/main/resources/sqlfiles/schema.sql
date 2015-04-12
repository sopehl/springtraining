drop table customer if exists;

create table customer (id integer identity primary key,
                        firstName varchar(50), lastName varchar(50), number VARCHAR(50));
