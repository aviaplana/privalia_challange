package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.ObservableField;

import com.privalia.albert.challange.presentation.model.MovieModel;

/**
 * Created by albert on 23/1/18.
 */

public class MovieItemViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> title;
    public ObservableField<String> year;
    public ObservableField<String> overview;

    public MovieItemViewModel(MovieModel movie) {
        this.imageUrl = new ObservableField<String>(movie.getPosterPath());
        this.title = new ObservableField<String>(movie.getTitle());
        this.year = new ObservableField<String>(movie.getReleaseDate().toString());
        this.overview = new ObservableField<String>(movie.getOverview());
    }
}
