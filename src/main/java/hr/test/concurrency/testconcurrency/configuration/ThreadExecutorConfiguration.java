package hr.test.concurrency.testconcurrency.configuration;

import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadExecutorConfiguration {

	private int queueCapacity;
	private int threadTimeout;
	private List<Integer> listOfPorts;

	public ThreadExecutorConfiguration(@Value("${document.thread.list-of-ports}") List<Integer> listOfPorts,
			@Value("${document.queue.capacity}") int queueCapacity,
			@Value("${document.thread.timeout}") int threadTimeout) {
		this.listOfPorts = listOfPorts;
		this.queueCapacity = queueCapacity;
		this.threadTimeout = threadTimeout;
	}

	@Bean
	@Qualifier("threadExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(this.listOfPorts.size());
		threadPoolTaskExecutor.setMaxPoolSize(this.listOfPorts.size());
		threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
		threadPoolTaskExecutor.setKeepAliveSeconds(threadTimeout);
		threadPoolTaskExecutor.setThreadFactory(new ThreadFactory() {

			AtomicInteger counter = new AtomicInteger();

			@Override
			public Thread newThread(Runnable r) {

				return new Thread(r, String.format("%d", listOfPorts.get(counter.getAndIncrement())));
			}
		});

		return threadPoolTaskExecutor;
	}
}