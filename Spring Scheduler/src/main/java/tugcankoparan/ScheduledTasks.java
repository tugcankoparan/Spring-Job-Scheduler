package hello;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class ScheduledTasks {
	 private static Logger logger  = LoggerFactory.getLogger(ScheduledTasks.class);
     private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 200)
    public void reportCurrentTime() {
    	logger.info("The time is now {}", dateFormat.format(new Date()));
    }
    @Scheduled(fixedDelay = 100)
    public void scheduleTaskWithFixedDelay(){
    	logger.info("Fixed Delay Task :: Execution Time - {}", dateFormat.format(new Date()));
      try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
        	logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }  
    } 
    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}",dateFormat.format(new Date()));
    }
    }

