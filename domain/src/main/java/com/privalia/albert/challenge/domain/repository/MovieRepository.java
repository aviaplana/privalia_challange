package com.privalia.albert.challenge.domain.repository;

import com.privalia.albert.challenge.domain.dto.MovieDto;
import com.privalia.albert.challenge.domain.dto.PaginatedDto;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by albert on 18/1/18.
 */

public interface MovieRepository extends Repository {

    Observable<PaginatedDto<MovieDto>> getMovies(String orderBy, boolean ascendant, int page);

    Observable<PaginatedDto<MovieDto>> searchMovies(String query, int page);
}
