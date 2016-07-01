package io.pivotal.flickrandroid;

import android.graphics.PixelFormat;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class FlickrItemListAdapterTest {

    @Test
    public void createAndBind() throws Exception {
        Picasso picasso = mock(Picasso.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(stringCaptor.capture())).thenReturn(requestCreator);

        FlickrItemListAdapter adapter = new FlickrItemListAdapter(picasso);

        FlickrItemListAdapter.FlickrItemViewHolder viewHolder = (FlickrItemListAdapter.FlickrItemViewHolder) adapter.onCreateViewHolder(new LinearLayout(RuntimeEnvironment.application), 0);
        adapter.onBindViewHolder(viewHolder, 0);

        assertThat(viewHolder.getDescription()).hasText("Flickr");
        verify(requestCreator).into(viewHolder.getImageView());
    }
}