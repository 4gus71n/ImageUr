package com.tradehelm.imageur;

import android.app.Application;

import com.tradehelm.imageur.di.ApplicationModule;

import dagger.ObjectGraph;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 *
 * Docs:
 * https://www.reddit.com/r/androiddev/comments/2ccetz/retrofit_volley_ion_comparison_between_the_3/
 * https://github.com/ruler88/GithubDemo
 * https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
 */
public class ImageUrApp extends Application {

    private static ImageUrApp instance;

    protected ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new ApplicationModule(getBaseContext()));
        instance = this;
    }

    public static ObjectGraph getObjectGraph() {
        if (instance == null || instance.objectGraph == null) {
            throw new IllegalStateException("Cannot access the app graph before the application has been created");
        }
        return instance.objectGraph;
    }
}
