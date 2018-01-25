package com.privalia.albert.challenge.presentation.di.module;

import com.privalia.albert.challenge.presentation.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by albert on 31/12/17.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}