DROP DATABASE IF EXISTS VET;
CREATE DATABASE VET;
USE VET;

DROP TABLE IF EXISTS ANIMAL;
CREATE TABLE ANIMAL (
	AnimalID	integer	not null auto_increment,
	Name		varchar(30)	not null,
	Sex			char(1) not null,
    Age			integer,
    Weight		float,
    Species		varchar(30),
    Breed		varchar(30) not null,
	primary key (AnimalID)
);

INSERT INTO ANIMAL (Name, Sex, Age, Weight, Species, Breed)
VALUES
('Max', 'M', '5', '74.31', 'Horse', 'Appaloosa'),
('Charlie', 'F', '6', '92.12', 'Dog', 'Rottweiler'),
('Luna', 'F', '4', '41.41', 'Cat', 'Sphynx'),
('Milo', 'M', '3', '157.57', 'Cattle', 'American'),
('Cooper', 'F', '2', '33.82', 'Pig', 'Basque'),
('Simba', 'M', '7', '118.08', 'Rabbit', 'Angora'),
('Loki', 'M', '8', '63.78', 'Fish', 'Blobfish'),
('Lola', 'F', '12', '64.78', 'Horse', 'Mustang'),
('Bailey', 'F', '4', '185.6', 'Dog', 'Terrier'),
('Fluffy', 'M', '3', '100.84', 'Sheep', 'Algerian');

DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
	UserID		integer	not null auto_increment,
    Role		varchar(25)	not null,
    Username	varchar(30) not null,
    Email		varchar(30),
    Password	varchar(15) not null,
    Status		varchar(10) not null,
	primary key (UserID)
);

INSERT INTO USER (Role, Username, Email, Password, Status)
VALUES
('Admin', 'admin1', 'admin1@test.com', 'kajflkalkf', 'Active'),
('Care_attendant', 'attendant1', 'attendant1@test.com', 'adfqekljf', 'Active'),
('Health_technician', 'doctor1', 'doctor1@test.com', 'adflkajdf', 'Active'),
('Teaching_technician', 'teacher1', 'teacher1@test.com', 'adflkajdf', 'Active'),
('Student', 'student1', 'student1@test.com', 'fahdfer', 'Active'),
('Health_technician', 'doctor2', 'doctor2@test.com', 'fjqelf', 'Active'),
('Teaching_technician', 'teacher2', 'teacher2@test.com', 'adkfjewa', 'Active'),
('Care_attendant', 'attendant3', 'attendant3@test.com', 'fajdfjoie', 'Active'),
('Care_attendant', 'attendant4', 'attendant4@test.com', 'afeifndkf', 'Blocked'),
('Student', 'Student2', 'Student2@test.com', 'fqoierf', 'Active'),
('Student', 'Student3', 'Student3@test.com', 'fjqoeijfj', 'Active'),
('Student', 'Student4', 'Student4@test.com', 'fjqiejad', 'Active'),
('Student', 'Student5', 'Student5@test.com', 'jfoqefoi', 'Blocked');

