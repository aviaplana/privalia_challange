package com.privalia.albert.challange.data.entity.realm;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by albert on 18/1/18.
 */

@Setter
@Getter
@ToString
public class RealmMovieEntity extends RealmObject {
    private int id;

    private int voteCount;

    private boolean video;

    private String metadataType;

    private String title;

    private float popularity;

    private String posterPath;

    private String originalLanguage;

    private String originalTitle;

    private RealmList<Integer> genereIds;

    private String backdropPath;

    private boolean adult;

    private String overview;

    private Date releaseDate;
}
