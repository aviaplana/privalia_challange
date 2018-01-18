package com.privalia.albert.challange.domain.repository;

import com.privalia.albert.challange.domain.dto.MovieDto;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by albert on 18/1/18.
 */

public interface MovieRepository extends Repository {

    /** Get an {@link Observable} which will emit a list of {@link MovieDto} movies. */
    Observable<List<MovieDto>> getMovies();
}
