package com.privalia.albert.challange.presentation.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.privalia.albert.challange.presentation.base.ViewModelProviderFactory;
import com.privalia.albert.challange.presentation.ui.viewModel.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 26/12/17.
 */

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}
