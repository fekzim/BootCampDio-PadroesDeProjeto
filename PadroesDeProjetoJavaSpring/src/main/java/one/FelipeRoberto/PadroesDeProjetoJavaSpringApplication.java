package one.FelipeRoberto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesDeProjetoJavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesDeProjetoJavaSpringApplication.class, args);
	}

}
