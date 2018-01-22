package com.privalia.albert.challange.data.net;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.entity.PaginatedEntity;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by albert on 4/05/17.
 */

public interface Api {
    @GET("3/discover/movie")
    Observable<PaginatedEntity<MovieEntity>> movies(@Query("order_by") String orderBy,
                                                    @Query("page") int page);

    @GET("3/search/movie")
    Observable<PaginatedEntity<MovieEntity>> searchMovies(@Query("query") String query,
                                                            @Query("page") int page);
}
