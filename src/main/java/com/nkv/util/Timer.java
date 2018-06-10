package com.nkv.util;

import sun.jvm.hotspot.utilities.Assert;

public class Timer {

    private long startTimeInMilis = -1;
    private long stopTimeInMilis = -1;

    public void start() {
        this.startTimeInMilis = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTimeInMilis = System.currentTimeMillis();
    }

    public long getDuration() {
        Assert.that(this.startTimeInMilis >= 0, "Time has not started");
        if (this.stopTimeInMilis < 0) {
            System.out.println("Timer was not stopped. Stopping now...");
            this.stop();
        }
        return this.stopTimeInMilis - this.startTimeInMilis;
    }

}
