package com.sab.videocall;

import com.sab.videocall.user.UserService;
import com.sab.videocall.user.user;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
		UserService service
	){
		return args -> {
			service.register(user.builder()
							.username("Sabrine")
							.email("sabrine@gmail.com")
							.password("sabrine")
					.build());

			service.register(user.builder()
					.username("Selim")
					.email("selim@gmail.com")
					.password("slouma")
					.build());

			service.register(user.builder()
					.username("SelimSabrine")
					.email("slouma@mail.com")
					.password("sab")
					.build());
		};
	}

}
