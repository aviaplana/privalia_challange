package com.privalia.albert.challange.domain.interactor.movie;

import com.privalia.albert.challange.domain.interactor.BaseUseCaseTest;
import com.privalia.albert.challange.domain.repository.MovieRepository;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by albert on 18/1/18.
 */

public class GetMoviesTest extends BaseUseCaseTest<GetMovies, MovieRepository> {
    @Override
    protected GetMovies createUseCase() {
        return new GetMovies(mockRepository, mockThreadScheduler, mockPostExecutionScheduler);
    }

    @Override
    protected MovieRepository createRepository() {
        return mock(MovieRepository.class);
    }

    @Test
    @Override
    public void testBuildUseCaseObservable() {
        testBuildUseCaseObservable(null, () -> verify(mockRepository).getMovies());
    }
}
