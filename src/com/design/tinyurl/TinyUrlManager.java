package com.design.tinyurl;

public class TinyUrlManager {
    private TinyUrlStorage storage;

    private final String MY_DOMAIN_URL_PREFIX = "https://www.tinyurl.com/";
    private final String EMPTY_STRING = "";

    public TinyUrlManager() {
        storage = new TinyUrlStorage();
    }

    public String getShortUrl(String originalUrl) {
        String shortUrlId = UniqueIdGenerator.generateRandomString();
        TinyUrlStorage.TinyUrlItem tinyUrlItem = new TinyUrlStorage.TinyUrlItem(shortUrlId, originalUrl);

        Boolean result = false;
        Integer forcedCounter = 0;
        while (!result && forcedCounter < 10) {
            result = storage.addItem(tinyUrlItem);
            forcedCounter++;
        }

        if (!result) {
            // Or throw exception in real world.
            System.out.println("Unable to Create Short URL");
            return EMPTY_STRING;
        }

        // System.out.println("ShortUrl: " + MY_DOMAIN_URL_PREFIX.concat(shortUrlId));

        return MY_DOMAIN_URL_PREFIX.concat(shortUrlId);
    }

    public String getOriginalUrl(String shortUrlId) {
        TinyUrlStorage.TinyUrlItem item = storage.getItem(shortUrlId);
        return item.getOriginalUrl();
    }

    public static void main(String[] args) {
        // Sample usage with multiple threads
        TinyUrlManager tinyUrlManager = new TinyUrlManager();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                Integer counter = 100001;
                tinyUrlManager.getShortUrl("https//www.amazon.com/" + Thread.currentThread().getName() + counter++);
            }
        };
        for (int i = 0; i < 1000; i++) {
            new Thread(task).start();
        }
    }

}
