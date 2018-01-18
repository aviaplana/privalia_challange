package com.privalia.albert.challange.data.mapper;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.domain.dto.MovieDto;

import javax.inject.Inject;

/**
 * Created by albert on 18/1/18.
 */

public class MovieEntityDtoMapper extends BaseMapper<MovieEntity, MovieDto> {

    @Inject
    public MovieEntityDtoMapper() {

    }

    public MovieEntity map1(MovieDto o2) {
        if (o2 == null) {
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setId(o2.getId());
        movieEntity.setVoteCount(o2.getVoteCount());
        movieEntity.setVideo(o2.isVideo());
        movieEntity.setMetadataType(o2.getMetadataType());
        movieEntity.setTitle(o2.getTitle());
        movieEntity.setPopularity(o2.getPopularity());
        movieEntity.setPosterPath(o2.getPosterPath());
        movieEntity.setOriginalLanguage(o2.getOriginalLanguage());
        movieEntity.setOriginalTitle(o2.getOriginalTitle());
        movieEntity.setGenereIds(o2.getGenereIds());
        movieEntity.setBackdropPath(o2.getBackdropPath());
        movieEntity.setAdult(o2.isAdult());
        movieEntity.setOverview(o2.getOverview());
        movieEntity.setReleaseDate(o2.getReleaseDate());

        return movieEntity;
    }

    public MovieDto map2(MovieEntity o1) {
        if (o1 == null) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId(o1.getId());
        movieDto.setVoteCount(o1.getVoteCount());
        movieDto.setVideo(o1.isVideo());
        movieDto.setMetadataType(o1.getMetadataType());
        movieDto.setTitle(o1.getTitle());
        movieDto.setPopularity(o1.getPopularity());
        movieDto.setPosterPath(o1.getPosterPath());
        movieDto.setOriginalLanguage(o1.getOriginalLanguage());
        movieDto.setOriginalTitle(o1.getOriginalTitle());
        movieDto.setGenereIds(o1.getGenereIds());
        movieDto.setBackdropPath(o1.getBackdropPath());
        movieDto.setAdult(o1.isAdult());
        movieDto.setOverview(o1.getOverview());
        movieDto.setReleaseDate(o1.getReleaseDate());

        return movieDto;
    }
}