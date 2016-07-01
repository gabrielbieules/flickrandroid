package io.pivotal.flickrandroid.model;

public class FlickrImageDetails {

    final String description;
    final String url;

    public FlickrImageDetails(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
