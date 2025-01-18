package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class JsonClass {
    @JsonAlias("Title")//Json alias only reading // Jsonproperty also writing
    private String title;
    @JsonAlias("Genre")
    private String genre;
    @JsonAlias("Year")
    private String year;
    @JsonAlias("Runtime")
    private String duration;
    @JsonAlias("Plot")
    private String synopsis;
    @JsonAlias("Rated")
    private String rated;
    @JsonAlias("Language")
    private String language;
    @JsonAlias("Director")
    private String director;
    @JsonAlias("Actors")
    private String actors;

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
