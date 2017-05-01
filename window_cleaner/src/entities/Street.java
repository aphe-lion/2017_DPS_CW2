/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author sdgospod
 */
public class Street {
    private String name;
    private HashMap<String, House> houses; 
    
    public Street(String name){
        this.name = name;
        houses = new HashMap<String, House>();
    }

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the houses
     */
    public Map<String, House> getHouses() {
        return houses;
    }

    public double getBalance() {
        double balance = 0;
        Iterator housesIterator = houses.values().iterator();
        while (housesIterator.hasNext()) {
            House h = (House)housesIterator.next();
            Iterator recordsIterator = h.getCleaningRecords().iterator();
            while (recordsIterator.hasNext()) {
                CleaningRecord record = (CleaningRecord)recordsIterator.next();
                if(record.isPaid()){
                    balance += record.getPrice();
                }
            }
        }
        return balance;
    }
}
