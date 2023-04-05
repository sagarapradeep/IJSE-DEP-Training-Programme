CREATE table IF NOT EXISTS ItemManagement_dep10.Items
(
    code          INT PRIMARY KEY AUTO_INCREMENT,
    description   VARCHAR(200) NOT NULL,
    buying_price  DECIMAL (7,2)    NOT NULL,
    selling_price DECIMAL (7,2)     NOT NULL,
    stock         INT          NOT NULL



);

CREATE TABLE IF NOT EXISTS Preview
(
    item_code INT PRIMARY KEY,
    preview   BLOB NOT NULL,

    CONSTRAINT fk_preview FOREIGN KEY (item_code) REFERENCES Items (code)

);

DROP TABLE Items;

DROP table Preview;



