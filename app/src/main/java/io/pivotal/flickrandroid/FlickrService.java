package io.pivotal.flickrandroid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlickrService {
  @GET("/services/feeds/photos_public.gne?format=json&nojsoncallback=true")
  Call<FlickrFeedResponse> feed();
}