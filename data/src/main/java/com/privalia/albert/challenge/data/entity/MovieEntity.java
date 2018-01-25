package com.privalia.albert.challenge.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by albert on 18/1/18.
 */

@Data
public class MovieEntity {

    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    private boolean video;

    @SerializedName("media_type")
    private String metadataType;

    private String title;

    private float popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("genre_ids")
    private List<Integer> genereIds;

    @SerializedName("backdrop_path")
    private String backdropPath;

    private boolean adult;

    private String overview;

    @SerializedName("release_date")
    private Date releaseDate;
}
