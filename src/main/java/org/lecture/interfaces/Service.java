package org.lecture.interfaces;

public interface Service {
    /**
     * Starts up the service main loop.
     */
    void run();

    /**
     * Shuts down the service main loop.
     */
    void shutdown();
}
