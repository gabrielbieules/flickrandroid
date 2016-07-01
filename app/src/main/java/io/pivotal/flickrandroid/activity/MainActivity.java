package io.pivotal.flickrandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.pivotal.flickrandroid.FlickrApplication;
import io.pivotal.flickrandroid.R;
import io.pivotal.flickrandroid.model.FlickrImageDetails;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.cat)
    ImageView cat;

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlickrApplication.getFlickrApplication().getFlickrComponent().inject(this);
        View view = View.inflate(this, R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.bind(this);
        picasso.load("https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg").into(cat);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.imagesList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<FlickrImageDetails> data = Arrays.asList(
                new FlickrImageDetails("Flickr1", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr2", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr3", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr3", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr3", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr3", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"),
                new FlickrImageDetails("Flickr4", "https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"));


        RecyclerView.Adapter mAdapter = new FlickrAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
