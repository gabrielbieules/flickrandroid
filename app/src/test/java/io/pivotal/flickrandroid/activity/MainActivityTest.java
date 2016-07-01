package io.pivotal.flickrandroid.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import io.pivotal.flickrandroid.BuildConfig;
import io.pivotal.flickrandroid.FlickrService;
import io.pivotal.flickrandroid.R;
import io.pivotal.flickrandroid.TestFlickrApplication;
import io.pivotal.flickrandroid.TestFlickrComponent;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class MainActivityTest {

    private MainActivity subject;

    @Inject
    FlickrService flickrService;

    @Before
    public void setup() {
        subject = Robolectric.setupActivity(MainActivity.class);
        ((TestFlickrComponent) TestFlickrApplication.getFlickrApplication().getFlickrComponent()).inject(this);
    }

    @Test
    public void activity_hasTitle() {
        assertThat(subject.getTitle()).isEqualTo("FlickrAndroid");
    }

    @Test
    public void activity_hasTitleInActivity() {
        TextView view = (TextView) subject.findViewById(R.id.title);
        assertThat(view).hasText("Flickr for Android");
    }

    @Test
    public void activity_hasListOfImagesWithDescriptions() {
        RecyclerView recyclerView = subject.getItemListRecyclerView();
        assertThat(recyclerView.getLayoutManager()).isOfAnyClassIn(GridLayoutManager.class);
        assertThat(((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount()).isEqualTo(3);
        assertThat(recyclerView.getAdapter().getItemCount()).isEqualTo(5);
    }
}