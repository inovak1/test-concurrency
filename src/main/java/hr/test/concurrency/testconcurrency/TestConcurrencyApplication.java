package hr.test.concurrency.testconcurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class TestConcurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestConcurrencyApplication.class, args);
	}

}
