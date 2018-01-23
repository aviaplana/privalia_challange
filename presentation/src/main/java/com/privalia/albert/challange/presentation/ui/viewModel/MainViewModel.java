package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.domain.interactor.movie.GetMovies;
import com.privalia.albert.challange.domain.interactor.movie.SearchMovies;
import com.privalia.albert.challange.presentation.base.BaseViewModel;
import com.privalia.albert.challange.presentation.mapper.MoviePaginatedDtoModelMapper;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.privalia.albert.challange.presentation.ui.navigator.MainNavigator;

import javax.inject.Inject;

/**
 * Created by albert on 26/12/17.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final ObservableArrayList<MovieModel> movieObservableArrayList = new ObservableArrayList<>();
    private final ObservableField<String> appVersion = new ObservableField<>();

    private GetMovies getMovies;
    private SearchMovies searchMovies;
    private MoviePaginatedDtoModelMapper mapper;

    @Inject
    public MainViewModel(GetMovies getMovies, SearchMovies searchMovies,
                         MoviePaginatedDtoModelMapper mapper) {
        super();
        this.getMovies = getMovies;
        this.searchMovies = searchMovies;
        this.mapper = mapper;
        fetchMovies();
    }

    private void fetchMovies() {
        this.getMovies.execute(GetMovies.Params.listParams("original_title", true, 1))
                .map(listMovies -> this.mapper.map2(listMovies))
                .subscribe(paginatedMovies -> {
                    this.movieObservableArrayList.addAll(paginatedMovies.getResults());
                });
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableArrayList<MovieModel> getMovieObservableArrayList() {
        return this.movieObservableArrayList;
    }

}
