package com.privalia.albert.challange.domain.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by albert on 18/1/18.
 */

@Setter
@Getter
public class MovieDto {

    private int id;

    private int voteCount;

    private boolean video;

    private String metadataType;

    private String title;

    private float popularity;

    private String posterPath;

    private String originalLanguage;

    private String originalTitle;

    private List<Integer> genereIds;

    private String backdropPath;

    private boolean adult;

    private String overview;

    private Date releaseDate;
}