package com.privalia.albert.challange.data.store.movie;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.entity.PaginatedEntity;
import com.privalia.albert.challange.data.store.datasource.DataSource;


import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public interface MovieDataStore extends DataSource {
    Observable<PaginatedEntity<MovieEntity>> get(String orderBy, boolean ascendant, int page);

    Observable<PaginatedEntity<MovieEntity>> search(String query, int page);
}
