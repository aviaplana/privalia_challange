package com.privalia.albert.challenge.presentation.di.module;

import com.privalia.albert.challenge.presentation.di.scope.AppScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by albert on 24/03/2017.
 */

@Module
public class ThreadingModule {

    @Provides
    @AppScope
    @Named("main_thread")
    public Scheduler mainThread(){
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @AppScope
    @Named("executor_thread")
    public Scheduler executorThread(){
        return Schedulers.newThread();
    }

    @Provides
    @AppScope
    @Named("io_thread")
    public Scheduler ioThread(){
        return Schedulers.io();
    }

}
