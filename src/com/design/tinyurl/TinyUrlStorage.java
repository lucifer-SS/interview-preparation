package com.design.tinyurl;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class TinyUrlStorage {

    public static class TinyUrlItem {
        private String shortUrlId;
        private String originalUrl;
        private Date creationTime;

        public TinyUrlItem(String shortUrlId, String originalUrl) {
            this.shortUrlId = shortUrlId;
            this.originalUrl = originalUrl;
        }

        public String getShortUrlId() {
            return shortUrlId;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public Date getCreationTime() {
            return creationTime;
        }

        private void setCreationTime(Date creationTime) {
            this.creationTime = creationTime;
        }
    }

    private ConcurrentHashMap<String, TinyUrlItem> shortUrlStorage;
    private final String EMPTY_STRING = "";

    public TinyUrlStorage () {
        shortUrlStorage = new ConcurrentHashMap<>();
    }

    public Boolean addItem(TinyUrlItem tinyURLItem) {
        // We can have a Invalid Input Exception defined as well.
        if(!isValid(tinyURLItem)) {
            throw new RuntimeException("Invalid Input Exception");
        }

        TinyUrlItem existingItem = shortUrlStorage.putIfAbsent(tinyURLItem.shortUrlId, tinyURLItem);

        if (existingItem != null) {
            // Log Line for future debugging
            System.out.println("Encountered shortUrl conflict: " + existingItem.getShortUrlId()
                    + "for URL: " + tinyURLItem.getOriginalUrl() + Thread.currentThread().getName());

            return false;
        }

        return true;
    }

    public TinyUrlItem getItem(String shortUrlId) {
        return shortUrlStorage.getOrDefault(shortUrlId, new TinyUrlItem(EMPTY_STRING, EMPTY_STRING));
    }

    private Boolean isValid(TinyUrlItem tinyURLItem) {
        // In actual code you might want to verify the URL format as well for validity.
        if (tinyURLItem.getShortUrlId() == null || tinyURLItem.getShortUrlId().isBlank()
                || tinyURLItem.getOriginalUrl() == null || tinyURLItem.getOriginalUrl().isBlank()) {
            return false;
        }

        return true;
    }

}
