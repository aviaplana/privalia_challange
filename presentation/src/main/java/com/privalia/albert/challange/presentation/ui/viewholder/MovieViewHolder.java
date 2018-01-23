package com.privalia.albert.challange.presentation.ui.viewholder;

import com.privalia.albert.challange.presentation.databinding.ItemMovieViewBinding;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.privalia.albert.challange.presentation.ui.viewModel.MovieItemViewModel;

/**
 * Created by albert on 22/1/18.
 */
public class MovieViewHolder extends BaseViewHolder<MovieModel> {

    private ItemMovieViewBinding binding;


    public MovieViewHolder(ItemMovieViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void onBind(MovieModel movie) {

        MovieItemViewModel movieItemViewModel = new MovieItemViewModel(movie);

        binding.setViewModel(movieItemViewModel);

        // Immediate Binding
        // When a variable or observable changes, the binding will be scheduled to change before
        // the next frame. There are times, however, when binding must be executed immediately.
        // To force execution, use the executePendingBindings() method.
        binding.executePendingBindings();

    }
}