package com.tradehelm.imageur.service;


import com.tradehelm.imageur.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */

public class ServiceFactory {

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     * @param clazz Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            /**
             * I've a hard time trying to get working the header, so I added a logger to
             * check out the request response.
             */
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(interceptor);
        }
        //Adding the Authentication header for all the request that we're going to perform
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request().newBuilder().addHeader("Authorization", "Client-ID 1588a32330b9360").build();
                return chain.proceed(request);
            }
        });

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.computation());

        final Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(endPoint)
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T service = retrofit.create(clazz);

        return service;
    }
}
