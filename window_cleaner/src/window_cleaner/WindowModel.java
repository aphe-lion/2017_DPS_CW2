/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.CleaningRecord;
import entities.House;
import entities.Street;
import entities.StreetsSet;
import exceptions.HouseAlreadyExistsException;
import exceptions.StreetAlreadyExistsException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import window_cleaner.json.JsonDataReader;
import window_cleaner.json.JsonDataWriter;

/**
 *
 * @author sdgospod
 */
public class WindowModel {
    //must be set by hand for now;
    private final static String PATH = "/home/sdgospod/2017_DPS_CW2/temp.json";
    private JsonDataReader dataReader = null;
    private JsonDataWriter dataWriter = null;
    private StreetsSet streets = null;


    public WindowModel() throws IOException {
            dataReader = new JsonDataReader(PATH);
            dataWriter = new JsonDataWriter(PATH);
    }
    
    public void loadData() throws FileNotFoundException{
        dataReader.readSteets();
        streets = dataReader.getStreets();
    }

    Street getStreetByName(String name) {
        return streets.getStreets().get(name);
    } 
    
    void updateCleaningRecordHouseNumber(CleaningRecord record, int houseNumber) throws IOException {
        record.setHouseNumber(houseNumber);
        dataWriter.saveData(streets);
    }

    void updateCleaningRecordPrice(CleaningRecord record, double price) throws IOException {
        record.setPrice(price);
        dataWriter.saveData(streets);
    }

    void updateCleaningRecordLabel(CleaningRecord record, int label) throws IOException {
        if (label >= 0){
            record.setLabel(label);
            dataWriter.saveData(streets);
        }
    }
    
    void updateCleaningRecordDate(CleaningRecord record, Date date) throws IOException, ParseException {
        //System.out.println(date.toString());
        long dateTimestamp = date.getTime();
        record.setDate(dateTimestamp);
        dataWriter.saveData(streets);    
    }

    House addHouseToSreet(Street street, String number) throws IOException, HouseAlreadyExistsException {
        if(street.getHouses().containsKey(number)){
            throw new HouseAlreadyExistsException();
        }
        House house = new House(number);
        street.getHouses().put(house.getNumber(), house);
        dataWriter.saveData(streets);
        return house;
    }

    Street createNewStreet(String name) throws IOException, StreetAlreadyExistsException {
        if(streets.getStreets().containsKey(name)){
            throw new StreetAlreadyExistsException();
        }
        Street street = new Street(name);
        streets.getStreets().put(street.getName(), street);
        dataWriter.saveData(streets);
        return street;
    }
        
    public StreetsSet getStreets() {
        return this.streets;
    }

    
    public void removeStreet(String streetName) throws IOException {
        streets.removeStreet(streetName);
    }
        
    void addRecordToHouse(House house, Double price, int label, long timeInMillis) throws IOException {
        CleaningRecord record = new CleaningRecord(price, label, timeInMillis);
        house.getCleaningRecords().add(record);
        dataWriter.saveData(streets);
    }

    void deleteRecodFromHouse(House house, CleaningRecord record) throws IOException {
        house.getCleaningRecords().remove(record);
        dataWriter.saveData(streets);
    }
}
