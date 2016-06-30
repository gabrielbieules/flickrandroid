package io.pivotal.flickrandroid;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class TestFlickrModule {

    @Provides
    public Picasso picasso() {
        Picasso picasso = mock(Picasso.class);
        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(anyString())).thenReturn(requestCreator);
        return picasso;
    }
}
