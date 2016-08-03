package com.tradehelm.imageur.service;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 *
 * URL: https://api.imgur.com/3/gallery/r/funny
 * Headers
 * Key: Authorization
 * Value: Client-ID 1588a32330b9360
 */
import com.tradehelm.imageur.model.ImageUrResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface ImageUrService {
    //NOTE base url must edn in "/"
    String SERVICE_ENDPOINT = "https://api.imgur.com/";

    @GET("3/gallery/r/funny/")
    Observable<ImageUrResponse> getImages();
}
