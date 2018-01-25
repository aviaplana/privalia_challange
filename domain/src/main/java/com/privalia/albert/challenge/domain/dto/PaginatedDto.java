package com.privalia.albert.challenge.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by albert on 19/1/18.
 */

@Getter
@Setter
public class PaginatedDto<RESULT> {

    private int page;

    private int totalPages;

    private int totalResults;

    private List<RESULT> results;
}
