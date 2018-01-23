package com.privalia.albert.challange.data.store.imageConfiguration;

import com.privalia.albert.challange.data.entity.ImageConfigurationEntity;
import com.privalia.albert.challange.data.store.datasource.DataSource;

import io.reactivex.Observable;

/**
 * Created by albert on 23/1/18.
 */

public interface ImageConfigurationDataStore extends DataSource {
    Observable<ImageConfigurationEntity> get();
}
