package cooksys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FridayFunDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridayFunDayApplication.class, args);
	}
	
	@Bean("hello")
	public String helloMethod() {
		return "Hello Michael!";
	}
	
	@Bean
	public String goodbyeMethod() {
		return "Goodbye Michael!";
	}
}