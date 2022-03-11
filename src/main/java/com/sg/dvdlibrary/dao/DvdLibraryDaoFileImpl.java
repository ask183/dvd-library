/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DvdCollection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author abekoppal
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    public final String DVD_FILE;
    public static final String DELIMITER = "::";
    private Map<String, DvdCollection> dvds = new HashMap<>();
    
    public DvdLibraryDaoFileImpl(){
        DVD_FILE = "dvd.txt";
    }
    
    public DvdLibraryDaoFileImpl(String dvdTextFile){
        DVD_FILE = dvdTextFile;
    }

    @Override
    public DvdCollection addDvd(String dvdID, DvdCollection dvdCollection) throws DvdLibraryPersistenceException {
        loadRoster();
        DvdCollection prevDvd = dvds.put(dvdID, dvdCollection);
        writeRoster();
        return prevDvd;
    }

    @Override
    public List<DvdCollection> getAllDvds() throws DvdLibraryPersistenceException {
        loadRoster();
        return new ArrayList<DvdCollection>(dvds.values());//this constructor gives you a method that return a collection of students
    }

    @Override
    public DvdCollection getDvd(String dvdID) throws DvdLibraryPersistenceException {
        loadRoster();
        return dvds.get(dvdID);
    }
    
    @Override
    public DvdCollection getDvdByTitle(String title) throws DvdLibraryPersistenceException {
        loadRoster2();
        return dvds.get(title);
    }
    
    @Override
    public DvdCollection removeDvd(String dvdID) throws DvdLibraryPersistenceException {
        loadRoster();
        DvdCollection removedDvd = dvds.remove(dvdID);
        writeRoster();
        return removedDvd;
    }
    
    private DvdCollection unmarshallDvd(String dvdAsText){
        //dvdAsText is expecting a String as a line read in from our file
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        
        String dvdID = dvdTokens[0];
        
        DvdCollection dvdFromFile = new DvdCollection(dvdID);
        
        dvdFromFile.setTitle(dvdTokens[1]);
        
        dvdFromFile.setReleaseDate(dvdTokens[2]);
        
        dvdFromFile.setMppaRating(dvdTokens[3]);
        
        dvdFromFile.setDirectorName(dvdTokens[4]);
        
        dvdFromFile.setStudio(dvdTokens[5]);
        
        dvdFromFile.setUserRating(dvdTokens[6]);
        
        return dvdFromFile;
    }
    
    private void loadRoster() throws DvdLibraryPersistenceException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(
                            new BufferedReader(
                                new FileReader(DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new DvdLibraryPersistenceException("-_- Could not load dvd data into memory.", e);
        }
        
        String currentLine;
        DvdCollection currentDvd;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            
            dvds.put(currentDvd.getDvdID(), currentDvd);
        }
        scanner.close();    
    }
    
    private void loadRoster2() throws DvdLibraryPersistenceException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(
                            new BufferedReader(
                                new FileReader(DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new DvdLibraryPersistenceException("-_- Could not load dvd data into memory.", e);
        }
        
        String currentLine;
        DvdCollection currentDvd;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();    
    }
    
    private String marshallDvd(DvdCollection aDvd){
        String dvdAsText = aDvd.getDvdID() + DELIMITER;
        
        dvdAsText += aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMppaRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserRating();
        
        return dvdAsText;
    }
    
    private void writeRoster() throws DvdLibraryPersistenceException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(DVD_FILE));
        }catch (IOException e){
            throw new DvdLibraryPersistenceException("Could not save dvd data.", e);
        }
        
        //What do we do with the file resource?
        String dvdAsText;
        
        List<DvdCollection> dvdList = this.getAllDvds();
        
        for(DvdCollection dvdCo: dvdList){
            dvdAsText = marshallDvd(dvdCo);
            out.println(dvdAsText);
            out.flush(); //flush is to stream so whatever is in the buffer make sure that line gets printed to the stream
        }
        out.close();
    }
    
}
