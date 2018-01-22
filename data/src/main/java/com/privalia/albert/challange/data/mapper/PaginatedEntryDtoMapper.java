package com.privalia.albert.challange.data.mapper;

import com.privalia.albert.challange.data.entity.PaginatedEntity;
import com.privalia.albert.challange.domain.dto.PaginatedDto;

/**
 * Created by albert on 21/1/18.
 */

public class PaginatedEntryDtoMapper<ENTITY, DTO>
        extends BaseMapper<PaginatedEntity<ENTITY>, PaginatedDto<DTO>> {

    BaseMapper mapper;

    public <MAPPER extends BaseMapper> PaginatedEntryDtoMapper(MAPPER mapper) {
        this.mapper = mapper;
    }

    public PaginatedEntity<ENTITY> map1(PaginatedDto<DTO> o2) {
        if (o2 == null) {
            return null;
        }
        PaginatedEntity<ENTITY> o1 = new PaginatedEntity<>();

        o1.setPage(o2.getPage());
        o1.setTotalPages(o2.getTotalPages());
        o1.setTotalResults(o2.getTotalResults());
        o1.setResults(this.mapper.map1(o2.getResults()));

        return o1;
    }

    public PaginatedDto<DTO> map2(PaginatedEntity<ENTITY> o1) {
        if (o1 == null) {
            return null;
        }

        PaginatedDto<DTO> o2 = new PaginatedDto<>();

        o2.setPage(o1.getPage());
        o2.setTotalPages(o1.getTotalPages());
        o2.setTotalResults(o1.getTotalResults());
        o2.setResults(this.mapper.map2(o1.getResults()));

        return o2;
    }
}
