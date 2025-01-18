package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class Production {
    @JsonAlias("Title")//Json alias only reading // Jsonproperty also writing
    protected String title;
    @JsonAlias("Genre")
    protected String genre;
    @JsonAlias("Year")
    protected String year;
    @JsonAlias("Runtime")
    protected String duration;
    @JsonAlias("Plot")
    protected String synopsis;
    @JsonAlias("Rated")
    protected String rated;
    @JsonAlias("Language")
    protected String language;
    @JsonAlias("Director")
    protected String director;
    @JsonAlias("Actors")
    protected String actors;

    public String getTitle() {return title;}
    public String getGenre() {return genre;}
    public String getYear() {return year;}
    public String getDuration() {return duration;}
    public String getSynopsis() {return synopsis;}
    public String getRated() {return rated;}
    public String getLanguage() {return language;}
    public String getDirector() {return director;}
    public String getActors() {return actors;}

    @Override
    public String toString() {
        return "Title: "+title
                +"\nSynopsis: "+synopsis
                +"\nGenre: "+genre
                +"\nYear: "+year
                +"\nRuntime: "+duration
                +"\nRated :"+rated
                +"\nlanguage :"+language
                +"\nDirector :"+director
                +"\nActors :"+actors
                +" ";
    }
}
