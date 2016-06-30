package io.pivotal.flickrandroid;

import android.app.Application;

public class FlickrApplication extends Application {

    static FlickrComponent flickrComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        flickrComponent = DaggerFlickrComponent.builder().flickrModule(new FlickrModule(this)).build();
    }

    public static FlickrComponent getFlickrComponent() {
        return flickrComponent;
    }
}
