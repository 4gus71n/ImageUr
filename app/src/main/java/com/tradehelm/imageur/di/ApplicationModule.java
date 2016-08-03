package com.tradehelm.imageur.di;

import android.content.Context;
import android.location.LocationManager;
import android.view.LayoutInflater;

import com.tradehelm.imageur.service.ImageUrService;
import com.tradehelm.imageur.service.ServiceFactory;
import com.tradehelm.imageur.ui.MainActivity;
import com.tradehelm.imageur.ui.MainFragment;
import com.tradehelm.imageur.ui.adapter.ImageUrAdapter;
import com.tradehelm.imageur.ui.viewholder.ImageUrViewHolder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 *
 * <ul>
 *  <li>
 *      This module provides a {@link Context} to the {@link ImageUrViewHolder} class so we can
 *      use the picasso library.
 *  </li>
 *  <li>
 *      This module provides a {@link LayoutInflater} to the {@link ImageUrAdapter} class so we can
 *      inflate the view for the {@link ImageUrViewHolder}.
 *  </li>
 *  <li>
 *      This module provides a {@link ImageUrService} to be use in any Fragment or Activity.
 *      Actually, this should be in a separated module called "ServiceModule" but since this's
 *      a small App, I'll leave it here.
 *  </li>
 * </ul>
 *
 */
@Module(injects = {MainActivity.class, MainFragment.class, ImageUrAdapter.class, ImageUrViewHolder.class})
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    LayoutInflater provideInflater() {
        return LayoutInflater.from(mContext);
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    ImageUrService provideImageUrService() {
        return ServiceFactory.createRetrofitService(ImageUrService.class, ImageUrService.SERVICE_ENDPOINT);
    }

    @Provides
    LocationManager provideLocationManager() {
        return (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    }
}
