package com.tradehelm.imageur.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tradehelm.imageur.ImageUrApp;
import com.tradehelm.imageur.R;
import com.tradehelm.imageur.model.ImageUr;
import com.tradehelm.imageur.ui.viewholder.ImageUrViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class ImageUrAdapter extends RecyclerView.Adapter<ImageUrViewHolder> {
    //region Variables declaration
    @Inject
    LayoutInflater mInflater;
    //NOTE: I always work directly with ArrayList because using List ends up being a waste of time.
    private ArrayList<ImageUr> mImages = new ArrayList<>();
    //endregion

    //region Constructors declaration
    public ImageUrAdapter() {
        ImageUrApp.getObjectGraph().inject(this);
    }
    //endregion

    //region RecyclerView.Adapter<ImageUrViewHolder> override methods
    @Override
    public ImageUrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageUrViewHolder(mInflater.inflate(R.layout.view_holder_imageur, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageUrViewHolder holder, int position) {
        holder.loadImageUr(mImages.get(position));
    }

    @Override
    public void onViewRecycled(ImageUrViewHolder holder) {
        super.onViewRecycled(holder);
        holder.cancelLoading();
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }
    //endregion

    //region Public methods
    public void setImages(List<ImageUr> images) {
        mImages.clear();
        mImages.addAll(images);
        notifyDataSetChanged();
    }
    //endregion
}
