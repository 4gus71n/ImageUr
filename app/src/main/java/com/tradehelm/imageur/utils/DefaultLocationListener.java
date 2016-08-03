package com.tradehelm.imageur.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 *
 * Simple utils class that implements all {@link LocationListener} methods, this way
 * we don't have too many empty methods in the {@link com.tradehelm.imageur.ui.MainActivity implementation}
 */
public class DefaultLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
