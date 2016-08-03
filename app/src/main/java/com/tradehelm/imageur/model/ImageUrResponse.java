package com.tradehelm.imageur.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class ImageUrResponse implements Serializable {
    @SerializedName("data")
    private List<ImageUr> data;

    public List<ImageUr> getData() {
        return data;
    }

    public void setData(List<ImageUr> data) {
        this.data = data;
    }

    public List<ImageUr> getImagesList() {
        ArrayList<ImageUr> filteredImages = new ArrayList<>();
        for (ImageUr image : data) {
            //Doing the equals with the literal string first avoids NP exceptions
            if (!image.getNsfw() && "image/jpeg".equals(image.getType())) {
                filteredImages.add(image);
            }
        }
        return filteredImages;
    }
}
