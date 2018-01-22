package com.privalia.albert.challange.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by albert on 19/1/18.
 */

@Data
public class PaginatedEntity<RESULT> {

    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    private List<RESULT> results;
}
