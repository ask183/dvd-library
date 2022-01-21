/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.ui;

/**
 *
 * @author abekoppal
 */
public class DvdLibraryView {
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
    private UserIO io;
    
    public int printMenuAndGetSelection(){
        io.print("Main menu");
        io.print("1. List DVDs from collection");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Exit");
            
        return io.readInt("Please Select From the choices Above", 1, 5);
    }
    
}
