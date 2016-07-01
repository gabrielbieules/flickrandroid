package io.pivotal.flickrandroid;

import javax.inject.Singleton;

import dagger.Component;
import io.pivotal.flickrandroid.activity.FlickrAdapterTest;
import io.pivotal.flickrandroid.activity.MainActivityTest;

@Singleton
@Component(modules = TestFlickrModule.class)
public interface TestFlickrComponent extends FlickrComponent {
    void inject(MainActivityTest mainActivityTest);

    void inject(FlickrAdapterTest mainActivityTest);
}
