package vet.app;

import org.springframework.data.jpa.repository.JpaRepository;

interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, Integer> {

}