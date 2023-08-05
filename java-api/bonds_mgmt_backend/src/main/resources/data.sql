INSERT INTO users (name, role, email, password) VALUES ('Samarth', 'admin','samarthnaphade@gmail.com','samarth');
INSERT INTO users (name, role, email, password) VALUES ('Rupanjali', 'admin','krupanjali73@gmail.com','rupanjali');
INSERT INTO users (name, role, email, password) VALUES ('Sakshi Desai', 'admin','sakshidesai145@gmail.com','sakshi');
INSERT INTO users (name, role, email, password) VALUES ('Sakshi Shah', 'admin','sakshidshah24@gmail.com','sakshi');
INSERT INTO users (name, role, email, password) VALUES ('Samyak Jain', 'admin','2019ucp1420@mnit.ac.in','samyak');

INSERT INTO books (book_name) VALUES ('test 1');
INSERT INTO books (book_name) VALUES ('test 2');
INSERT INTO books (book_name) VALUES ('test 3');

INSERT INTO bookUsers (book_id, user_id) VALUES (1,1);
INSERT INTO bookUsers (book_id, user_id) VALUES (2,2);
INSERT INTO bookUsers (book_id, user_id) VALUES (3,3);

INSERT INTO counterparty (name) VALUES ('DB');
INSERT INTO counterparty (name) VALUES ('CITI');
INSERT INTO counterparty (name) VALUES ('HSBC');

INSERT INTO security (issuer, maturity_date, coupon, type, face_value, status) VALUES ('CITI', '2023-09-04', 100, 'test', 120, 'not-mature');
INSERT INTO security (issuer, maturity_date, coupon, type, face_value, status) VALUES ('APPL', '2023-10-15', 120, 'test', 220, 'not-mature');

INSERT INTO trade (book_id, Counter_party_Id, Security_Id, Quantity, Status, Price, trade_type, trade_date, settlement_date) 
VALUES (1,2,1, 120, 'pending', 250, 'buy', '2023-08-05 12:12:12', null);

INSERT INTO trade (book_id, Counter_party_Id, Security_Id, Quantity, Status, Price, trade_type, trade_date, settlement_date) 
VALUES (2,2,2, 220, 'success', 350, 'buy', '2023-08-01 12:12:12', '2023-08-04 15:12:12');
