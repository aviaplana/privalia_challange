package com.privalia.albert.challenge.domain.interactor.movie;

import com.privalia.albert.challenge.domain.dto.MovieDto;
import com.privalia.albert.challenge.domain.dto.PaginatedDto;
import com.privalia.albert.challenge.domain.interactor.UseCase;
import com.privalia.albert.challenge.domain.repository.MovieRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by albert on 22/1/18.
 */

public class SearchMovies extends UseCase<MovieRepository, PaginatedDto<MovieDto>, SearchMovies.Params> {

    @Inject
    public SearchMovies(MovieRepository movieRepository,
                     @Named("main_thread") Scheduler postExecutionThread,
                     @Named("io_thread") Scheduler executionThread) {
        super(movieRepository, postExecutionThread, executionThread);
    }

    @Override
    protected Observable<PaginatedDto<MovieDto>> buildObservable(Params params) {
        if (params != null) {
            return repository.searchMovies(params.query, params.page);
        } else {
            return Observable.empty();
        }
    }

    public static final class Params {

        private final int page;
        private final String query;

        private Params(String query, int page) {
            this.query = query;
            this.page = page;
        }

        public static Params listParams(String query, int page) {
            return new Params(query, page);
        }
    }
}
