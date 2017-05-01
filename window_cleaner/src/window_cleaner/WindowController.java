/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.CleaningRecord;
import entities.House;
import entities.Street;
import exceptions.HouseAlreadyExistsException;
import exceptions.StreetAlreadyExistsException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author sdgospod
 */
public class WindowController {
    private WindowModel model;
    private GUImain view;
    private Street currentStreet = null;
    
    WindowController(WindowModel model) throws FileNotFoundException {
        this.model = model;
        model.loadData();
        view = new GUImain(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }   

    Street findStreet(String searchText) {
        return model.getStreetByName(searchText);
    }
    
    public Map getAllStreets () {
        return model.getStreets().getStreets();
    }

    void editRecord(CleaningRecord record, int column, Object value) throws IOException, ParseException {
        switch(column){
            case 0:
                model.updateCleaningRecordHouseNumber(record, (Integer)value);
                break;
            case 1:
                model.updateCleaningRecordPrice(record, (Double)value);
                break;
            case 2:
                // dates
                model.updateCleaningRecordDate(record, (Date)value);
                break;
            case 3:
                model.updateCleaningRecordLabel(record, getLabel(value));
                break;
        }
//        System.out.println(record.getPrice());
    }

    private int getLabel(Object value) {
        if ("PAID".equals((String)value)){
            return 0;
        }else if("NOT PAID".equals((String)value)){
            return 1;
        }else if("NEXT TIME".equals((String)value)){
            return 2;
        }
        return -1;
    }

    /**
     * @param currentStreet the currentStreet to set
     */
    public void setCurrentStreet(Street currentStreet) {
        this.currentStreet = currentStreet;
    }
    
    public Street getCurrentStreet() {
        return currentStreet;
    }

    public void addStreet(String name) throws IOException, StreetAlreadyExistsException{
        Street newStreet = model.createNewStreet(name);
        currentStreet = newStreet;
        view.displayMessage(newStreet.getName() + " street was created");
        view.redrawTable();
        view.refreshBalance();
    }
    
    public void addHouse(String number) throws IOException, HouseAlreadyExistsException{
        House newHouse = model.addHouseToSreet(currentStreet, number);
        view.displayMessage(newHouse.getNumber() + " was added to " + currentStreet.getName());
    }

    Object[] getHousesForCurentStreet() {
        return currentStreet.getHouses().keySet().toArray();
    }
    
    void addRecord(String houseNumber, Double price, String label, long timeInMillis) throws IOException {
        House house = currentStreet.getHouses().get(houseNumber);
        model.addRecordToHouse(house, price, getLabel(label), timeInMillis);
        view.redrawTable();
        view.refreshBalance();
    }
    
    public void updateStreetComboBox () {
        view.updateStreetComboBox();
    }
    
    public void removeSelectedStreet(String streetName) throws IOException {
        model.removeStreet(streetName);
    }

    void removeRecord(String houseNumber, CleaningRecord record) throws IOException {
       House house = currentStreet.getHouses().get(houseNumber);
       model.deleteRecodFromHouse(house, record);
       view.redrawTable();
       view.refreshBalance();
    }
}
