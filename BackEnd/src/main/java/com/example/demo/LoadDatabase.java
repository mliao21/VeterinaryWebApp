package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase{

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//  
//    @Bean
//    CommandLineRunner initAnimalDatabase(AnimalRepository repository) {
//
//        return args -> {
//            log.info("Preloading "
//                    + repository.save(new Animal((long)1,"Dog", 3.6, "Beagle", "Available", "Larry")));
//            log.info("Preloading " + repository.save(
//                    new Animal((long)2, "Horse", 68, "Vanners", "Injured", "David")));
//            log.info("Preloading "
//                    + repository.save(new Animal((long)3, "Cow", 127, "Abigar", "Sick", "Bruce")));
//
//        };
//    }

    
	
//	@Bean
//	CommandLineRunner initUserDB(UserRepository repository) {
//		return args -> {
//			log.info("Preloading " + repository.save(new User(1,"user 1", "admin", "admin@ucalgary.ca")));
//		    log.info("Preloading " + repository.save(new User(2,"user 2", "animal technician", "a.technician@ucalgary.ca")));
//		    log.info("Preloading " + repository.save(new User(3,"user 3", "teacher", "teacher@ucalgary.ca")));
//		    log.info("Preloading " + repository.save(new User(4,"user 4", "student", "student@ucalgary.ca")));
//
//		};
//    }

}