package net.donnert.spring.boot;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class Timer {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private AtomicInteger loopCounter = new AtomicInteger();
	
	@Autowired
	private StopWatch watch;
	
	@Autowired
	private TestMapper testMapper;
	
	@Value("${spring.task.name}")
	private String taskNamePrefix;
	
	@Value("${spring.timerName}")
	private String timerName;
	
	@PostConstruct
	public void init() {
		logger.info("{} init", timerName);
		watch.start();
	}

	@Scheduled(fixedRateString = "5", initialDelay = 3000)
	
	11111
	222222
	3333
	334444

	public void tick() throws InterruptedException{
		watch.stop();
		logger.info(testMapper.getValueFromDatabase());
		String taskName = taskNamePrefix + "-" + String.valueOf(loopCounter.getAndIncrement());
		watch.start(taskName);
	}

	@Bean
	public StopWatch watch() {
		return new StopWatch();
	}
}
