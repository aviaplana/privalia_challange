package com.privalia.albert.challenge.presentation.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.privalia.albert.challenge.presentation.BR;
import com.privalia.albert.challenge.presentation.R;
import com.privalia.albert.challenge.presentation.databinding.ActivityMainBinding;
import com.privalia.albert.challenge.presentation.model.MovieModel;
import com.privalia.albert.challenge.presentation.ui.adapter.MovieAdapter;
import com.privalia.albert.challenge.presentation.ui.handler.MainActivityHandler;
import com.privalia.albert.challenge.presentation.ui.navigator.MainNavigator;
import com.privalia.albert.challenge.presentation.ui.viewModel.MainViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Main application screen. This is the app entry point.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
                            implements MainNavigator, HasSupportFragmentInjector,
                                        Spinner.OnItemSelectedListener, MainActivityHandler {

    ViewModelProvider.Factory viewModelFactory;

    private Toolbar toolbar;

    ActivityMainBinding activityMainBinding;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    MovieAdapter movieAdapter;

    @Inject
    public MainActivity() { }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activityMainBinding = getViewDataBinding();
        this.activityMainBinding.setVariable(BR.handlers, this);
        viewModel.setNavigator(this);
        setUp();
        viewModel.fetchMovies(this.activityMainBinding.sortValue.getSelectedItem().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        return true;
    }

    @BindingAdapter({"bind:movie_items"})
    public static void setMovieItems(RecyclerView recyclerView,
                                     ArrayList<MovieModel> movieItems) {
        MovieAdapter adapter = (MovieAdapter) recyclerView.getAdapter();

        if(adapter != null) {
            adapter.clearItems();
            adapter.addItems(movieItems);
        }
    }

    @BindingAdapter({"android:onClick"})
    public static void setOnClick(View view, View.OnClickListener clickListener) {
        view.setOnClickListener(clickListener);
    }


    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .remove(fragment)
                    .commitNow();
        }
    }

    private void setUp() {
        setRecyclerView();

        setSortValueSpinner();

        setSupportActionBar(this.toolbar);;
    }

    private void setSortValueSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sort_values, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        this.activityMainBinding.sortValue.setAdapter(adapter);

        this.activityMainBinding.sortValue.setOnItemSelectedListener(this);
    }

    private void setRecyclerView() {
        this.activityMainBinding.recyclerMovies.setAdapter(this.movieAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.activityMainBinding.recyclerMovies.setLayoutManager(linearLayoutManager);

        this.activityMainBinding.recyclerMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleThreshold = 2;
                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    // End has been reached
                    // Do something
                    if (!viewModel.getIsLoading().get()) {
                        viewModel.fetchMovies(activityMainBinding.sortValue.getSelectedItem().toString());
                    }
                }
            }
        });
    }

    @Override
    public MainViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(MainViewModel.class);
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.viewModel.clearMovies();
        this.viewModel.fetchMovies(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onSortDirClicked(View view) {
        this.viewModel.toggleSortDir();
        this.viewModel.fetchMovies(activityMainBinding.sortValue.getSelectedItem().toString());
    }

    @Override
    public void onTextChanged(Editable s) {
        if (viewModel.hasQuery().get()) {
            this.viewModel.searchMovies();
        } else {
            this.viewModel.fetchMovies(activityMainBinding.sortValue.getSelectedItem().toString());
        }
    }
}
