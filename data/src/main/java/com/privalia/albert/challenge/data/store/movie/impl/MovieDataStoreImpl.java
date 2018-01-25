package com.privalia.albert.challenge.data.store.movie.impl;

import com.privalia.albert.challenge.data.entity.MovieEntity;
import com.privalia.albert.challenge.data.entity.PaginatedEntity;
import com.privalia.albert.challenge.data.net.Api;
import com.privalia.albert.challenge.data.store.movie.MovieDataStore;

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
    public Observable<PaginatedEntity<MovieEntity>> get(String orderBy, boolean ascendant,
                                                        int page) {

        String orderByQuery = orderBy + "." + (ascendant ? "asc" : "desc");

        return this.api.movies(orderByQuery, page);
    }

    @Override
    public Observable<PaginatedEntity<MovieEntity>> search(String query, int page) {

        return this.api.searchMovies(query, page);
    }
}
