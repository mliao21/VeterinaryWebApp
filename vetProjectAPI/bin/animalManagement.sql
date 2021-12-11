DROP DATABASE IF EXISTS animalmanagement;
CREATE DATABASE  animalmanagement;
USE animalmanagement;

DROP TABLE IF EXISTS ANIMAL; 
create table ANIMAL (
   id          integer not null auto_increment,
   type       varchar(45),
   breed         varchar(45),
   name          varchar(45),
   status        varchar(45),
   weight        varchar(45),
   PRIMARY KEY (id)
   );
   
   
   INSERT INTO ANIMAL (type, breed, name, status, weight)
   VALUES
   ('Dog', 'Barbet', 'Ruger', 'Accepted_by_admin', '23.3'),
   ('Dog', 'Afada', 'Bruce', 'Available', '20.3'),
   ('Dog', 'Beagle', 'Lucky', 'New', '18.3'),
   ('Dog', 'Barbet', 'Beau', 'Available', '23.7'),
   ('Dog', 'Borker', 'Arlo', 'Accepted_by_admin', '16.3'),
   ('Dog', 'English Bulldog', 'Baxter', 'New', '17.3'),
   ('Dog', 'Pug', 'Arlo', 'Available', '21.3'),
   ('Dog', 'German Shepherd', 'Leo', 'Available', '22.3'),
   
   ('Cat', 'Persian Cat', 'Gizmo', 'Available', '4.3'),
   ('Cat', 'Ragdoll', 'Prince', 'Available', '5.3'),
   ('Cat', 'Persian Cat', 'Oreo', 'Available', '3.9'),
   ('Cat', 'Maine Coon', 'Monty', 'Accepted_by_admin', '3.7'),
   ('Cat', 'Siberian Cat', 'Merlin', 'New', '3.3'),
   ('Cat', 'Persian Cat', 'Pumpkin', 'New', '5.0'),
   ('Cat', 'Persian Cat', 'Gizmo', 'Available', '4.3'),
    ('Cat', 'Aegean', 'Smoky', 'Available', '4.3'),
    
	('Horse', 'Abtenauer', 'Barnaby', 'Available', '400'),
    ('Horse', 'Auxois', 'London', 'Accepted_by_admin', '435'),
    ('Horse', 'Altai horse', 'Beauty', 'Available', '360'),
    ('Horse', 'Appaloosa', 'Beethoven', 'New', '350'),
    ('Horse', 'Gidran', 'Lacey', 'Available', '420'),
    ('Horse', 'Konik', 'Marquis', 'Accepted_by_admin', '500'),
    ('Horse', 'Mustang', 'Misty', 'Available', '410'),
    ('Horse', 'Fleuve', 'Mona', 'Available', '389');
    
    
DROP TABLE IF EXISTS USER;
create table USER ( 
	id      integer not null,
    name    varchar(45),
   username varchar(45), 
   password   varchar(45),
    usertype    varchar(45),
    PRIMARY KEY (id)
);

INSERT INTO USER ( id, name, username, password, usertype)
VALUES

(200, 'Mark Spencer' , 'Instructor_1', 'pt@123', 'Instructor'),
(202, 'John Picky' , 'Admin_1', 'pa','Administrator'),
(201, 'Mary Mary' , 'Technician', 'pe', 'Technician');
   
   
DROP TABLE IF EXISTS ANIMAL_REQUEST;
create table ANIMAL_REQUEST ( 
    requestid     integer not null auto_increment,
    animalid     integer not null,
    userid        integer not null,
   	PRIMARY KEY (requestid)
	
);

INSERT INTO ANIMAL_REQUEST (animalid , userid)
 VALUES
   (2, 200),
   (4, 202),
   (15, 201),
   (9, 201),
   (21, 200),
   (25, 202),
   (7, 202),
   (10, 201);