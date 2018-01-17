package com.privalia.albert.challange.presentation.di.module;

import com.privalia.albert.challange.presentation.di.scope.AppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 7/1/18.
 */

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson context() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder
                .create();
    }
}