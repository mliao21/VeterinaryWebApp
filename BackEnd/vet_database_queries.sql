USE VET;

-- 1. Show all Tables
SELECT * FROM ANIMAL;
SELECT * FROM USER;
SELECT * FROM ANIMAL_STATUS;
SELECT * FROM PREVENTIVE_CARE_TYPES;
SELECT * FROM ANIMAL_ONGOING_CARE;
SELECT * FROM IMAGES;
SELECT * FROM PRESCRIPTIONS;
SELECT * FROM TREATMENTS;
SELECT * FROM ANIMAL_HISTORY;
SELECT * FROM COMMENTS;
SELECT * FROM REQUESTS;

-- 2. Basic retrieval query (get comments and user for particular animal)
 SELECT Description, UserID
 FROM COMMENTS
 WHERE AnimalID = 1;
 
 -- 3. A retrieval query with ordered results(Get the history of particular animal latest to oldest)
 SELECT UserID, Measurement,Value,Date
 FROM ANIMAL_HISTORY
 WHERE AnimalID = 1
 ORDER BY DATE DESC;
 
 -- 4. A nested retrieval query
 
 
 
-- 5. A retrieval with joined tables (All animals schedule of preventive care)
 SELECT AnimalID, Type, Schedule
 FROM ANIMAL_ONGOING_CARE AS A LEFT OUTER JOIN PREVENTIVE_CARE_TYPES AS P ON A.PreventiveCareID = P.PreventiveCareID;
 
 
 -- 6. An update operation with any neccessary triggers (Update the status of treatment for an animal)
 UPDATE TREATMENTS
 SET Stage = "Completed"
 WHERE TreatmentID = 1 AND AnimalID = 1;
 
 -- 7. A deletion operation with any necessary triggers (Deleting animal from database)
 DELIMITER $$
 CREATE TRIGGER Before_Animal_delete
 BEFORE DELETE ON ANIMAL
 FOR EACH ROW
 BEGIN
	DELETE FROM ANIMAL_STATUS WHERE Old.AnimalID = AnimalID;
    DELETE FROM ANIMAL_ONGOING_CARE WHERE Old.AnimalID = AnimalID;
    DELETE FROM IMAGES WHERE Old.AnimalID = AnimalID;
    DELETE FROM PRESCRIPTIONS WHERE Old.AnimalID = AnimalID;
    DELETE FROM TREATMENTS WHERE Old.AnimalID = AnimalID;
    DELETE FROM ANIMAL_HISTORY WHERE Old.AnimalID = AnimalID;
    DELETE FROM COMMENTS WHERE Old.AnimalID = AnimalID;
    DELETE FROM REQUESTS WHERE Old.AnimalID = AnimalID;
 END
 DELIMITER $$
 
 DELETE FROM ANIMAL WHERE AnimalID = 1;
 
 DELIMITER $$
 CREATE TRIGGER Before_PreventiveCare_Delete
 BEFORE DELETE ON PREVENTIVE_CARE_TYPES
 FOR EACH ROW
 BEGIN
	DELETE FROM ANIMAL_ONGOING_CARE WHERE Old.PreventiveCareID = ANIMAL_ONGOING_CARE.PreventiveCareID
 END
 DELIMITER $$
 
 DELETE FROM PREVENTIVE_CARE_TYPES WHERE PreventiveCareID = 1;