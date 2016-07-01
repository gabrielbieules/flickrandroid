package io.pivotal.flickrandroid;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    @Provides
    @Singleton
    public FlickrService flickrService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.flickr.com/").addConverterFactory(GsonConverterFactory.create()).build();
        FlickrService flickrService = retrofit.create(FlickrService.class);
        return flickrService;
    }
}
