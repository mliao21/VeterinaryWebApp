# Final-Project
SPRINT #3 - Designing the required API: User Stories ID >> Classes and Interfaces

VMWA-29: Animal Management Epic
- VMWA-31
- VMWA-32
- VMWA-33
- VMWA-36
- VMWA-37
- VMWA-38
- VMWA-39
- VMWA-40
- VMWA-41

VMWA-34: User Management Epic
- VMWA-42
- VMWA-43
- VMWA-44
- VMWA-45
- VMWA-46
- VMWA-60

Smple guideline for running Curl commands.	
VMWA-35: Treatment Process Epic
- VMWA-47 >> curl -X GET http://localhost:8080/treatment/records
- VMWA-48 >> curl -X PUT "http://localhost:8080/treatment/records/comment/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"comment\":\"testing\"},"
- VMWA-50 >> curl -X POST "http://localhost:8080/treatment/records" -H "accept: */*" -H "Content-Type: application/json" -d "{\"creationDate\":\"11/20/2021\", \"treatmentType\":\"4\", \"animalId\":\"3\", \"stage\":\"REQUEST_REGULAR\", \"comment\":\"has some tiny infections\", \"lastUpdate\":\"11/20/2021\", \"userId\":\"21\"}"
- VMWA-51 >> curl -X PUT "http://localhost:8080/treatment/records/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"creationDate\":\"11/20/2021\", \"treatmentType\":\"4\", \"animalId\":\"3\", \"stage\":\"REQUEST_CRITICAL\", \"comment\":\"has some tiny infections\", \"lastUpdate\":\"11/20/2021\", \"userId\":\"21\"},"
- VMWA-52 >> curl -X PUT "http://localhost:8080/treatment/records/stage/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"stage\":\"IN_PROGRESS_CRITICAL\"},"
- VMWA-53 >> curl -X POST "http://localhost:8080/prescription/records" -H "accept: */*" -H "Content-Type: application/json" -d "{\"treatmentId\":\"5\", \"type\":\"4\", \"schedule\":\"Monthly\", \"description\":\"needs to take medication XYZ\", \"lastUpdate\":\"11/20/2021\", \"userId\":\"21\"}"
- VMWA-54 >> curl -X PUT "http://localhost:8080/treatment/records/stage/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"stage\":\"IN_PROGRESS_CRITICAL\"},"
- VMWA-55 >> curl -X GET http://localhost:8080/treatment/records
- VMWA-56 >> curl -X GET http://localhost:8080/treatment/records/1
- VMWA-57 >> curl -X PUT "http://localhost:8080/treatment/records/comment/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"comment\":\"testing\"},"
- VMWA-59 >> curl -X PUT "http://localhost:8080/treatment/records/comment/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"comment\":\"testing\"},"
- 
VMWA=31 Animal management epic
- VMWA-47 >> curl -X GET http://localhost:8080/animals
- VMWA-48 >> curl -X PUT "http://localhost:8080/animals/4" -H "accept: /" -H "Content-Type: application/json" -d "{ \"id\": 4,\ "type":"bunny\", \"weight\":1.9, \"DOB\":"2018-08-28", \"sex\":"MN",\"colour\":"white", \"bread\":"brown bunny", \"tattoo\":24234, \"city\": \"Canada\", \"RFID\":"19783917834", \"microchirp\":"19783464834", \"status\":"Injured", \"draught\":"", \"meat\":"", \"region\":"North America", \"subspecies\":"", \"distinguishing\":"", \"features\":""},"
- VMWA-50 >> curl -X POST "http://localhost:8080/animals -H "accept: /" -H "Content-Type: application/json" -d "{\"type\":"cat", \"weight\":2.5, \"DOB\":"2018-08-28", \"sex\":"MN", \"colour\":"white", \"bread\":"white cat", \"tattoo\":24234, \"city\": "Mexico", \"RFID\":"19783917834", \"microchirp\":"19783464834", \"status\":"Available", \"draught\":"", \"meat\":"", \"region\":"North America", \"subspecies\":"", \"distinguishing\":"", \"features\":""}"





