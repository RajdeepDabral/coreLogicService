package dabral.rajdeep.CoreLogicService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoreLogicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreLogicServiceApplication.class, args);
	}

//	@Bean
//	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
