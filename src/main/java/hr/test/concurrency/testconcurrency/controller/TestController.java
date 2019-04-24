package hr.test.concurrency.testconcurrency.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.test.concurrency.testconcurrency.service.AsyncService;


@RestController
@RequestMapping(value = "test")
public class TestController {
	
	private AsyncService asyncService;
	
	public TestController(AsyncService asyncService) {
		this.asyncService = asyncService;
	}

	@GetMapping(value = "/works")
	public String testIfAppWorks() {
		
		return "sanity check";
	}
	
	@GetMapping(value = "/concurrency")
	public String testPost() throws InterruptedException, ExecutionException  {
		
		return this.asyncService.asyncCallTestServiceTestMethod().get();
	}
	
}
