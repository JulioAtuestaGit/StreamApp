package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
/* classes extending from this. cannot be created directly in the DB their linked to the main class' id
 * short production' id is used as a foreign key in production' id thus short production must exist first
 * and a row in production table is created manually in java after a short production row is added
 * */
@Table(name = "short_production")
public class ShortProduction{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
        private Integer id;
        @JsonAlias("Title")
        @Column(name = "production_title")
        private String title;
        @JsonAlias("Year")
        @Column(name = "production_year")
        private String year;
        @JsonAlias("Type")
        @Column(name = "production_type")
        private String type;

    public Integer getId() {return id;}
    public String getTitle() {return title;}
    public String getYear() {return year;}
    public String getType() {return type;}

    public void play(){
        System.out.println("Now playing :"+this.getTitle());
    }
    @Override
    public String toString() {
        return "\nTitle: "+ title
            +"\nYear: "+year
            +"\nType :"+type;
    }
}
