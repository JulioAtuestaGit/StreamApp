package com.example.demo.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode extends Production{
    @JsonAlias("Season")
    private String season ="NA";
    @JsonAlias("Episode")
    private String episodeNumber ="NA";

}
