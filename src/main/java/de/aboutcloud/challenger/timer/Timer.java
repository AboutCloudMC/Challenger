package de.aboutcloud.challenger.timer;

public class Timer {

    private String id;

    private long startTime;
    private long endTime;

    private boolean running;

    public Timer(String id) {
        this.id = id;
        this.running = false;
    }

    public Timer(long current) {
        this.endTime = current;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.running = false;
    }

    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = System.currentTimeMillis() - startTime;
        } else {
            elapsed = endTime - startTime;
        }
        return elapsed;
    }

    public static String format(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
