/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.InputStream;

/**
 *
 * @author mac
 */
public class Movie {
    private int movieID;
    private String title;
    private String genre;
    private int duration;
    private String description;
    private String actor;
    private byte[] image;

    public Movie(int movieID, String title, String genre, int duration,String actor, String description, byte[] image) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.actor = actor;
        this.image = image;
    }
    public Movie(String title, String genre, int duration,String actor, String description, byte[] image) {
   
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.actor = actor;
        this.image = image;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getActor() {
        return actor;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }
    
}
