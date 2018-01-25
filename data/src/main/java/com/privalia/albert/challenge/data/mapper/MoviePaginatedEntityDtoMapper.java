package com.privalia.albert.challenge.data.mapper;

import com.privalia.albert.challenge.data.entity.MovieEntity;
import com.privalia.albert.challenge.domain.dto.MovieDto;

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