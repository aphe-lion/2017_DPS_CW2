/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sdgospod
 */
public class CleaningRecord {
    private int houseNumber;
    private long date;
    private double price;
    private int label;

    /**
     * @return the house number
     */
    public double getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the house number to set
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    /**
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the label
     */
    public int getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(int label) {
        this.label = label;
    }
}
