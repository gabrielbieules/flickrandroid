package io.pivotal.flickrandroid.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import io.pivotal.flickrandroid.FlickrApplication;
import io.pivotal.flickrandroid.R;
import io.pivotal.flickrandroid.model.FlickrImageDetails;

public class FlickrAdapter extends RecyclerView.Adapter<FlickrAdapter.ViewHolder> {

    @Inject
    Picasso picasso;

    List<FlickrImageDetails> imageDesc;

    public FlickrAdapter(List<FlickrImageDetails> data) {
        this.imageDesc = data;
        FlickrApplication.getFlickrApplication().getFlickrComponent().inject(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flickr_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.description.setText(imageDesc.get(position).getDescription());
        picasso.load(imageDesc.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageDesc.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            description = (TextView) v.findViewById(R.id.desc);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }
}
