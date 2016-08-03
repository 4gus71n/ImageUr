package com.tradehelm.imageur.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tradehelm.imageur.ImageUrApp;
import com.tradehelm.imageur.R;
import com.tradehelm.imageur.model.ImageUrResponse;
import com.tradehelm.imageur.service.ImageUrService;
import com.tradehelm.imageur.ui.adapter.ImageUrAdapter;

import java.util.logging.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class MainFragment extends Fragment {

    //region Constants declaration
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(TAG);
    //endregion

    //region Variables declaration
    @Inject
    ImageUrService imageUrService;
    @BindView(R.id.main_fragment_recyclerview)
    RecyclerView mRecyclerView;
    ImageUrAdapter mAdapter;
    //endregion

    //region Constructors declaration
    public MainFragment() {
        ImageUrApp.getObjectGraph().inject(this);
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }
    //endregion

    //region Fragment's lifecycle

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Load the adapter/recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new ImageUrAdapter();
        mRecyclerView.setAdapter(mAdapter);
        //Make the request to the endpoint
        sendImagesRequest();
    }

    private void sendImagesRequest() {
        imageUrService.getImages()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImageUrResponse>() {
                    @Override
                    public final void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public final void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public final void onNext(ImageUrResponse response) {
                        mAdapter.setImages(response.getImagesList());
                    }
                });

    }

    //endregion
}
