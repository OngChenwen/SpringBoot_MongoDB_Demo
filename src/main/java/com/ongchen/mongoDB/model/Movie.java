package com.ongchen.mongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Entity in JPA
@Document
public class Movie {
    @Id
    private String id;
    private String name;
    private String category;
    private String rating;
    public Movie() {}

    public Movie(String name, String category, String rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getRating() {return rating;}
    public void setRating(String rating) {this.rating = rating;}

}
