package vet.app;

import org.springframework.data.jpa.repository.JpaRepository;

interface PrescriptionTypeRepository extends JpaRepository<PrescriptionType, Integer> {

}