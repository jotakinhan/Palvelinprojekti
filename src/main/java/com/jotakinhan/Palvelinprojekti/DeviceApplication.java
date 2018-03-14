package com.jotakinhan.Palvelinprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jotakinhan.Palvelinprojekti.model.Device;
import com.jotakinhan.Palvelinprojekti.model.DeviceRepository;
import com.jotakinhan.Palvelinprojekti.model.User;
import com.jotakinhan.Palvelinprojekti.model.UserRepository;

@SpringBootApplication
public class DeviceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DeviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DeviceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner deviceDemo(DeviceRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("saving example devices");
			//Creating some entries in repository
			repository.save(new Device("Phone", "iPhone", "Screen cracked", "12.03.2017", "Waiting for parts", 40.00));
			repository.save(new Device("Laptop", "Lenovo-z50", "Battery dead", "14.02.2018", "Repaired", 20.00));
			repository.save(new Device("Tablet", "Nexus 7", "Unknown", "10.01.2018", "Defect to be diagnosed", 0.00));
			
			// Create users: admin/admin user/user
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);
			
			log.info("fetch all devices");
			for (Device device : repository.findAll()) {
				log.info(device.toString());
			}

		};
	}
}
