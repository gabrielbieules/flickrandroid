package io.pivotal.flickrandroid.activity;

import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import javax.inject.Inject;

import io.pivotal.flickrandroid.BuildConfig;
import io.pivotal.flickrandroid.FlickrApplication;
import io.pivotal.flickrandroid.TestFlickrComponent;
import io.pivotal.flickrandroid.model.FlickrImageDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class FlickrAdapterTest {

    private LinearLayout parent;
    private FlickrAdapter flickrAdapter;

    @Inject
    Picasso picasso;

    @Before
    public void setup() {
        parent = new LinearLayout(RuntimeEnvironment.application);
        ((TestFlickrComponent) FlickrApplication.getFlickrApplication().getFlickrComponent()).inject(this);
        flickrAdapter = new FlickrAdapter(Arrays.asList(new FlickrImageDetails("1", "url1"), new FlickrImageDetails("2", "url2"), new FlickrImageDetails("3", "url3"), new FlickrImageDetails("4", "url4")));
    }

    @Test
    public void testOnCreateViewHolder() throws Exception {
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(urlCaptor.capture())).thenReturn(requestCreator);

        FlickrAdapter.ViewHolder viewHolder = flickrAdapter.onCreateViewHolder(parent, 0);
        flickrAdapter.onBindViewHolder(viewHolder, 2);

        assertThat(viewHolder.description.getText()).isEqualTo("3");
        assertThat(urlCaptor.getValue()).isEqualTo("url3");
        verify(picasso).load("url3");
        verify(requestCreator).into(viewHolder.imageView);
    }

    @Test
    public void testGetItemCount() throws Exception {
        assertThat(flickrAdapter.getItemCount()).isEqualTo(4);
    }
}