package io.pivotal.flickrandroid;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.Calls;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class TestFlickrModule {

    @Provides
    @Singleton
    public Picasso picasso() {
        Picasso picasso = mock(Picasso.class);
        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(anyString())).thenReturn(requestCreator);
        return picasso;
    }

    @Provides
    @Singleton
    public FlickrService flickrService() {
        FlickrService flickrService = new MockFlickrService();
        return flickrService;
    }

    private class MockFlickrService implements FlickrService {

        @Override
        public Call<FlickrFeedResponse> feed() {
            return Calls.response(feedResponse());
        }

        private Response<FlickrFeedResponse> feedResponse() {
            FlickrFeedResponse flickrFeedResponse = new FlickrFeedResponse();
            List<FlickrFeedResponse.FlickrFeedResponseItem> flickrFeedResponseItems = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                flickrFeedResponseItems.add(new FlickrFeedResponse.FlickrFeedResponseItem());
            }
            flickrFeedResponse.setItems(flickrFeedResponseItems);
            return Response.success(flickrFeedResponse);
        }
    }
}
