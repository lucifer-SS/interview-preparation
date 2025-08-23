package com.design.tinyurl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueIdGenerator {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    public static String generateThreadRandomString() {
        StringBuilder sb = new StringBuilder(6);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }

        return sb.toString();
    }

    public static String generateRandomString() {
        long timestamp = System.nanoTime();
        long threadId = Thread.currentThread().getId();

        // Mix timestamp and threadId for added uniqueness
        long seed = timestamp ^ threadId;

        Random random = new Random(seed);  // Seeded with entropy

        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample usage with multiple threads
        Runnable task = () -> System.out.println(Thread.currentThread().getName()
                + ": Random - " + generateRandomString() + ": Thread - " + generateThreadRandomString());
        for (int i = 0; i < 100; i++) {
            new Thread(task).start();
        }
    }
}
