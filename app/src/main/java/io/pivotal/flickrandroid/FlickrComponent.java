package io.pivotal.flickrandroid;

import javax.inject.Singleton;

import dagger.Component;
import io.pivotal.flickrandroid.activity.MainActivity;

@Singleton
@Component(modules = FlickrModule.class)
public interface FlickrComponent {
    void inject(MainActivity mainActivity);
}
