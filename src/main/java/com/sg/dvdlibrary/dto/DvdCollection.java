/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author abekoppal
 */
public class DvdCollection {
    
    private String dvdID;
    private String title;
    private String releaseDate;
    private String mppaRating;
    private String directorName;
    private String studio;
    private String userRating;  //allows the user to enter additional information, e.g., "Good family movie"
    
    public DvdCollection(String dvdID){
        this.dvdID = dvdID;
    }
    
    public String getDvdID() {
        return dvdID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMppaRating() {
        return mppaRating;
    }

    public void setMppaRating(String mppaRating) {
        this.mppaRating = mppaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
    @Override
    public String toString() {
    return "DVD{" + "dvdID=" + dvdID + ", title=" + title + ", release date=" + releaseDate + ", MPPA rating=" + mppaRating + ", directors name=" + directorName + "studio=" + studio + ",user rating=" + userRating + '}';
    
}
    
    
}