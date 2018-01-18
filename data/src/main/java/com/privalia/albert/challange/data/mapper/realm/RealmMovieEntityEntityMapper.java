package com.privalia.albert.challange.data.mapper.realm;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.entity.realm.RealmMovieEntity;
import com.privalia.albert.challange.data.mapper.BaseMapper;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by albert on 18/1/18.
 */


public class RealmMovieEntityEntityMapper extends BaseMapper<RealmMovieEntity, MovieEntity> {

    @Inject
    public RealmMovieEntityEntityMapper() {

    }

    public RealmMovieEntity map1(MovieEntity o2) {
        if (o2 == null) {
            return null;
        }

        RealmMovieEntity realmMovieEntity = new RealmMovieEntity();

        realmMovieEntity.setId(o2.getId());
        realmMovieEntity.setVoteCount(o2.getVoteCount());
        realmMovieEntity.setVideo(o2.isVideo());
        realmMovieEntity.setMetadataType(o2.getMetadataType());
        realmMovieEntity.setTitle(o2.getTitle());
        realmMovieEntity.setPopularity(o2.getPopularity());
        realmMovieEntity.setPosterPath(o2.getPosterPath());
        realmMovieEntity.setOriginalLanguage(o2.getOriginalLanguage());
        realmMovieEntity.setOriginalTitle(o2.getOriginalTitle());

        realmMovieEntity.setGenereIds(new RealmList<Integer>(o2.getGenereIds().toArray(
                new Integer[o2.getGenereIds().size()])));

        realmMovieEntity.setBackdropPath(o2.getBackdropPath());
        realmMovieEntity.setAdult(o2.isAdult());
        realmMovieEntity.setOverview(o2.getOverview());
        realmMovieEntity.setReleaseDate(o2.getReleaseDate());

        return realmMovieEntity;
    }

    public MovieEntity map2(RealmMovieEntity o1) {
        if (o1 == null) {
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setId(o1.getId());
        movieEntity.setVoteCount(o1.getVoteCount());
        movieEntity.setVideo(o1.isVideo());
        movieEntity.setMetadataType(o1.getMetadataType());
        movieEntity.setTitle(o1.getTitle());
        movieEntity.setPopularity(o1.getPopularity());
        movieEntity.setPosterPath(o1.getPosterPath());
        movieEntity.setOriginalLanguage(o1.getOriginalLanguage());
        movieEntity.setOriginalTitle(o1.getOriginalTitle());
        movieEntity.setGenereIds(o1.getGenereIds());
        movieEntity.setBackdropPath(o1.getBackdropPath());
        movieEntity.setAdult(o1.isAdult());
        movieEntity.setOverview(o1.getOverview());
        movieEntity.setReleaseDate(o1.getReleaseDate());

        return movieEntity;
    }
}