/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author sdgospod
 */
public class StreetsSet implements Serializable{
    private Map<String, Street> streets;

    public StreetsSet(Map<String, Street> streets) {
        this.streets = streets;
    }
    
    public void removeStreet(String streetName) {
        this.streets.remove(streetName);
    }

    /**
     * @return the streets
     */
    public Map<String, Street> getStreets() {
        return streets;
    }

    /**
     * @param streets the streets to set
     */
    public void setStreets(Map<String, Street> streets) {
        this.streets = streets;
    }
}
