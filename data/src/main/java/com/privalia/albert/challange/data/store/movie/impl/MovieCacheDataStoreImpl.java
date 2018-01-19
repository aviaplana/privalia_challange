package com.privalia.albert.challange.data.store.movie.impl;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.entity.realm.RealmMovieEntity;
import com.privalia.albert.challange.data.mapper.realm.RealmMovieEntityEntityMapper;
import com.privalia.albert.challange.data.store.movie.MovieCacheDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by albert on 19/1/18.
 */

public class MovieCacheDataStoreImpl implements MovieCacheDataStore {
    private Realm realm;
    private RealmMovieEntityEntityMapper mapper;

    @Inject
    public MovieCacheDataStoreImpl(RealmMovieEntityEntityMapper mapper) {
        this.realm = Realm.getDefaultInstance();
        this.mapper = mapper;
    }

    @Override
    public void put(List<MovieEntity> movies) {
        this.realm.executeTransaction(realm1 -> {
            realm1.delete(RealmMovieEntity.class);
            realm1.copyToRealm(this.mapper.map1(movies));
        });

    }

    @Override
    public void delete() {
        this.realm.executeTransaction(realm1 -> realm1.delete(RealmMovieEntity.class));
    }

    @Override
    public Observable<List<MovieEntity>> get(String orderBy, int page) {
        List<RealmMovieEntity> cityEntities = this.realm.where(RealmMovieEntity.class).findAll();
        return Observable.just(this.mapper.map2(cityEntities));
    }
}
