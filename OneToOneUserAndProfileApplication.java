package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Repository.ProfileRepository;
import com.example.Repository.UserRepository;
import com.example.model.Profile;
import com.example.model.User;

@SpringBootApplication
public class OneToOneUserAndProfileApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUserAndProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user=new User("Abhishek Wagh");
		Profile profile=new Profile("Job Profile");
		
		user.setProfile(profile);
		userRepository.save(user);
		
		
	}

}
