CREATE TABLE IF NOT EXISTS Student(
                                      id INT PRIMARY KEY ,
                                      name VARCHAR(100) NOT NULL ,
                                      address VARCHAR(100) NOT NULL

);

CREATE TABLE IF NOT EXISTS Contact
(
    contact    VARCHAR(18) NOT NULL,
    student_id INT,

    CONSTRAINT pk_contact PRIMARY KEY (contact,student_id)
);

ALTER TABLE Contact
    ADD CONSTRAINT fk_contact FOREIGN KEY (student_id) REFERENCES Student (id);
