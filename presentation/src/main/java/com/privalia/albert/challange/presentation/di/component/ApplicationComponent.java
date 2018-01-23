package com.privalia.albert.challange.presentation.di.component;

import android.app.Application;

import com.privalia.albert.challange.presentation.BaseApplication;
import com.privalia.albert.challange.presentation.di.module.ActivityBuilder;
import com.privalia.albert.challange.presentation.di.module.ApplicationModule;
import com.privalia.albert.challange.presentation.di.module.DataStoreModule;
import com.privalia.albert.challange.presentation.di.module.GsonModule;
import com.privalia.albert.challange.presentation.di.module.NetworkModule;
import com.privalia.albert.challange.presentation.di.module.RepositoryModule;
import com.privalia.albert.challange.presentation.di.module.ThreadingModule;
import com.privalia.albert.challange.presentation.di.scope.AppScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * A component whose lifetime is the life of the application.
 */
@AppScope // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class,
                        DataStoreModule.class, NetworkModule.class, ThreadingModule.class,
                        RepositoryModule.class, ActivityBuilder.class, GsonModule.class})

public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {
    void inject(BaseApplication application);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder applicationModule(ApplicationModule applicationModule);

        ApplicationComponent build();
    }

}