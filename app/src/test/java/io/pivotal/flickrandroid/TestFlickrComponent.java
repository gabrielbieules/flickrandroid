package io.pivotal.flickrandroid;

import dagger.Component;
import io.pivotal.flickrandroid.activity.MainActivityTest;

@Component(modules = TestFlickrModule.class)
public interface TestFlickrComponent extends FlickrComponent {
    void inject(MainActivityTest mainActivityTest);
    void inject(FlickrItemListAdapterTest mainActivityTest);
}
