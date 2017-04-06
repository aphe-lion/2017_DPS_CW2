/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.House;
import entities.Street;
import java.io.IOException;
import java.util.ArrayList;
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
            JsonDataReader reader = new JsonDataReader("/example_data.json");//Change it
            reader.readSteets();
            Map streets = reader.getStreets();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUImain(streets).setVisible(true);
            }
        });  
        } catch(IOException ex) {
            System.out.println("sth went wrong :(");
        }
    }
    
}
