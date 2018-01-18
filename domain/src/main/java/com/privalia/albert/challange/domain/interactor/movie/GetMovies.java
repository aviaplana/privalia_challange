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

public class GetMovies extends UseCase<MovieRepository, List<MovieDto>> {

    public GetMovies(MovieRepository movieRepository,
                     @Named("main_thread") Scheduler postExecutionThread,
                     @Named("io_thread") Scheduler executionThread) {
        super(movieRepository, postExecutionThread, executionThread);
    }

    @Override
    protected Observable<List<MovieDto>> buildObservable() {
        return mRepository.getMovies();
    }
}
