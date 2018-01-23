package com.privalia.albert.challange.presentation.ui.activity;

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
import android.view.Menu;

import com.privalia.albert.challange.presentation.BR;
import com.privalia.albert.challange.presentation.R;
import com.privalia.albert.challange.presentation.base.BaseActivity;
import com.privalia.albert.challange.presentation.databinding.ActivityMainBinding;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.privalia.albert.challange.presentation.ui.adapter.MovieAdapter;
import com.privalia.albert.challange.presentation.ui.navigator.MainNavigator;
import com.privalia.albert.challange.presentation.ui.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Main application screen. This is the app entry point.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
                            implements MainNavigator, HasSupportFragmentInjector {

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
        viewModel.setNavigator(this);
        setUp();
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
        this.activityMainBinding.recyclerMovies.setAdapter(this.movieAdapter);
        this.activityMainBinding.recyclerMovies.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(this.toolbar);
        setupNavMenu();

        String version = "2123";
        viewModel.updateAppVersion(version);
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
    }

    private void setupNavMenu() {
    }

    @Override
    public void openLoginActivity() {
        finish();
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
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
}
