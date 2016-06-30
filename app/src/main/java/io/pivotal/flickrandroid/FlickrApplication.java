package io.pivotal.flickrandroid;

import android.app.Application;

public class FlickrApplication extends Application {

    protected FlickrComponent flickrComponent;

    static FlickrApplication flickrApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
        flickrApplication = this;
    }

    public static FlickrApplication getFlickrApplication() {
        return flickrApplication;
    }

    protected void buildComponent() {
        flickrComponent = DaggerFlickrComponent.builder().flickrModule(new FlickrModule(this)).build();
    }

    public FlickrComponent getFlickrComponent() {
        return flickrComponent;
    }
}
