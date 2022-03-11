/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DvdCollection;
import java.util.List;

/**
 *
 * @author abekoppal
 */
public interface DvdLibraryDao {
    
    DvdCollection addDvd(String dvdID, DvdCollection dvdCollection) throws DvdLibraryPersistenceException;
    
    List<DvdCollection> getAllDvds() throws DvdLibraryPersistenceException;
    
    DvdCollection getDvd(String dvdID) throws DvdLibraryPersistenceException;
    
    DvdCollection getDvdByTitle(String title) throws DvdLibraryPersistenceException;
    
    DvdCollection removeDvd(String dvdID) throws DvdLibraryPersistenceException;
    
}
