package com.privalia.albert.challange.presentation.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.privalia.albert.challange.data.net.Api;
import com.privalia.albert.challange.presentation.BuildConfig;
import com.privalia.albert.challange.presentation.di.scope.AppScope;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @AppScope
    @Provides
    public Cache cache(Context context) {
        return new Cache(new File(context.getCacheDir(), BuildConfig.HTTP_CACHE_DIR),
                BuildConfig.HTTP_CACHE_SIZE);
    }

    @AppScope
    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache, Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        return logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @AppScope
    @Provides
    @Named("retrofit_api")
    public Retrofit retrofitApi(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public Api Api(@Named("retrofit_api") Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}