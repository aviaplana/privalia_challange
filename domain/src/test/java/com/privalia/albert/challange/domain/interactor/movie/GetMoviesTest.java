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
        final String testOrder = "testOrder";
        final int testPage = 1;
        final GetMovies.Params testParams = GetMovies.Params.listParams(testOrder, testPage);

        testBuildUseCaseObservable(testParams,
                                    () -> verify(mockRepository).getMovies(testOrder, testPage));
    }
}
