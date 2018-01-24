package com.privalia.albert.challange.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 */
public abstract class UseCase<REPOSITORY, RESPONSE_DATA, PARAMS> {
    protected final Scheduler observeThread;
    protected final Scheduler subscribeThread;
    protected final REPOSITORY repository;

    public UseCase(REPOSITORY repository, Scheduler postExecutionThread,
                   Scheduler executionThread) {
        this.subscribeThread = executionThread;
        this.observeThread = postExecutionThread;
        this.repository = repository;
    }

    // TODO: Replace with Transformer in order to use with compose
    protected Observable<RESPONSE_DATA> addSchedulers(Observable<RESPONSE_DATA> observable) {
        return observable.observeOn(observeThread)
                .subscribeOn(subscribeThread)
                .unsubscribeOn(subscribeThread);
    }

    protected abstract Observable<RESPONSE_DATA> buildObservable(PARAMS params);

    public Observable<RESPONSE_DATA> execute(PARAMS params) {
        return addSchedulers(buildObservable(params));
    }
}