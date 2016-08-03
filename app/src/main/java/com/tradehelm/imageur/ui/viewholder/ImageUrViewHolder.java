package com.tradehelm.imageur.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tradehelm.imageur.ImageUrApp;
import com.tradehelm.imageur.R;
import com.tradehelm.imageur.model.ImageUr;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class ImageUrViewHolder extends RecyclerView.ViewHolder {

    //region Constants declaration
    //It's a waste displaying the images in the list with their real width/height
    //So in order to save a little bit of memory we're gonna shrink them down.
    private static final int SHRINK_FACTOR = 3;
    private static final int MIN_HEIGHT = 50;
    private static final int MIN_WIDTH = 100;
    //endregion

    //region Variables declaration
    @Inject
    Context context;

    /**
     * NOTE: Another coding convention, originally the "m" prefix was use to speed up development
     * and identify all protected variables, same way I use a "v" prefix to identify all View related
     * variables.
     */

    @BindView(R.id.main_fragment_imageview)
    ImageView vImageView;
    @BindView(R.id.main_fragment_title)
    TextView vTitleTextView;
    @BindView(R.id.main_fragment_votes)
    TextView vVotesTextView;
    @BindView(R.id.main_fragment_views)
    TextView vViewsTextView;
    //endregion


    public ImageUrViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        ImageUrApp.getObjectGraph().inject(this);
    }

    public void cancelLoading() {
        Picasso.with(context).cancelRequest(vImageView);
    }

    public void loadImageUr(ImageUr imageUr) {
        int targetWidth = imageUr.getWidth() / SHRINK_FACTOR;
        if (targetWidth <= 0) {
            targetWidth = MIN_WIDTH;
        }
        int targetHeight = imageUr.getHeight() / SHRINK_FACTOR;
        if (targetHeight <= 0) {
            targetHeight = MIN_HEIGHT;
        }
        Picasso.with(context).load(imageUr.getLink())
                .resize(targetWidth, targetHeight)
                .centerCrop()
                .into(vImageView);
        if (TextUtils.isEmpty(imageUr.getTitle())) {
            vTitleTextView.setText(R.string.view_holder_imageur_empty_title);
        } else {
            vTitleTextView.setText(imageUr.getTitle());
        }
        if (imageUr.getVote() == null || imageUr.getVote() <= 0) {
            vVotesTextView.setText(R.string.view_holder_imageur_empty_votes);
        } else {
            vVotesTextView.setText(imageUr.getVote().toString());
        }
        if (imageUr.getViews() == null || imageUr.getViews() <= 0) {
            vViewsTextView.setText(R.string.view_holder_imageur_empty_views);
        } else {
            vViewsTextView.setText(imageUr.getViews().toString());
        }

    }
}
