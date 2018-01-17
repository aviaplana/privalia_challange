package com.privalia.albert.challange.presentation.di.component.activity;

import com.privalia.albert.challange.presentation.di.module.MainActivityModule;
import com.privalia.albert.challange.presentation.di.scope.PerActivity;
import com.privalia.albert.challange.presentation.ui.activity.MainActivity;
import com.privalia.albert.challange.presentation.ui.viewModel.MainViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by albert on 14/11/17.
 */

@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}