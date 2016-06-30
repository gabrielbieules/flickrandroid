package io.pivotal.flickrandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import io.pivotal.flickrandroid.FlickrApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlickrApplication.getFlickrApplication().getFlickrComponent().inject(this);
        ImageView cat = new ImageView(this);
        picasso.load("https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg").into(cat);
        setContentView(cat);
    }
}
