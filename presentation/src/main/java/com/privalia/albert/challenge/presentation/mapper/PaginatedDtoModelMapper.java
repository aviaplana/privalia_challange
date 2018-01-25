package com.privalia.albert.challenge.presentation.mapper;

import com.privalia.albert.challenge.data.mapper.BaseMapper;
import com.privalia.albert.challenge.domain.dto.PaginatedDto;
import com.privalia.albert.challenge.presentation.model.PaginatedModel;

/**
 * Created by albert on 23/1/18.
 */

public class PaginatedDtoModelMapper<DTO, MODEL>
        extends BaseMapper<PaginatedDto<DTO>, PaginatedModel<MODEL>> {

    BaseMapper mapper;

    public <MAPPER extends BaseMapper> PaginatedDtoModelMapper(MAPPER mapper) {
        this.mapper = mapper;
    }

    public PaginatedDto<DTO> map1(PaginatedModel<MODEL> o2) {
        if (o2 == null) {
            return null;
        }
        PaginatedDto<DTO> o1 = new PaginatedDto<>();

        o1.setPage(o2.getPage());
        o1.setTotalPages(o2.getTotalPages());
        o1.setTotalResults(o2.getTotalResults());
        o1.setResults(this.mapper.map1(o2.getResults()));

        return o1;
    }

    public PaginatedModel<MODEL> map2(PaginatedDto<DTO> o1) {
        if (o1 == null) {
            return null;
        }

        PaginatedModel<MODEL> o2 = new PaginatedModel<>();

        o2.setPage(o1.getPage());
        o2.setTotalPages(o1.getTotalPages());
        o2.setTotalResults(o1.getTotalResults());
        o2.setResults(this.mapper.map2(o1.getResults()));

        return o2;
    }
}
