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
 SELECT UserID, Measurement, Value, Date
 FROM ANIMAL_HISTORY
 WHERE AnimalID = 1
 ORDER BY DATE DESC;
 
 -- 4. A nested retrieval query (Construct a medical history report of a particular animal)
 SELECT R.Date, A.Name, A.Species, A.Breed, R.Type, R.Information, U.Username FROM (
 SELECT T.Date, T.AnimalID, "Treatment" AS Type, CONCAT("ID = ", T.TreatmentID, ", Type: ", T.Type, ", Description: ", T.Description, ", Status: ", T.Stage) AS Information, T.UserID FROM TREATMENTS AS T
 UNION
 SELECT P.Date, P.AnimalID, "Prescription" AS Type, CONCAT("ID = ", P.PrescriptionID, ", Instructions: ", P.Instructions, ", Drug: ", P.DrugName, ", Dosage: ", P.Dosage, ", Delivery Method: ", P.DeliveryMethod) AS Information, P.UserID FROM PRESCRIPTIONS AS P
 UNION
 SELECT H.Date, H.AnimalID, "Measurement" AS Type, CONCAT("ID = ", H.RecordID, ", Type: ", H.Measurement, ", New Value: ", H.Value) AS Information, H.UserID FROM ANIMAL_HISTORY AS H
 ) AS R, ANIMAL AS A, USER AS U
 WHERE R.AnimalID = A.AnimalID AND R.UserID = U.UserID AND R.AnimalID = 3 
 ORDER BY Date DESC;
 
-- 5. A retrieval with joined tables (All animals schedule of preventive care)
 SELECT AnimalID, Type, Schedule
 FROM ANIMAL_ONGOING_CARE AS A LEFT OUTER JOIN PREVENTIVE_CARE_TYPES AS P ON A.PreventiveCareID = P.PreventiveCareID;
 
 
 -- 6. An update operation with any neccessary triggers (Update the status of treatment for an animal)
 UPDATE TREATMENTS
 SET Stage = "Completed"
 WHERE TreatmentID = 1 AND AnimalID = 1;
 
 -- 7. A deletion operation with any necessary triggers (Deleting animal from database)
 DELETE FROM ANIMAL
 WHERE AnimalID = 1;
 