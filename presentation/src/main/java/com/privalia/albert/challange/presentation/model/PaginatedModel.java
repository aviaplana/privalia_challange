package com.privalia.albert.challange.presentation.model;

import java.util.List;

import lombok.Data;

/**
 * Created by albert on 23/1/18.
 */
@Data
public class PaginatedModel<RESULT> {

    private int page;

    private int totalPages;

    private int totalResults;

    private List<RESULT> results;
}