DROP TABLE IF EXISTS ANIMAL_STATUS;
CREATE TABLE ANIMAL_STATUS (
	AnimalID		integer	not null,
    Location		varchar(10)	not null,
    Status			varchar(10) not null,
    Description 	varchar(200),
    LastUser		integer	not null,
	primary key (AnimalID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (LastUser) references USER(UserID) on delete cascade
);

INSERT INTO ANIMAL_STATUS (AnimalID, Location, Status, Description, LastUser)
VALUES
('1', 'On Campus', 'Available', '', '7'),
('2', 'Hospital', 'Available', '', '3'),
('3', 'On Campus', 'Available', '', '4'),
('4', 'Hospital', 'Injured', 'foot injured', '6'),
('5', 'Hospital', 'Injured', 'eye injured', '6'),
('6', 'Hospital', 'Injured', 'butt injured', '3'),
('7', 'Hospital', 'Injured', 'head injured', '3'),
('8', 'Hospital', 'Injured', 'eye infection', '9'),
('9', 'On Campus', 'Available', '', '4'),
('10', 'On Campus', 'Available', '', '7');

DROP TABLE IF EXISTS PREVENTIVE_CARE_TYPES;
CREATE TABLE PREVENTIVE_CARE_TYPES (
	PreventiveCareID	integer	not null auto_increment,
    Type				varchar(30) not null,
	primary key (PreventiveCareID)
);

INSERT INTO PREVENTIVE_CARE_TYPES (Type)
VALUES
('Spaying/Neutering'),
('Record weight'),
('Check for parasites'),
('Dental care'),
('Exam 1'),
('Exam 2'),
('Exam 3'),
('Vaccination 1'),
('Vaccination 2'),
('Vaccination 3');

DROP TABLE IF EXISTS ANIMAL_ONGOING_CARE;
CREATE TABLE ANIMAL_ONGOING_CARE (
	AnimalID			integer	not null,
    PreventiveCareID	integer	not null,
    Schedule			varchar(10) not null,
	primary key (AnimalID, PreventiveCareID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (PreventiveCareID) references PREVENTIVE_CARE_TYPES(PreventiveCareID) on delete cascade
);

INSERT INTO ANIMAL_ONGOING_CARE (AnimalID, PreventiveCareID, Schedule)
VALUES
('2', '1', 'Weekly'),
('2', '2', 'Monthly'),
('2', '3', 'Bi-weekly'),
('2', '4', 'Monthly'),
('5', '1', 'Monthly'),
('5', '2', 'Bi-weekly'),
('5', '3', 'Weekly'),
('5', '4', 'Monthly'),
('1', '5', 'Annually'),
('3', '6', 'Monthly'),
('4', '7', 'Annually'),
('1', '8', 'Annually'),
('7', '9', 'Monthly'),
('6', '10', 'Annually');

DROP TABLE IF EXISTS IMAGES;
CREATE TABLE IMAGES (
	ImageID			integer	not null auto_increment,
	AnimalID		integer	not null,
    CreationDate	date not null,
    File			varchar(30) not null,
    Type			varchar(15) not null,
    UserID			integer	not null,
	primary key (ImageID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO IMAGES (AnimalID, CreationDate, File, Type, UserID)
VALUES
('1', '2021-12-01', 'image1.png', 'profile', '2'),
('2', '2021-12-02', 'image2.jpg', 'profile', '3'),
('3', '2021-12-03', 'image3.png', 'profile', '4'),
('4', '2021-12-04', 'image4.png', 'profile', '2'),
('5', '2021-12-05', 'image5.png', 'profile', '6'),
('6', '2021-12-06', 'image6.jpg', 'profile', '7'),
('7', '2021-12-07', 'image7.jpg', 'profile', '8'),
('8', '2021-12-08', 'image8.png', 'profile', '9'),
('9', '2021-12-09', 'image9.jpg', 'profile', '6'),
('10', '2021-12-10', 'image10.png', 'profile', '7'),
('1', '2021-12-11', 'image11.png', 'injury', '8'),
('2', '2021-12-12', 'image12.jpg', 'treatment', '9'),
('3', '2021-12-13', 'image13.png', 'treatment', '3'),
('4', '2021-12-14', 'image14.png', 'injury', '4'),
('5', '2021-12-15', 'image15.jpg', 'injury', '6');

DROP TABLE IF EXISTS PRESCRIPTIONS;
CREATE TABLE PRESCRIPTIONS (
	PrescriptionID	integer	not null auto_increment,
	AnimalID		integer	not null,
    UserID			integer	not null,
    Date			date not null,
    Instructions 	varchar(200),
    DrugName		varchar(30) not null,
    Dosage			varchar(10) not null,
    DeliveryMethod	varchar(50),
	primary key (PrescriptionID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO PRESCRIPTIONS (AnimalID, UserID, Date, Instructions, DrugName, Dosage, DeliveryMethod)
VALUES
('1', '3', '2021-12-01', 'take once a day', 'drug1', '10mg', 'swallowing'),
('4', '3', '2021-12-04', 'once a month', 'drug2', '60ml', 'IV injection'),
('5', '3', '2021-12-05', 'once a month', 'drug3', '42oz', 'inhalation'),
('6', '6', '2021-12-06', 'take twice a day', 'drug4', '3oz', 'swallowing'),
('1', '3', '2021-12-07', 'every 4 months', 'drug5', '55mg', 'absorption'),
('2', '6', '2021-12-08', 'take twice a week', 'drug6', '12oz', 'swallowing'),
('3', '6', '2021-12-09', 'take twice a month', 'drug7', '8ml', 'IV injection'),
('7', '6', '2021-12-13', 'every 6 months', 'drug8', '23oz', 'absorption'),
('8', '3', '2021-12-14', 'take it daily', 'drug9', '2oz', 'swallowing');

DROP TABLE IF EXISTS TREATMENTS;
CREATE TABLE TREATMENTS (
	TreatmentID		integer	not null auto_increment,
    Type			varchar(30) not null,
	AnimalID		integer	not null,
    Description 	varchar(200),
    Stage			varchar(15) not null,
    UserID			integer	not null,
    Date			date not null,    
	primary key (TreatmentID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO TREATMENTS (Type, AnimalID, Description, Stage, UserID, Date)
VALUES
('Blood work', '1', '', 'In progress', '3', '2021-12-01'),
('Bordetella vaccine', '2', '', 'In progress', '2', '2021-12-02'),
('Deworming', '3', 'teach 1st years', 'Completed', '4', '2021-12-03'),
('Rabies vaccination', '1', 'teach 1st years', 'In progress', '7', '2021-12-04'),
('Chemo treatment', '4', 'Monitor progress', 'Critical', '6', '2021-12-05'),
('Blood work', '5', 'Monitor progress', 'Critical', '3', '2021-12-06'),
('Bordetella vaccine', '6', '', 'In progress', '8', '2021-12-07'),
('Deworming', '3', '', 'Completed', '9', '2021-12-08'),
('Rabies vaccination', '8', '', 'Completed', '2', '2021-12-09'),
('Chemo treatment', '9', 'Monitor progress', 'Critical', '6', '2021-12-10');

DROP TABLE IF EXISTS ANIMAL_HISTORY;
CREATE TABLE ANIMAL_HISTORY (
	RecordID		integer	not null auto_increment,
    Date			date not null,
    AnimalID		integer	not null,
    Measurement 	varchar(30) not null,
    Value			varchar(15) not null,
    UserID			integer	not null,
	primary key (RecordID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO ANIMAL_HISTORY (Date, AnimalID, Measurement, Value, UserID)
VALUES
('2021-12-01', '1', 'Weight', '100 lbs', '2'),
('2021-12-02', '8', 'Blood concentration', '0.20%', '3'),
('2021-12-03', '9', 'Heart beat', '60 bpm', '4'),
('2021-12-04', '4', 'Temperature', '100 F', '6'),
('2021-12-05', '5', 'Dental status', '4 mm', '7'),
('2021-12-06', '1', 'Weight', '200 lbs', '8'),
('2021-12-07', '2', 'Blood concentration', '0.10%', '9'),
('2021-12-08', '3', 'Heart beat', '100 bpm', '2'),
('2021-12-09', '4', 'Temperature', '75 F', '3'),
('2021-12-10', '5', 'Dental status', '1 mm', '4'),
('2021-12-11', '6', 'Weight', '68 lbs', '6'),
('2021-12-12', '7', 'Blood concentration', '0.25%', '7'),
('2021-12-13', '8', 'Heart beat', '200 bpm', '8'),
('2021-12-14', '9', 'Temperature', '85 F', '9'),
('2021-12-15', '10', 'Dental status', '3 mm', '2');

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS (
	CommentID		integer	not null auto_increment,
    UserID			integer	not null,
    AnimalID		integer	not null,
    Description 	varchar(200) not null,
    Date			date not null,  
	primary key (CommentID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO COMMENTS (UserID, AnimalID, Description, Date)
VALUES
('2', '1', 'skin rash', '2021-12-01'),
('3', '2', 'has swollen feet', '2021-12-02'),
('4', '3', 'is underweight', '2021-12-03'),
('5', '4', 'looks cute', '2021-12-04'),
('6', '5', 'is overweight', '2021-12-05'),
('7', '6', 'monitor very closely', '2021-12-06'),
('10', '9', 'looks small', '2021-12-09'),
('11', '4', 'looks too afraid', '2021-12-10'),
('6', '10', 'signs of blindness', '2021-12-15');

DROP TABLE IF EXISTS REQUESTS;
CREATE TABLE REQUESTS (
	AnimalID		integer	not null,
    UserID			integer	not null,
    RequestStatus	varchar(20) not null,
    RequestedDate	date not null,  
	primary key (AnimalID),
    foreign key (AnimalID) references ANIMAL(AnimalID) on delete cascade,
    foreign key (UserID) references USER(UserID) on delete cascade
);

INSERT INTO REQUESTS (AnimalID, UserID, RequestStatus, RequestedDate)
VALUES
('2', '4', 'new', '2022-01-01'),
('1', '8', 'approved', '2022-01-02'),
('4', '4', 'new', '2022-01-03'),
('3', '8', 'approved', '2022-01-04'),
('9', '2', 'approved', '2022-01-05'),
('10', '2', 'approved', '2022-01-06'),
('6', '7', 'new', '2022-01-07'),
('7', '4', 'new', '2022-01-08'),
('8', '7', 'new', '2022-01-09');

SELECT * from Roles;
SELECT * from users;
INSERT INTO Roles (id,name)
VALUES
(1,"ROLE_ADMIN"),
(2,"ROLE_TECHNICIAN"),
(3,"ROLE_ATTENDANT"),
(4,"ROLE_HEALTH"),
(5,"ROLE_STUDENT");