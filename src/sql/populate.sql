-- INSERT INTO address VALUES (NULL,'442 Glenwood Avenue','Culver City','CA', '87547');
-- INSERT INTO address VALUES (NULL,'1 Yellow Brook Road','Emerald City','OZ', '12345');
 
-- INSERT INTO employee VALUES (NULL,12, 8754,'Curious','George' ,'Boy Monkey',1);
-- INSERT INTO employee VALUES (NULL,123, 8733,'Allen','Rench' ,'Torque Master',2);

INSERT INTO Username(username,UID,password,enabled) VALUES ('restaurant@gmail.com','c298d333-2151-4668-ba49-1d8b74c76fea','restaurant123', TRUE);
-- INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('admin@gmail.com','f98ab14d-cf9a-48a7-a8c7-6b4b9bc3b2fd','admin123', TRUE);
INSERT INTO Username(username,UID,password,enabled) VALUES ('camilo@gmail.com','7ad8f775-665e-4af2-a5ca-b36066f36bb6','rider123', TRUE);
  
INSERT INTO Role (username, role) VALUES ('restaurant@gmail.com', 'ROLE_RESTAURANT');
INSERT INTO Role (username, role) VALUES ('admin@gmail.com', 'ROLE_ADMIN');
INSERT INTO Role (username, role) VALUES ('camilo@gmail.com', 'ROLE_RIDER');
-- INSERT INTO role (username, role) VALUES ('admin', 'ROLE_USER');
 
-- INSERT INTO  User (firstname, lastname,age,title,membernumber, username) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
-- INSERT INTO User (firstname, lastname,age,title,membernumber,username) VALUES ('Allen','Rench',123,'Torque Master', 8733,'restaurant');
-- INSERT INTO User (firstname, lastname,age,title,membernumber,username) VALUES ('Allen2','Rench2',123,'Torque Master', 8736,'deliverer');

INSERT INTO  Admin (firstname, lastname,title,username) VALUES ('Peter','Xi','Mr.', 'admin@gmail.com');
INSERT INTO  Rider (email,firstname,lastname,photoURL,username) VALUES ('camilo.constante@gmail.com','Camilo','Andres', '7ad8f775-665e-4af2-a5ca-b36066f36bb6', 'camilo@gmail.com');
-- INSERT INTO  Restaurant (name,firstname, lastname,title,username) VALUES ('Panda Chinese Food','Sam','Khlok','Mr.', 'restaurant');
-- INSERT INTO  Deliverer (firstname, lastname,title,username) VALUES ('Camilo','Antonio','Mr.', 'deliverer');
INSERT INTO  Restaurant (name,firstname, lastname,username,note,email,address,phone) VALUES ('Panda Chinese Food','Sam','Khlok','restaurant@gmail.com', 'great restaurant', 'khlok.samphors@gmail.com','address 1 2 3','1012212122');

INSERT INTO OrderStatus (status) VALUES ('NEW');
INSERT INTO OrderStatus (status) VALUES ('RIDING');
INSERT INTO OrderStatus (status) VALUES ('DONE');

INSERT INTO OrderDelivery (address, customerName, trackNumber, restaurant_id, rider_id, status_id,email) VALUES ('304 W.Hempstead Avenue Fairfield, IA', 'Josh Stark', "123456", 1, 1, 1,'khlok.samphors@gmail.com');
INSERT INTO OrderDelivery (address, customerName, trackNumber, restaurant_id, rider_id, status_id,email) VALUES ('1000 N Street Fairfield, IA', 'Martin King', "654321", 1, 1, 1,'khlok.samphors@gmail.com');
 