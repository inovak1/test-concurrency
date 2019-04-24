package hr.test.concurrency.testconcurrency.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	private TestService testService;

	public AsyncService(TestService testService) {
		this.testService = testService;
	}

	@Async("threadExecutor")
	public CompletableFuture<String> asyncCallTestServiceTestMethod() throws InterruptedException {

		return CompletableFuture.completedFuture(this.testService.testMethod());
	}

}