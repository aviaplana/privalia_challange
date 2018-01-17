package com.privalia.albert.challange.domain.interactor;

import com.privalia.albert.challange.domain.repository.Repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Scheduler;
import io.reactivex.functions.Action;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by albert on 7/1/18.
 */

@RunWith(MockitoJUnitRunner.class)
public abstract class BaseUseCaseTest<USE_CASE extends UseCase, REPOSITORY extends Repository> {

    protected USE_CASE useCase;

    protected REPOSITORY mockRepository;

    @Mock
    protected Scheduler mockThreadScheduler;

    @Mock
    protected Scheduler mockPostExecutionScheduler;

    @Before
    public void setUp() {
        mockRepository = createRepository();
        useCase = createUseCase();
    }

    protected abstract USE_CASE createUseCase();

    protected abstract REPOSITORY createRepository();

    public abstract void testBuildUseCaseObservable();

    protected void testBuildUseCaseObservable(Object requestData, Action action) {
        useCase.buildObservable();

        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        verifyNoMoreInteractions(mockRepository);
        verifyZeroInteractions(mockThreadScheduler);
        verifyZeroInteractions(mockPostExecutionScheduler);
    }
}
