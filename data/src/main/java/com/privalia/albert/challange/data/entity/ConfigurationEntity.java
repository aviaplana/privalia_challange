package com.privalia.albert.challange.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by albert on 23/1/18.
 */

@Data
public class ConfigurationEntity {
    private ImageConfigurationEntity images;

    @SerializedName("change_keys")
    private List<String> changeKeys;

}
