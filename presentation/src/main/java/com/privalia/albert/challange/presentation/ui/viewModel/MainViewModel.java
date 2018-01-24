package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.domain.dto.PaginatedDto;
import com.privalia.albert.challange.domain.interactor.movie.GetMovies;
import com.privalia.albert.challange.domain.interactor.movie.SearchMovies;
import com.privalia.albert.challange.presentation.base.BaseViewModel;
import com.privalia.albert.challange.presentation.mapper.MoviePaginatedDtoModelMapper;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.privalia.albert.challange.presentation.ui.navigator.MainNavigator;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by albert on 26/12/17.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final ObservableArrayList<MovieModel> movieObservableArrayList = new ObservableArrayList<>();
    private final ObservableBoolean sortDir = new ObservableBoolean();
    private final ObservableBoolean hasQuery = new ObservableBoolean();

    private GetMovies getMovies;
    private SearchMovies searchMovies;
    private MoviePaginatedDtoModelMapper mapper;
    private Disposable onGoingRequest;

    private int currentPage = 0;
    private int totalPages = -1;
    private String query;

    @Inject
    public MainViewModel(GetMovies getMovies, SearchMovies searchMovies,
                         MoviePaginatedDtoModelMapper mapper) {
        super();
        this.getMovies = getMovies;
        this.searchMovies = searchMovies;
        this.mapper = mapper;
    }

    public void searchMovies() {

        if (totalPages == -1 || currentPage < totalPages) {
            disposePreviousRequest();
            this.setIsLoading(true);

            mapAndSubscribeMovies(this.searchMovies
                    .execute(SearchMovies.Params.listParams(this.query, currentPage + 1)));
        }

    }

    public void fetchMovies(String order) {
        if (totalPages == -1 || currentPage < totalPages) {
            disposePreviousRequest();
            this.setIsLoading(true);


            mapAndSubscribeMovies(this.getMovies
                                        .execute(GetMovies.Params.listParams(order, sortDir.get(),
                                        currentPage + 1)));
        }
    }

    private void disposePreviousRequest() {
        if(this.onGoingRequest != null && !this.onGoingRequest.isDisposed()) {
            this.onGoingRequest.dispose();
        }
    }

    private void mapAndSubscribeMovies(Observable<PaginatedDto<MovieDto>> observableMovies) {
        this.onGoingRequest = observableMovies.map(listMovies -> this.mapper.map2(listMovies))
            .doFinally(() -> this.setIsLoading(false))
            .subscribe(paginatedMovies -> {
                this.currentPage = paginatedMovies.getPage();
                this.totalPages = paginatedMovies.getTotalPages();
                this.movieObservableArrayList.addAll(paginatedMovies.getResults());
            });
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

    public void setQuery(String query) {
        this.query = query;
        this.hasQuery.set(!query.isEmpty());
        clearMovies();
    }

    public ObservableBoolean hasQuery() {
        return this.hasQuery;
    }

    public String getQuery() {
        return this.query;
    }

    public ObservableArrayList<MovieModel> getMovieObservableArrayList() {
        return this.movieObservableArrayList;
    }


}
