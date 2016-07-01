package io.pivotal.flickrandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrItemListAdapter extends RecyclerView.Adapter {

    public static class FlickrItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image)
        ImageView imageView;

        @Bind(R.id.description)
        TextView description;

        public FlickrItemViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            ButterKnife.bind(this, linearLayout);
        }

        public TextView getDescription() {
            return description;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    private Picasso picasso;
    private FlickrService flickrService;

    public void setItems(List<FlickrFeedResponse.FlickrFeedResponseItem> items) {
        this.items = items;
    }

    private List<FlickrFeedResponse.FlickrFeedResponseItem> items = Collections.EMPTY_LIST;

    public FlickrItemListAdapter(Picasso picasso, FlickrService flickrService) {
        this.picasso = picasso;
        this.flickrService = flickrService;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LinearLayout view = (LinearLayout) View.inflate(parent.getContext(), R.layout.flickr_item, null);
        return new FlickrItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FlickrItemViewHolder flickrItemViewHolder = (FlickrItemViewHolder) holder;
        flickrItemViewHolder.getDescription().setText("Flickr");
        flickrItemViewHolder.getDescription().setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        picasso
                .load(items.get(position).getMedia().getM())
                .into(flickrItemViewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
