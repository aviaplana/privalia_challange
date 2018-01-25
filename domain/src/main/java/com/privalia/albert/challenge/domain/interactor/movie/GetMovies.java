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
 * Created by albert on 18/1/18.
 */

public class GetMovies extends UseCase<MovieRepository, PaginatedDto<MovieDto>, GetMovies.Params> {

    @Inject
    public GetMovies(MovieRepository movieRepository,
                     @Named("main_thread") Scheduler postExecutionThread,
                     @Named("io_thread") Scheduler executionThread) {
        super(movieRepository, postExecutionThread, executionThread);
    }

    @Override
    protected Observable<PaginatedDto<MovieDto>> buildObservable(Params params) {
        if (params != null) {
            return repository.getMovies(params.orderBy, params.ascendant, params.page);
        } else {
            return Observable.empty();
        }
    }

    public static final class Params {

        private final int page;
        private final String orderBy;
        private final boolean ascendant;

        private Params(String orderBy, boolean ascendant, int page) {
            this.orderBy = orderBy;
            this.page = page;
            this.ascendant = ascendant;
        }

        public static Params listParams(String orderBy, boolean ascendant, int page) {
            return new Params(orderBy, ascendant, page);
        }
    }
}
