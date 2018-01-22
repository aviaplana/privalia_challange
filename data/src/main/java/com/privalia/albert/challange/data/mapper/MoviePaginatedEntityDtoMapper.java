package com.privalia.albert.challange.data.mapper;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.domain.dto.MovieDto;

import javax.inject.Inject;

/**
 * Created by albert on 19/1/18.
 */

public class MoviePaginatedEntityDtoMapper
        extends PaginatedEntryDtoMapper<MovieEntity, MovieDto> {

    @Inject
    public MoviePaginatedEntityDtoMapper(MovieEntityDtoMapper movieMapper) {
        super(movieMapper);
    }

}