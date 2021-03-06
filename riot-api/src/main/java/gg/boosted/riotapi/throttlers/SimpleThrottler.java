package gg.boosted.riotapi.throttlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * A simple, non-threadsafe throttler
 *
 * Created by ilan on 12/10/16.
 */
public class SimpleThrottler implements IThrottler {

    private Logger log = LoggerFactory.getLogger(SimpleThrottler.class) ;

    private long millisBetweenRequests ;

    private long lastTimeCalled = 0;

    public SimpleThrottler(int requestsPer10Seconds, int requestsPer10Minutes) {
        millisBetweenRequests = Double.valueOf(Math.max(10.0/requestsPer10Seconds, 600.0/requestsPer10Minutes) * 1000).longValue();
    }

    /**
     * I could probably make this better....
     */
    @Override
    public void waitFor() {
        while (System.currentTimeMillis() - lastTimeCalled < millisBetweenRequests) {
            try {
                long sleepTime = millisBetweenRequests + lastTimeCalled - System.currentTimeMillis() ;
                log.debug("Can't call API yet, sleeping for {} ms", sleepTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.error("This code shouldn't be reached");
                throw new RuntimeException("This code shouldn't be reached");
            }
        }
        lastTimeCalled = System.currentTimeMillis() ;
    }

    //DO nothing
    @Override
    public void releaseLock(long lastTimeCalled) {

    }
}
