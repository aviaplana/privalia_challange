package com.privalia.albert.challange.data.store.imageConfiguration.impl;

import com.privalia.albert.challange.data.entity.ImageConfigurationEntity;
import com.privalia.albert.challange.data.net.Api;
import com.privalia.albert.challange.data.store.imageConfiguration.ImageConfigurationDataStore;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by albert on 23/1/18.
 */

public class ImageConfigurationDataStoreImpl implements ImageConfigurationDataStore {
    private final Api api;

    @Inject
    public ImageConfigurationDataStoreImpl(Api api) {
        this.api = api;
    }

    @Override
    public Observable<ImageConfigurationEntity> get() {

        return this.api.configuration()
                        .map(configurationEntity -> configurationEntity.getImages());
    }

}
