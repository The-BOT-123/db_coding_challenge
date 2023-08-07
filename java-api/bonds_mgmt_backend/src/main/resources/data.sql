INSERT INTO Users (id, username, role, email, password) VALUES (1, 'admin', 'admin','admin@gmail.com','$2a$10$rYc3NTOoXkuItSrEI9navekqajlJ.IS7ZfScu5xYLP..uwvcICvPi');
INSERT INTO Users (id, username, role, email, password) VALUES (2, 'user', 'user','user@gmail.com','$2a$10$6Oxx8CREBurd.JZ0KK8mW.hcmZsaCjyC7h/xD4v1z2s1Z5PqeXiMW');

INSERT INTO Books (book_name) VALUES ('test 1');
INSERT INTO Books (book_name) VALUES ('test 2');
INSERT INTO Books (book_name) VALUES ('test 3');

INSERT INTO BookUsers (book_id, user_id) VALUES (1,1);
INSERT INTO BookUsers (book_id, user_id) VALUES (2,2);

INSERT INTO CounterParty (name) VALUES ('DB');
INSERT INTO CounterParty (name) VALUES ('CITI');
INSERT INTO CounterParty (name) VALUES ('HSBC');

INSERT INTO Security (issuer, maturity_date, coupon, type, face_value, status) VALUES ('CITI', '2023-09-04', 100, 'test', 120, 'not-mature');
INSERT INTO Security (issuer, maturity_date, coupon, type, face_value, status) VALUES ('APPL', '2023-10-15', 120, 'test', 220, 'not-mature');

INSERT INTO Trade (book_id, Counter_party_Id, Security_Id, Quantity, Status, Price, trade_type, trade_date, settlement_date) 
VALUES (1,2,1, 120, 'pending', 250, 'buy', '2023-08-05 12:12:12', null);

INSERT INTO Trade (book_id, Counter_party_Id, Security_Id, Quantity, Status, Price, trade_type, trade_date, settlement_date) 
VALUES (2,2,2, 220, 'success', 350, 'buy', '2023-08-01 12:12:12', '2023-08-04 15:12:12');
