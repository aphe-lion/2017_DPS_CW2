/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.House;
import entities.Street;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import window_cleaner.json.JsonDataReader;

/**
 *
 * @author tmitche1
 */
public class Window_cleaner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JsonDataReader reader = new JsonDataReader("example_data.json");
            reader.readSteets();
            Map streets = reader.getStreets();
            String search = "example street";
            Street street = (Street)streets.get(search);
            if(street == null){
                System.out.println("Street not found");
            } else {
                System.out.println(street.getName());
                Iterator it = street.getHouses().values().iterator();
                while(it.hasNext()){
                    System.out.println("\t" + ((House)it.next()).getNumber());
                }
            }
        } catch(IOException ex) {
            System.out.println("sth went wrong :(");
        }
    }
    
}
