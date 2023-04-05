CREATE TABLE Student
(
    id          INT PRIMARY KEY,
    first_name  VARCHAR(100)           NOT NULL,
    second_name VARCHAR(100)           NOT NULL,
    address     VARCHAR(200)           NOT NULL,
    gender      ENUM ('MALE','FEMALE') NOT NULL,
    dob         DATE                   NOT NULL

);

#dummy data

