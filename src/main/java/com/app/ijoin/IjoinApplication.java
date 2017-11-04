package com.app.ijoin;

import com.app.ijoin.dao.PreferencesRepository;
import com.app.ijoin.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan("com.app.ijoin")
@SpringBootApplication
public class IjoinApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
    PreferencesRepository preferencesRepository;
	public static void main(String[] args) {
		SpringApplication.run(IjoinApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		Preferences p1 = new Preferences("Java");
//		Preferences p2 = new Preferences("C++");
//		Preferences p3 = new Preferences("C#");
//		User u1 = new User("Niko1");
//		User u2 = new User("Niko2");
//		User u3 = new User("Niko3");
//
//		userRepository.saveAndFlush(new User("Niko1", new HashSet<Preferences>() {{add(p1); add(p2);}} ));
//		userRepository.saveAndFlush(new User("Niko2", new HashSet<Preferences>() {{add(p2); add(p3);}} ));
//		userRepository.saveAndFlush(new User("Niko3", new HashSet<Preferences>() {{add(p3); add(p1);}} ));
//
//		for(User u : userRepository.findAll()) {
//			System.out.println(u.getUsername());
//			for (Preferences p : u.getPreferences())
//				System.out.println(p.getValue());
//
//		}
//
//		System.out.println("----------------------- JAVA ---------------------------------------");
//
//
//		User u = userRepository.findByUsername("Niko1");
//			System.out.println(u.getUsername());
//				for (Preferences p : u.getPreferences())
//					System.out.println(p.getValue());
//
	}
}
