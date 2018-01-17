package com.privalia.albert.challange.presentation;

import android.app.Activity;

import com.privalia.albert.challange.data.manager.NetworkManager;
import com.privalia.albert.challange.presentation.di.component.ApplicationComponent;
import com.privalia.albert.challange.presentation.di.component.DaggerApplicationComponent;
import com.privalia.albert.challange.presentation.di.module.ApplicationModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class BaseApplication extends DaggerApplication implements HasActivityInjector {

    @Inject
    NetworkManager mNetworkManager;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private ApplicationComponent mApplicationComponent;


    @Override public void onCreate() {
        initializeInjection();
        initRealm();
        super.onCreate();

        mNetworkManager.start();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mNetworkManager.stop();
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    private void initializeInjection() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .applicationModule(new ApplicationModule())
                .build();
        mApplicationComponent.inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return mApplicationComponent;
    }
}
