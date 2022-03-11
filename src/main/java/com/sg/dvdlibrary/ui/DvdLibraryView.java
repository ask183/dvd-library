/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DvdCollection;
import java.util.List;

/**
 *
 * @author abekoppal
 */
public class DvdLibraryView {
    
    private UserIO io;
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        io.print("Main menu");
        io.print("1. List DVDs from collection");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Search for a dvd title");
        io.print("6. Exit");
            
        return io.readInt("Please Select From the choices Above", 1, 6);
    }
    
    public DvdCollection getNewDvdCollectionInfo() {
        String dvdID = io.readString("Please enter DVDs ID");
    	String title = io.readString("Please Enter Dvds Title");
    	String releaseDate = io.readString("Please Enter Dvds Release Date");
    	String mppaRating = io.readString("Please Enter Dvds MPPA Rating");
    	String directorName = io.readString("Please Enter Dvds Director Name");
    	String studio = io.readString("Please Enter Dvds Studio Information");
    	String userRating = io.readString("Please Enter Dvds User Rating");
    	
    	DvdCollection current = new DvdCollection(dvdID);
    	
    	current.setTitle(title);
    	current.setReleaseDate(releaseDate);
    	current.setMppaRating(mppaRating);
    	current.setDirectorName(directorName);
    	current.setStudio(studio);
    	current.setUserRating(userRating);
    	
        return current;
    }
    
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("Dvd successfully created.  Please hit enter to continue");
    }
    
    public void displayDvdCollectionList(List<DvdCollection> dvdCollectionList) {
    	for (DvdCollection currentDvd: dvdCollectionList) {
            String dvdInfo = String.format("#%s : %s", 
                    currentDvd.getDvdID(),
                    currentDvd.getTitle());
    		io.print(dvdInfo);
    	}
    	io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDvdBanner(){
        io.print("=== Display Dvd ===");
    }
    
    public String getDvdIDChoice(){
        return io.readString("Please enter the Dvd ID.");
    }
    
    public String getDvdTitleChoice(){
        return io.readString("Please enter the DVD title.");
    }
    
    public void displayDvd(DvdCollection dvdCollection){
        if (dvdCollection != null){
            io.print(dvdCollection.getDvdID());
            io.print(dvdCollection.getTitle());
            io.print(dvdCollection.getReleaseDate());
            io.print(dvdCollection.getMppaRating());
            io.print(dvdCollection.getDirectorName());
            io.print(dvdCollection.getStudio());
            io.print(dvdCollection.getUserRating()); 
            io.print("");
        } else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    public void displayRemoveDvdBanner(){
        io.print("=== Remove Dvd ===");
    }
    
    public void displayRemoveResult(DvdCollection removedDvd){
        if(removedDvd != null){
            io.print("Dvd succesfully removed.");
        }else{
            io.print("Check your ID. We did not find a dvd that matched.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayIDK(){
        io.print("unknown command");
    }
    
    public void displayBYE(){
        io.print("Good Bye");
    }
    
    public void displayErrorMessage(String errorMSG){
        io.print("=== ERROR ===");
        io.print(errorMSG);
    }
    
}
