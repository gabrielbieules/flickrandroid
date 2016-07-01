package io.pivotal.flickrandroid;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class FlickrModule {

    private final Context context;

    public FlickrModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Picasso picasso() {
        return Picasso.with(context);
    }
}
