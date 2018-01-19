package com.privalia.albert.challange.domain.interactor.movie;

import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.domain.interactor.UseCase;
import com.privalia.albert.challange.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by albert on 18/1/18.
 */

public class GetMovies extends UseCase<MovieRepository, List<MovieDto>, GetMovies.Params> {

    public GetMovies(MovieRepository movieRepository,
                     @Named("main_thread") Scheduler postExecutionThread,
                     @Named("io_thread") Scheduler executionThread) {
        super(movieRepository, postExecutionThread, executionThread);
    }

    @Override
    protected Observable<List<MovieDto>> buildObservable(Params params) {
        if (params != null) {
            return mRepository.getMovies(params.orderBy, params.page);
        } else {
            return Observable.empty();
        }
    }

    public static final class Params {
        private final int page;
        private final String orderBy;

        private Params(String orderBy, int page) {
            this.orderBy = orderBy;
            this.page = page;
        }

        public static Params listParams(String orderBy, int page) {
            return new Params(orderBy, page);
        }
    }
}
