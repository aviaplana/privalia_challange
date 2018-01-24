package com.privalia.albert.challange.presentation.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.privalia.albert.challange.domain.interactor.movie.GetMovies;
import com.privalia.albert.challange.domain.interactor.movie.SearchMovies;
import com.privalia.albert.challange.presentation.ui.viewModel.ViewModelProviderFactory;
import com.privalia.albert.challange.presentation.mapper.MoviePaginatedDtoModelMapper;
import com.privalia.albert.challange.presentation.ui.adapter.MovieAdapter;
import com.privalia.albert.challange.presentation.ui.viewModel.MainViewModel;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 26/12/17.
 */

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(GetMovies getMovies, SearchMovies searchMovies,
                                       MoviePaginatedDtoModelMapper mapper) {
        return new MainViewModel(getMovies, searchMovies, mapper);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    MovieAdapter provideMovieAdapter() {
        return new MovieAdapter(new ArrayList<>());
    }

}
