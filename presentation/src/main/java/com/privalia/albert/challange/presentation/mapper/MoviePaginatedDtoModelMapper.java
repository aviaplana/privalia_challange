package com.privalia.albert.challange.presentation.mapper;

import com.privalia.albert.challange.data.mapper.PaginatedEntryDtoMapper;
import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.presentation.model.MovieModel;

import javax.inject.Inject;

/**
 * Created by albert on 22/1/18.
 */

public class MoviePaginatedDtoModelMapper
        extends PaginatedEntryDtoMapper<MovieDto, MovieModel> {

    @Inject
    public MoviePaginatedDtoModelMapper(MovieDtoModelMapper movieMapper) {
        super(movieMapper);
    }

}