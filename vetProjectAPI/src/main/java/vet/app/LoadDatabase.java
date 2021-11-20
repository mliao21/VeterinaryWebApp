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
  
  @Bean
  CommandLineRunner initTreatmentRecordDB(TreatmentRecordRepository repository) {
    return args -> {
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/19/2021", 1, 1, TreatmentStages.REQUEST_REGULAR, "eye injury", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/20/2021", 2, 2, TreatmentStages.REQUEST_CRITICAL, "hips swollen", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/21/2021", 3, 3, TreatmentStages.IN_PROGRESS_CRITICAL, "eye injury", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/22/2021", 4, 4, TreatmentStages.IN_PROGRESS_REGULAR, "hips swollen", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/23/2021", 5, 5, TreatmentStages.COMPLETED, "eye injury", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/24/2021", 6, 6, TreatmentStages.REQUEST_REGULAR, "hips swollen", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/25/2021", 7, 7, TreatmentStages.REQUEST_CRITICAL, "eye injury", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/26/2021", 1, 8, TreatmentStages.IN_PROGRESS_CRITICAL, "hips swollen", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/27/2021", 2, 9, TreatmentStages.IN_PROGRESS_REGULAR, "eye injury", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/28/2021", 3, 10, TreatmentStages.COMPLETED, "hips swollen", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/29/2021", 4, 11, TreatmentStages.REQUEST_REGULAR, "eye injury", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("11/30/2021", 5, 12, TreatmentStages.REQUEST_CRITICAL, "hips swollen", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("12/01/2021", 6, 13, TreatmentStages.IN_PROGRESS_CRITICAL, "eye injury", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("12/02/2021", 7, 14, TreatmentStages.IN_PROGRESS_REGULAR, "hips swollen", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("12/03/2021", 1, 15, TreatmentStages.COMPLETED, "eye injury", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new TreatmentRecord("12/04/2021", 2, 16, TreatmentStages.COMPLETED, "hips swollen", "12/31/2021", 1)));   

    };
  }
  
  @Bean
  CommandLineRunner initPrescriptionRecordMethodDB(PrescriptionRecordRepository repository) {
    return args -> {
    	log.info("Preloading " + repository.save(new PrescriptionRecord(1, 1, ScheduleType.Hourly, "take shots", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(2, 16, ScheduleType.Monthly, "check fur", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(3, 15, ScheduleType.Daily, "monitor paws", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(4, 14, ScheduleType.Annual, "take shots", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(5, 13, ScheduleType.Weekly, "check fur", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(6, 12, ScheduleType.Hourly, "monitor paws", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(7, 11, ScheduleType.Monthly, "take shots", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(8, 10, ScheduleType.Daily, "check fur", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(9, 9, ScheduleType.Annual, "monitor paws", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(10, 8, ScheduleType.Weekly, "take shots", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(11, 7, ScheduleType.Hourly, "check fur", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(12, 6, ScheduleType.Monthly, "monitor paws", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(13, 15, ScheduleType.Daily, "take shots", "12/31/2021", 1)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(14, 4, ScheduleType.Annual, "check fur", "12/31/2021", 2)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(15, 3, ScheduleType.Weekly, "monitor paws", "12/31/2021", 3)));
    	log.info("Preloading " + repository.save(new PrescriptionRecord(16, 12, ScheduleType.Weekly, "take shots", "12/31/2021", 1)));
    };
  }

    @Bean
    CommandLineRunner initAnimalDatabase(AnimalRepository repository) {

        return args -> {
            log.info("Preloading "
                    + repository.save(new Animal("Dog", 3.6, "2018-08-15", "MN", "Black and White", "Beagle", 234234,
                    "HOC London", "197839178371", "176387613813", "Available", "", "", "", "", "", "")));
            log.info("Preloading " + repository.save(
                    new Animal("Horse", 68, "2018-08-31", "FM", "", "Vanners", 564543, "ABC Paris", "8987498179390",
                            "5671876189197", "Injured", "", "", "", "", "High-stepping trot, flashy", "appearance")));
            log.info("Preloading "
                    + repository.save(new Animal("Cow", 127, "2018-02-31", "Mn", "", "Abigar", 564543, "CBH India",
                    "83612863189", "812381931998", "Sick", "Endangered", "meat", "Spain", "Taurus", "", "")));

        };
    }

    @Bean
    CommandLineRunner initAnimalStatusHistoryDB(AnimalStatusHistoryRepository repository) {

        return args -> {
            log.info("Preloading "
                    + repository.save(new AnimalStatusHistory("2021-12-12", "", "In Campus", "Available", 1)));
            log.info("Preloading " + repository
                    .save(new AnimalStatusHistory("2021-11-01", "Her foot is injured", "Hospital", "Injured", 2)));

        };
    }

    @Bean
	CommandLineRunner initCommentDB(CommentRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Comment(1, 1, "He is ill")));
			log.info("Preloading " + repository.save(new Comment(1, 2, "she is injured.")));
			log.info("Preloading " + repository.save(new Comment(2, 3, "I think he has pain")));

		};
	}

	@Bean
	CommandLineRunner initImagesDB(ImagesRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Images(1, "2021-03-08", "image1.png", 1, "profile")));
			log.info("Preloading " + repository.save(new Images(4, "2021-03-09", "image2.png", 2, "injury")));
			log.info("Preloading " + repository.save(new Images(4, "2021-03-10", "image3.png", 1, "Treatment")));
			log.info("Preloading " + repository.save(new Images(3, "2021-03-11", "image4.png", 1, "injury")));

		};
	}
	
	@Bean
	CommandLineRunner initUserDB(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new User("user 1", "admin", "admin@ucalgary.ca", "2021/03/04", false)));
		    log.info("Preloading " + repository.save(new User("user 2", "animal technician", "a.technician@ucalgary.ca", "2021/03/04", false)));
		    log.info("Preloading " + repository.save(new User("user 3", "teacher", "teacher@ucalgary.ca", "2021/03/05", false)));
		    log.info("Preloading " + repository.save(new User("user 4", "student", "student@ucalgary.ca", "2021/03/19", false)));

		};
    }
  
}