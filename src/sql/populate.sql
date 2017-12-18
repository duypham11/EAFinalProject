
-- to insert data to username table

INSERT INTO Username(username,UID,password,enabled) VALUES ('store@gmail.com','c298d333-2151-4668-ba49-1d8b74c76fea','store123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('admin@gmail.com','f98ab14d-cf9a-48a7-a8c7-6b4b9bc3b2fd','admin123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('rider@gmail.com','7ad8f775-665e-4af2-a5ca-b36066f36bb6','rider123', TRUE);

-- to insert some data into Role table
INSERT INTO Role (username, role) VALUES ('store@gmail.com', 'ROLE_STORE');
INSERT INTO Role (username, role) VALUES ('admin@gmail.com', 'ROLE_ADMIN');
INSERT INTO Role (username, role) VALUES ('rider@gmail.com', 'ROLE_RIDER');

-- to insert data for profile of users at different tables
INSERT INTO  Admin (firstname, lastname,title,username) VALUES ('Khlok','Sam','Mr.', 'admin@gmail.com');
INSERT INTO  Rider (email,firstname,lastname,photoURL,username,count,rate) VALUES ('rider@gmail.com','Camen','Rider', '7ad8f775-665e-4af2-a5ca-b36066f36bb6', 'rider@gmail.com',0,0);
INSERT INTO  Store (name,firstname, lastname,username,note,email,address,phone) VALUES ('Panda Chinese Food','Sam','Khlok','store@gmail.com', 'great store', 'khlok.samphors@gmail.com','address 1 2 3','1012212122');

INSERT INTO ParcelStatus (status) VALUES ('NEW');
INSERT INTO ParcelStatus (status) VALUES ('RIDING');
INSERT INTO ParcelStatus (status) VALUES ('DONE');
INSERT INTO ParcelStatus (status) VALUES ('CANCELLED');

INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email) VALUES ('304 W.Hempstead Avenue Fairfield, IA', 'Josh Stark', "123456", 1, 1, 1,'khlok.samphors@gmail.com');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email) VALUES ('1000 N Street Fairfield, IA', 'Martin King', "654321", 1, 1, 1,'khlok.samphors@gmail.com');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email) VALUES ('123 E 25th Street Mt Plesant, IA', 'Bob Brother', "87659", 1, 1, 3,'dp12@gmail.com');
