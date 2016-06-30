package io.pivotal.flickrandroid;

public class TestFlickrApplication extends FlickrApplication {
    @Override
    protected void buildComponent() {
        flickrComponent = DaggerTestFlickrComponent.create();
    }
}