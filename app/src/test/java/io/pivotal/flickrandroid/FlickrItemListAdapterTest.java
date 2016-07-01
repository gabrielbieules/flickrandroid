package io.pivotal.flickrandroid;

import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.pivotal.flickrandroid.activity.MainActivity;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class FlickrItemListAdapterTest {

    @Inject
    FlickrService flickrService;

    @Before
    public void setup() {
        ((TestFlickrComponent) TestFlickrApplication.getFlickrApplication().getFlickrComponent()).inject(this);
    }

    @Test
    public void createAndBind() throws Exception {
        Picasso picasso = mock(Picasso.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(stringCaptor.capture())).thenReturn(requestCreator);

        FlickrItemListAdapter adapter = new FlickrItemListAdapter(picasso, flickrService);
        List<FlickrFeedResponse.FlickrFeedResponseItem> responseItems = new ArrayList<>();
        FlickrFeedResponse.FlickrFeedResponseItem flickrFeedResponseItem = new FlickrFeedResponse.FlickrFeedResponseItem();
        flickrFeedResponseItem.setMedia(new FlickrFeedResponse.FlickrFeedResponseItem.Media("http://example.com/image.png"));
        responseItems.add(flickrFeedResponseItem);
        adapter.setItems(responseItems);

        FlickrItemListAdapter.FlickrItemViewHolder viewHolder = (FlickrItemListAdapter.FlickrItemViewHolder) adapter.onCreateViewHolder(new LinearLayout(RuntimeEnvironment.application), 0);
        adapter.onBindViewHolder(viewHolder, 0);

        assertThat(stringCaptor.getValue()).isEqualTo("http://example.com/image.png");
        assertThat(viewHolder.getDescription()).hasText("Flickr");
        verify(requestCreator).into(viewHolder.getImageView());
    }
}