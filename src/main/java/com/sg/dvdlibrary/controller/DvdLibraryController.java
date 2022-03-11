/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DvdCollection;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author abekoppal
 */
public class DvdLibraryController {
    
    private DvdLibraryView view;
    private DvdLibraryDao dao;

    private UserIO io = new UserIOConsoleImpl();

    
    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

   

	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		
                try{
                    while(keepGoing) {
                        menuSelection = getMenuSelection();
                    
                        switch(menuSelection) {
                        case 1:
                            listDvds();
                            break;
                        case 2:
                            createDvd();
                            break;
                        case 3:
                            viewDvd();
                            break;
                        case 4:
                            removeDvd();
                            break;
                        case 5:
                            searchDvdTitle();
                            break;
                        case 6:
                            keepGoing = false;
                            break;
                        default:
                            showIDK();
                    }
                }
                showBye();
                }catch(DvdLibraryPersistenceException e){
                    view.displayErrorMessage(e.getMessage());
                }
        }
	
	private int getMenuSelection(){
            return view.printMenuAndGetSelection();
        }
	
	private void createDvd() throws DvdLibraryPersistenceException {
                view.displayCreateDvdBanner();
		boolean hasErrors = false;
		
		do {
			DvdCollection newDvdCollection = view.getNewDvdCollectionInfo();
			try {
                                dao.addDvd(newDvdCollection.getDvdID(), newDvdCollection);
				view.displayCreateSuccessBanner();
				hasErrors = false;
			}catch(Exception ex) {
                                hasErrors = true;
				view.displayErrorMessage(ex.getMessage());
			}
		} while(hasErrors);
	}
	
	private void listDvds() throws DvdLibraryPersistenceException{
                view.displayDisplayAllBanner();
                List<DvdCollection> dvdList = dao.getAllDvds();
		view.displayDvdCollectionList(dvdList);
	}
        
        private void viewDvd() throws DvdLibraryPersistenceException{
            view.displayDisplayDvdBanner();
            String dvdID = view.getDvdIDChoice();
            DvdCollection dvdCollection = dao.getDvd(dvdID);
            view.displayDvd(dvdCollection);
        }
        
        private void searchDvdTitle() throws DvdLibraryPersistenceException{
            view.displayDisplayDvdBanner();
            String title = view.getDvdTitleChoice();
            DvdCollection dvdCollection = dao.getDvdByTitle(title);
            view.displayDvd(dvdCollection);
        }
        
        private void removeDvd() throws DvdLibraryPersistenceException{
            view.displayRemoveDvdBanner();
            String dvdID = view.getDvdIDChoice();
            DvdCollection removedDvd = dao.removeDvd(dvdID);
            view.displayRemoveResult(removedDvd);
        }
	
	private void showIDK(){
        view.displayIDK();
        }
    
        private void showBye(){
        view.displayBYE();
        }
}
