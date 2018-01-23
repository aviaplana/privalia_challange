package com.privalia.albert.challange.presentation.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.privalia.albert.challange.presentation.BR;
import com.privalia.albert.challange.presentation.R;
import com.privalia.albert.challange.presentation.base.BaseActivity;
import com.privalia.albert.challange.presentation.databinding.ActivityMainBinding;
import com.privalia.albert.challange.presentation.ui.navigator.MainNavigator;
import com.privalia.albert.challange.presentation.ui.viewModel.MainViewModel;

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

    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    //.setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    private void setUp() {
        this.toolbar = this.activityMainBinding.toolbar;

        setSupportActionBar(this.toolbar);
        setupNavMenu();

        String version = "2123"; //getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        viewModel.updateAppVersion(version);
        setupCardContainerView();
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
    }

    private void setupCardContainerView() {
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
