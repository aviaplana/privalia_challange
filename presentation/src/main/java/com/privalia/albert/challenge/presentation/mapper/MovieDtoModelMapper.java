package com.privalia.albert.challenge.presentation.mapper;

import com.privalia.albert.challenge.data.mapper.BaseMapper;
import com.privalia.albert.challenge.domain.dto.MovieDto;
import com.privalia.albert.challenge.presentation.model.MovieModel;

import javax.inject.Inject;

/**
 * Created by albert on 22/1/18.
 */

public class MovieDtoModelMapper  extends BaseMapper<MovieDto, MovieModel> {

    @Inject
    public MovieDtoModelMapper() {

    }

    public MovieDto map1(MovieModel o2) {
        if (o2 == null) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId(o2.getId());
        movieDto.setVoteCount(o2.getVoteCount());
        movieDto.setVideo(o2.isVideo());
        movieDto.setMetadataType(o2.getMetadataType());
        movieDto.setTitle(o2.getTitle());
        movieDto.setPopularity(o2.getPopularity());
        movieDto.setPosterPath(o2.getPosterPath());
        movieDto.setOriginalLanguage(o2.getOriginalLanguage());
        movieDto.setOriginalTitle(o2.getOriginalTitle());
        movieDto.setGenereIds(o2.getGenereIds());
        movieDto.setBackdropPath(o2.getBackdropPath());
        movieDto.setAdult(o2.isAdult());
        movieDto.setOverview(o2.getOverview());
        movieDto.setReleaseDate(o2.getReleaseDate());

        return movieDto;
    }

    public MovieModel map2(MovieDto o1) {
        if (o1 == null) {
            return null;
        }

        MovieModel movieModel = new MovieModel();

        movieModel.setId(o1.getId());
        movieModel.setVoteCount(o1.getVoteCount());
        movieModel.setVideo(o1.isVideo());
        movieModel.setMetadataType(o1.getMetadataType());
        movieModel.setTitle(o1.getTitle());
        movieModel.setPopularity(o1.getPopularity());
        movieModel.setPosterPath(o1.getPosterPath());
        movieModel.setOriginalLanguage(o1.getOriginalLanguage());
        movieModel.setOriginalTitle(o1.getOriginalTitle());
        movieModel.setGenereIds(o1.getGenereIds());
        movieModel.setBackdropPath(o1.getBackdropPath());
        movieModel.setAdult(o1.isAdult());
        movieModel.setOverview(o1.getOverview());
        movieModel.setReleaseDate(o1.getReleaseDate());

        return movieModel;
    }
}