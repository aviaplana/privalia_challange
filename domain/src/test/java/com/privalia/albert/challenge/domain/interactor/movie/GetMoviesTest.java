package com.privalia.albert.challenge.domain.interactor.movie;

import com.privalia.albert.challenge.domain.interactor.BaseUseCaseTest;
import com.privalia.albert.challenge.domain.repository.MovieRepository;

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
        final boolean isAsc = true;
        final int testPage = 1;
        final GetMovies.Params testParams = GetMovies.Params.listParams(testOrder, isAsc, testPage);

        testBuildUseCaseObservable(testParams,
                                () -> verify(mockRepository).getMovies(testOrder, isAsc, testPage));
    }
}
