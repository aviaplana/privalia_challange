package com.privalia.albert.challenge.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.privalia.albert.challenge.presentation.databinding.ItemMovieViewBinding;
import com.privalia.albert.challenge.presentation.model.MovieModel;
import com.privalia.albert.challenge.presentation.ui.viewholder.MovieViewHolder;

import java.util.List;

/**
 * Created by albert on 22/1/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<MovieModel> items;

    public MovieAdapter(List<MovieModel> movieResponseList) {
        this.items = movieResponseList;
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        if (!items.isEmpty()) holder.onBind(items.get(position));
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemMovieViewBinding movieViewBinding =
                    ItemMovieViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                                                parent, false);

            return new MovieViewHolder(movieViewBinding);
    }

    @Override
    public int getItemCount() {
        if (items != null && items.size() > 0) {
            return items.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<MovieModel> movieList) {
        items.addAll(movieList);
        this.notifyDataSetChanged();
    }

    public void clearItems() {
        items.clear();
    }

}