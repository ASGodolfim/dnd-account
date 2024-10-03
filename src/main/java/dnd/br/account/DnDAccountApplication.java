package dnd.br.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dnd.br.account")
public class DnDAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDAccountApplication.class, args);
	}

}
