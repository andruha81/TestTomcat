package com.academy.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionCounter implements HttpSessionListener {

    private AtomicInteger counter = new AtomicInteger(0);
    private final static Logger logger = LogManager.getLogger(SessionCounter.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter.incrementAndGet();
        logger.info(String.format("Number of sessions %s", counter));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        counter.decrementAndGet();
        logger.info(String.format("Number of sessions %s", counter));
    }
}
