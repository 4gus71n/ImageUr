package com.tradehelm.imageur.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tradehelm.imageur.ImageUrApp;
import com.tradehelm.imageur.R;
import com.tradehelm.imageur.utils.DefaultLocationListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //region Variables declaration
    @BindView(R.id.main_activity_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_activity_container)
    View mContainer;
    @Inject
    LocationManager locationManager;
    private DefaultLocationListener mLocationListener = new DefaultLocationListener() {
        @Override @SuppressWarnings("MissingPermission")
        public void onLocationChanged(Location location) {
            Snackbar.make(mContainer, location.getLatitude() + " " + location.getLongitude(), Snackbar.LENGTH_LONG).show();
            locationManager.removeUpdates(mLocationListener);
        }
    };
    //endregion

    //region Activity lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageUrApp.getObjectGraph().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        setSupportActionBar(mToolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container,
                    MainFragment.newInstance(), MainFragment.TAG).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_location:
                showLocationToast();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showLocationToast();
                } else {
                    Snackbar.make(mContainer, R.string.enable_gps_permissions, Snackbar.LENGTH_LONG).show();
                }
                return;
            }
        }
    }


    //endregion

    private void showLocationToast() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }
        // get the last know location from your location manager.
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                showEnableGPSDialog();
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mLocationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
        } else{
            Snackbar.make(mContainer, location.getLatitude() + " " + location.getLongitude(), Snackbar.LENGTH_LONG).show();
        }
    }

    private void showEnableGPSDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.gps_disabled_message)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
