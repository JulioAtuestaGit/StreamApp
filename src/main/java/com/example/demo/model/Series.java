package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series extends Production{
    @JsonAlias("Total Seasons")
    private String totalSeasons;
    private List<Season> seasons = new ArrayList<>();//link to each season//seasons title
}

