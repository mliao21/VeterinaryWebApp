package vet.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initTreatmentMethodDB(TreatmentMethodRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new TreatmentMethod("Physical exam")));
      log.info("Preloading " + repository.save(new TreatmentMethod("Blood work")));
      log.info("Preloading " + repository.save(new TreatmentMethod("Da2pp")));
      log.info("Preloading " + repository.save(new TreatmentMethod("dental cleaning")));
      log.info("Preloading " + repository.save(new TreatmentMethod("drontal deworm")));
      log.info("Preloading " + repository.save(new TreatmentMethod("rabies vaccination")));
      log.info("Preloading " + repository.save(new TreatmentMethod("Revolution treatment")));
    };
  }
  
  @Bean
  CommandLineRunner initPrescriptionTypeDB(PrescriptionTypeRepository repository) {
    return args -> {
    	log.info("Preloading " + repository.save(new PrescriptionType("XRAY")));
    	log.info("Preloading " + repository.save(new PrescriptionType("DICOm")));
    	log.info("Preloading " + repository.save(new PrescriptionType("SOAP")));
    	log.info("Preloading " + repository.save(new PrescriptionType("FORM")));
    	log.info("Preloading " + repository.save(new PrescriptionType("IMAGE")));
    	log.info("Preloading " + repository.save(new PrescriptionType("NOTE")));
    	log.info("Preloading " + repository.save(new PrescriptionType("LAB")));
    	log.info("Preloading " + repository.save(new PrescriptionType("LINK")));
    	log.info("Preloading " + repository.save(new PrescriptionType("RECHECKS")));
    	log.info("Preloading " + repository.save(new PrescriptionType("DX")));
    	log.info("Preloading " + repository.save(new PrescriptionType("SURGERY")));
    	log.info("Preloading " + repository.save(new PrescriptionType("XRAY")));
    	log.info("Preloading " + repository.save(new PrescriptionType("TRANSFERS")));
    	log.info("Preloading " + repository.save(new PrescriptionType("STUDENT SOAP")));
    	log.info("Preloading " + repository.save(new PrescriptionType("PROB")));
    	log.info("Preloading " + repository.save(new PrescriptionType("INVOICE")));
    	log.info("Preloading " + repository.save(new PrescriptionType("PRODUCT NOTE")));
    };
    
  }
  
}