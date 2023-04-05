drop table if exists User;
create table User
(
    username  varchar(100) primary key,
    full_name varchar(100)          not null,
    password  varchar(300)          not null,
    role      enum ('ADMIN','USER') not null
);

create table Customer
(
    id      INT PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS Contact;

CREATE TABLE Contact
(
    contact     VARCHAR(15) NOT NULL,
    customer_id INT         NOT NULL,
    CONSTRAINT pk_contact PRIMARY KEY (contact, customer_id),
    CONSTRAINT uk_contact UNIQUE KEY (contact),
    CONSTRAINT fk_contact FOREIGN KEY (customer_id) REFERENCES Customer (id)
);







