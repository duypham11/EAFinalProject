
-- to insert data to username table

INSERT INTO Username(username,UID,password,enabled) VALUES ('store@gmail.com','c298d333-2151-4668-ba49-1d8b74c76fea','store123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('nirav.dhinoja@gmail.com','c298d333-2151-4668-ba49-1d8b74c76f1s','nd123', FALSE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('dev.nirav.dhinoja@gmail.com','c298d333-2151-4668-ba49-1d8b74c76f1s','ndrider123', FALSE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('admin@gmail.com','f98ab14d-cf9a-48a7-a8c7-6b4b9bc3b2fd','admin123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('rider@gmail.com','7ad8f775-665e-4af2-a5ca-b36066f36bb6','rider123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('duynp@gmail.com','6bdb7db7-0c71-4d5e-a0f4-75de6bac206f','1234', TRUE);


-- to insert some data into Role table
INSERT INTO Role (username, role) VALUES ('store@gmail.com', 'ROLE_STORE');
INSERT INTO Role (username, role) VALUES ('nirav.dhinoja@gmail.com', 'ROLE_STORE');
INSERT INTO Role (username, role) VALUES ('admin@gmail.com', 'ROLE_ADMIN');
INSERT INTO Role (username, role) VALUES ('rider@gmail.com', 'ROLE_RIDER');
INSERT INTO Role (username, role) VALUES ('dev.nirav.dhinoja@gmail.com', 'ROLE_RIDER');
INSERT INTO Role (username, role) VALUES ('duynp@gmail.com', 'ROLE_RIDER');

-- to insert data for profile of users at different tables
INSERT INTO  Admin (firstname, lastname,title,username) VALUES ('Khlok','Sam','Mr.', 'admin@gmail.com');
INSERT INTO  Rider (email,firstname,lastname,photoURL,username,count,rate) VALUES ('rider@gmail.com','Camen','Rider', '7ad8f775-665e-4af2-a5ca-b36066f36bb6', 'rider@gmail.com',0,0);
INSERT INTO  Rider (email,firstname,lastname,photoURL,username,count,rate,address,state,phone) VALUES ('dev.nirav.dhinoja@gmail.com','Nirav','Rider', '7ad8f775-665e-4af2-a5ca-b36066f36b7y', 'dev.nirav.dhinoja@gmail.com',0,0,'address','iowa','1');
INSERT INTO  Store (name,firstname, lastname,username,note,email,address,phone) VALUES ('Panda Chinese Food','Sam','Khlok','store@gmail.com', 'great store', 'store@gmail.com','address 1 2 3','1012212122');
INSERT INTO  Store (name,firstname, lastname,username,note,email,address,phone) VALUES ('Indian National Bank','Nirav','Dhinoja','nirav.dhinoja@gmail.com', 'Indian Bank', 'nirav.dhinoja@gmail.com','Iowa','345468321378');
INSERT INTO  Rider (email,firstname,lastname,photoURL,username,count,rate) VALUES ('duynp@gmail.com','Dung','Nguyen', '6bdb7db7-0c71-4d5e-a0f4-75de6bac206f', 'duynp@gmail.com',0,0);

INSERT INTO ParcelStatus (status) VALUES ('NEW');
INSERT INTO ParcelStatus (status) VALUES ('RIDING');
INSERT INTO ParcelStatus (status) VALUES ('DONE');
INSERT INTO ParcelStatus (status) VALUES ('CANCELLED');

INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('304 W.Hempstead Avenue Fairfield, IA', 'Josh Stark', "12456", 1, 1, 1,'khlok.samphors@gmail.com', '7896547898');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('1000 N Street Fairfield, IA', 'Martin King', "7654321", 1, 3, 2,'khlok.samphors@gmail.com', '6758976543');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('123 E 25th Street Mt Plesant, IA', 'Bob Brother 2', "87659", 1, 1, 2,'dp12@gmail.com', '5152345678');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('98W Main Street FairField, IA', 'Mike', "238767559", 1, 1, 1,'normal@mail.com', '6752345674');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('304 W.Hempstead Avenue Fairfield, IA', 'Josh Stark 3', "123456", 1, 1, 1,'store@gmail.com', '2412349870');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('1000 N Street Fairfield, IA', 'Martin King V', "654321", 1, 1, 1,'khlok.samphors@gmail.com', '2408768990');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('123 E 25th Street Mt Plesant, IA', 'Bob Brother', "8732659", 1, 1, 2,'dp12@gmail.com', '3246547896');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('98W Main Street FairField, IA', 'Mike JA', "2387659", 1, 1, 1,'normal@gmail.com', '2347658997');
INSERT INTO Parcel (address, customerName, trackNumber, store_id, rider_id, status_id,email, phone) VALUES ('123 E Green Blv Ottumwa, IA', 'Baraba Bobb', "8765945", 1, 1, 1,'hunter@gmail.com', '2346758997');