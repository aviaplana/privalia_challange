package com.privalia.albert.challange.presentation.mapper;

import com.privalia.albert.challange.data.mapper.PaginatedEntryDtoMapper;
import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.domain.dto.PaginatedDto;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.privalia.albert.challange.presentation.model.PaginatedModel;

import javax.inject.Inject;

/**
 * Created by albert on 22/1/18.
 */

public class MoviePaginatedDtoModelMapper
        extends PaginatedDtoModelMapper<MovieDto, MovieModel> {

    @Inject
    public MoviePaginatedDtoModelMapper(MovieDtoModelMapper movieMapper) {
        super(movieMapper);
    }

}