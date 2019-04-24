package hr.test.concurrency.testconcurrency.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	public String testMethod() throws InterruptedException {

		System.out.println("Putting thread with name: " + Thread.currentThread().getName() +
				" to sleep for 1.5 seconds to simulate work being done");
		
		//Simulate work being done
		Thread.sleep(1500L);
		
		return "Done";
	}
}
