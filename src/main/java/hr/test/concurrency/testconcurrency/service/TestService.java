package hr.test.concurrency.testconcurrency.service;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	static AtomicInteger counter = new AtomicInteger(0);
	static Random rand = new Random();
	
	private Semaphore semaphore = new Semaphore(1);
	private int sempahoreCounter = 0;
	
	public String testMethod() throws InterruptedException {

		System.out.println("Putting thread with name: " + Thread.currentThread().getName() +
				" to sleep for 1.5 seconds to simulate work being done");
		
		//Simulate work being done
		Thread.sleep(1500L);
		
		// randomizing a number to simulate chaotic behavior
		int randomNumber = randInt(0, 5);
		
		if(randomNumber == 3) {
			try {
			
			this.semaphore.acquire();
			
			System.out.println("Thread: " + Thread.currentThread().getName() + " got the resource. \n"
					+ "As a proof, increasing the semaphore counter");
			incrementSemaphoreCounter(randInt(0, 10));
			System.out.println("Semaphore counter now at: " + this.sempahoreCounter);
			
			
			Thread.sleep(100L);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.semaphore.release();
		}
		
		System.out.println("Counter is at: " +  counter.getAndIncrement());
		
		
		
		return "Done";
	}
	
	public static int randInt(int min, int max) {

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	synchronized void incrementSemaphoreCounter(int number) {
		this.sempahoreCounter = this.sempahoreCounter + number;
	}
}
