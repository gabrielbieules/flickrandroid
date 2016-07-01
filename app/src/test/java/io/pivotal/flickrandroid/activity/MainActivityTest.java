package io.pivotal.flickrandroid.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.pivotal.flickrandroid.BuildConfig;
import io.pivotal.flickrandroid.R;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class MainActivityTest {

    private MainActivity subject;

    @Before
    public void setup() {
        subject = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void activity_hasTitle() {
        assertThat(subject.getTitle()).isEqualTo("FlickrAndroid");
    }

    @Test
    public void activity_hasImageOfCat() {
        View view = subject.findViewById(R.id.cat);
        assertThat(view).isEqualTo(subject.cat);
    }

    @Test
    public void activity_hasSubTitle() {
        TextView view = (TextView) subject.findViewById(R.id.subTitle);
        assertThat(view.getText()).isEqualTo("Flickr for Android");
    }

    @Test
    public void activity_hasListofImages() {
        RecyclerView view = (RecyclerView) subject.findViewById(R.id.imagesList) ;
        assertThat(view.getAdapter()).isNotNull();
    }

}