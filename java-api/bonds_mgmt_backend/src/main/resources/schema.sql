CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Books (
    id int NOT NULL AUTO_INCREMENT,
    book_Name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Security (
    id INT NOT NULL AUTO_INCREMENT,
    Issuer varchar(255) NOT NULL,
    Maturity_Date DATE NOT NULL,
    Coupon BIGINT NOT NULL,
    Type varchar(255) NOT NULL,
    Face_value BIGINT NOT NULL,
    Status ENUM('not-mature','mature', 'post-mature') NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CounterParty (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS BookUsers (
    Book_Id INT NOT NULL,
    User_Id INT NOT NULL,
    FOREIGN key
        (Book_Id) REFERENCES Books (id),
    FOREIGN key
        (User_Id) REFERENCES Users (id)
);


CREATE TABLE IF NOT EXISTS Trade (
   id INT NOT NULL AUTO_INCREMENT,
   book_Id INT NOT NULL,
   Counter_party_Id INT NOT NULL,
   Security_Id INT NOT NULL,
   Quantity BIGINT NOT NULL,
   Status ENUM('success', 'pending', 'failed') NOT NULL,  
   Price BIGINT NOT NULL,
   trade_type ENUM('buy','sell') NOT NULL,
   trade_date DATETIME NOT NULL,
   settlement_date DATETIME NULL,
   PRIMARY KEY (id),
   FOREIGN key
       (book_Id) REFERENCES Books (id),
   FOREIGN key
       (Counter_party_Id) REFERENCES counterparty (id),
   FOREIGN key
       (Security_Id) REFERENCES security (id)
);


