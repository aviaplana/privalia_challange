package com.privalia.albert.challange.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by albert on 23/1/18.
 */

@Data
public class ImageConfigurationEntity {

    @SerializedName("base_url")
    private String baseUrl;

    @SerializedName("secure_base_url")
    private String secureBaseUrl;

    @SerializedName("logo_sizes")
    private List<String> logoSizes;

    @SerializedName("poster_sizes")
    private List<String> posterSizes;

    @SerializedName("profile_sizes")
    private List<String> profileSizes;

    @SerializedName("still_sizes")
    private List<String> stillSizes;
}
