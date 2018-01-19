package com.privalia.albert.challange.data.store.movie;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.store.datasource.Cache;

import java.util.List;

/**
 * Created by albert on 19/1/18.
 */

public interface MovieCacheDataStore extends MovieDataStore, Cache {
    void put(List<MovieEntity> cities);
    void delete();
}
