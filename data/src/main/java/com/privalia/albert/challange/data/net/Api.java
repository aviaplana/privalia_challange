package com.privalia.albert.challange.data.net;

import com.privalia.albert.challange.data.entity.MovieEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by albert on 4/05/17.
 */

public interface Api {
    @GET("4/list/{listId}")
    Observable<List<MovieEntity>> movies(@Path("listId") int listId,
                                         @Query("order_by") String orderBy,
                                         @Query("page") int page);
}
