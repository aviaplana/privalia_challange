package com.privalia.albert.challange.data.store.movie.impl;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.net.Api;
import com.privalia.albert.challange.data.store.movie.MovieDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public class MovieDataStoreImpl implements MovieDataStore {

    private final Api api;

    @Inject
    public MovieDataStoreImpl(Api api) {
        this.api = api;
    }

    @Override
    public Observable<List<MovieEntity>> get(String orderBy, int page) {
        // In the api documentation ListID is optional, but if it's not defined, you get an error as response
        // TODO: Re-check if listId is mandatory
        return this.api.movies(1, orderBy, page);
    }
}
