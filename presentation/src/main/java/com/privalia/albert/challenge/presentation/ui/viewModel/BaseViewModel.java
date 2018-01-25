package com.privalia.albert.challenge.presentation.ui.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by albert on 25/12/17.
 */

public abstract class BaseViewModel<NAVIGATOR> extends ViewModel {

    private NAVIGATOR navigator;
    private final ObservableBoolean isLoading = new ObservableBoolean(false);
    private CompositeDisposable compositeDisposable;

    public BaseViewModel() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public void setNavigator(NAVIGATOR navigator) {
        this.navigator = navigator;
    }

    public NAVIGATOR getNavigator() {
        return navigator;
    }

    public CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return this.isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        this.compositeDisposable.dispose();
        super.onCleared();
    }
}
