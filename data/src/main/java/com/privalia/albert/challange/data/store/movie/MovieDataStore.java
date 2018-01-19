package com.privalia.albert.challange.data.store.movie;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.store.datasource.DataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public interface MovieDataStore extends DataSource {
    Observable<List<MovieEntity>> get(String orderBy, int page);
}
