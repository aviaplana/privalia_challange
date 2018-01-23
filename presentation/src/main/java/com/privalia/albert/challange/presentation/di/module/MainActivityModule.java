package com.privalia.albert.challange.presentation.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.privalia.albert.challange.domain.interactor.movie.GetMovies;
import com.privalia.albert.challange.domain.interactor.movie.SearchMovies;
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
    MainViewModel provideMainViewModel(GetMovies getMovies, SearchMovies searchMovies) {
        return new MainViewModel(getMovies, searchMovies);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}
