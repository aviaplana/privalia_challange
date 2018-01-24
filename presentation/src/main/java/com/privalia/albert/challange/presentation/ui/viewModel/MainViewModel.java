package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
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
    private final ObservableBoolean sortDir = new ObservableBoolean();

    private GetMovies getMovies;
    private SearchMovies searchMovies;
    private MoviePaginatedDtoModelMapper mapper;

    private int currentPage = 0;
    private int totalPages = -1;

    @Inject
    public MainViewModel(GetMovies getMovies, SearchMovies searchMovies,
                         MoviePaginatedDtoModelMapper mapper) {
        super();
        this.getMovies = getMovies;
        this.searchMovies = searchMovies;
        this.mapper = mapper;
    }

    public void fetchMovies(String order) {
        if (totalPages == -1 || currentPage < totalPages) {
            this.setIsLoading(true);
            this.getMovies.execute(GetMovies.Params.listParams(order, sortDir.get(), currentPage + 1))
                    .map(listMovies -> this.mapper.map2(listMovies))
                    .doFinally(() -> this.setIsLoading(false))
                    .subscribe(paginatedMovies -> {
                        this.currentPage = paginatedMovies.getPage();
                        this.totalPages = paginatedMovies.getTotalPages();
                        this.movieObservableArrayList.addAll(paginatedMovies.getResults());
                    });
        }
    }

    public void clearMovies() {
        this.movieObservableArrayList.clear();
        this.currentPage = 0;
        this.totalPages = -1;
    }

    public void toggleSortDir() {
        sortDir.set(!sortDir.get());
        clearMovies();
    }

    public ObservableBoolean getSortDir() {
        return sortDir;
    }

    public ObservableArrayList<MovieModel> getMovieObservableArrayList() {
        return this.movieObservableArrayList;
    }


}
