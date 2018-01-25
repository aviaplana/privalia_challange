package com.privalia.albert.challenge.presentation.di.module;

import android.app.Application;
import android.content.Context;

import com.privalia.albert.challenge.data.manager.NetworkManager;
import com.privalia.albert.challenge.data.manager.impl.NetworkManagerImpl;
import com.privalia.albert.challenge.presentation.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    @Provides
    @AppScope
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @AppScope
    NetworkManager providesNetworkManager(Application application) {
        return new NetworkManagerImpl(application);
    }
}