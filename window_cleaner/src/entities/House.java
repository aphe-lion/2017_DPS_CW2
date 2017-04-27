/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;


/**
 *
 * @author sdgospod
 */
public class House {
    private String number;
    private ArrayList<CleaningRecord> cleaningRecords;

    public House(String number){
        this.number = number;
        cleaningRecords = new ArrayList<CleaningRecord>();
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the cleaningRecords
     */
    public ArrayList<CleaningRecord> getCleaningRecords() {
        return cleaningRecords;
    }
}
