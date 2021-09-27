package org.launchcode.andrewgroupa;

import org.launchcode.andrewgroupa.data.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AndrewGroupAApplication {

  public static void main(String[] args) {
    SpringApplication.run(AndrewGroupAApplication.class, args);
  }

}
