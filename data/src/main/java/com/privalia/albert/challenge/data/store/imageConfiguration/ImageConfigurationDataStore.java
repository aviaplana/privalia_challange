package com.privalia.albert.challenge.data.store.imageConfiguration;

import com.privalia.albert.challenge.data.entity.ImageConfigurationEntity;
import com.privalia.albert.challenge.data.store.datasource.DataSource;

import io.reactivex.Observable;

/**
 * Created by albert on 23/1/18.
 */

public interface ImageConfigurationDataStore extends DataSource {
    Observable<ImageConfigurationEntity> get();
}
