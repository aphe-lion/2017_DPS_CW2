/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Map;

/**
 *
 * @author sdgospod
 */
public class Street {
    private String name;
    private Map<String, House> houses; 

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
}
