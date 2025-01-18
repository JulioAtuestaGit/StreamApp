package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Season extends Production{
    @JsonAlias("Total Episodes")
    private String totalEpisodes;
    @JsonAlias("Season")
    private String seasonNumber;

    private List<Episode> episodes =new ArrayList<>();//lista de episodios por titulo linkeada al objeto episode de la season
}
