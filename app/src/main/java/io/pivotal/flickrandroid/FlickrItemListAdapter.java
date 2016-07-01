package io.pivotal.flickrandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    public FlickrItemListAdapter(Picasso picasso) {
        this.picasso = picasso;
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
                .load("http://robolectric.org/images/robolectric-stacked-3f7ad42c.png")
                .into(flickrItemViewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
