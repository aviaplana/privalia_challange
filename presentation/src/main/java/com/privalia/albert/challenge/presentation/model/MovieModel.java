package com.privalia.albert.challenge.presentation.model;

import org.parceler.Parcel;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by albert on 22/1/18.
 */

@Data
@Parcel
public class MovieModel {
    int id;

    int voteCount;

    boolean video;

    String metadataType;

    String title;

    float popularity;

    String posterPath;

    String originalLanguage;

    String originalTitle;

    List<Integer> genereIds;

    String backdropPath;

    boolean adult;

    String overview;

    Date releaseDate;
}