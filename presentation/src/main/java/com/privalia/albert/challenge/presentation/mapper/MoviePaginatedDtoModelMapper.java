package com.privalia.albert.challenge.presentation.mapper;

import com.privalia.albert.challenge.data.mapper.PaginatedEntryDtoMapper;
import com.privalia.albert.challenge.domain.dto.MovieDto;
import com.privalia.albert.challenge.domain.dto.PaginatedDto;
import com.privalia.albert.challenge.presentation.model.MovieModel;
import com.privalia.albert.challenge.presentation.model.PaginatedModel;

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