package vet.app;

import org.springframework.data.jpa.repository.JpaRepository;

interface PrescriptionRecordRepository extends JpaRepository<PrescriptionRecord, Integer> {

}