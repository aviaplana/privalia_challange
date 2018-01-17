package com.privalia.albert.challange.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by albert on 25/12/17.
 */

public abstract class BaseViewModel<NAVIGATOR> extends ViewModel {

    private NAVIGATOR mNavigator;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public void setNavigator(NAVIGATOR navigator) {
        this.mNavigator = navigator;
    }

    public NAVIGATOR getNavigator() {
        return mNavigator;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
