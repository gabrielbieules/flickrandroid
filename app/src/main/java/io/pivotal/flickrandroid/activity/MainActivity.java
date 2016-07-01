package io.pivotal.flickrandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.pivotal.flickrandroid.FlickrApplication;
import io.pivotal.flickrandroid.FlickrFeedResponse;
import io.pivotal.flickrandroid.FlickrItemListAdapter;
import io.pivotal.flickrandroid.FlickrService;
import io.pivotal.flickrandroid.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.item_list)
    public RecyclerView itemListRecyclerView;

    public RecyclerView.LayoutManager itemListLayoutManager;

    @Inject
    FlickrService flickrService;

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlickrApplication.getFlickrApplication().getFlickrComponent().inject(this);
        View view = View.inflate(this, R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.bind(this);

        itemListLayoutManager = new GridLayoutManager(this, 3);
        itemListRecyclerView.setLayoutManager(itemListLayoutManager);
        final FlickrItemListAdapter adapter = new FlickrItemListAdapter(picasso, flickrService);
        itemListRecyclerView.setAdapter(adapter);

        flickrService.feed().enqueue(new Callback<FlickrFeedResponse>() {
            @Override
            public void onResponse(Call<FlickrFeedResponse> call, Response<FlickrFeedResponse> response) {
                adapter.setItems(response.body().getItems());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FlickrFeedResponse> call, Throwable t) {
                System.out.println("Something went wrong fetching from flickr: " + t.getLocalizedMessage());
            }
        });
    }

    public RecyclerView getItemListRecyclerView() {
        return itemListRecyclerView;
    }
}
