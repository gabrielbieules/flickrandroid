package io.pivotal.flickrandroid;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
class FlickrModule {

    private final Context context;

    public FlickrModule(Context context) {
        this.context = context;
    }

    @Provides
    public Picasso picasso() {
        return Picasso.with(context);
    }
}
