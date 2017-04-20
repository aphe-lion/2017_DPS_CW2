/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.StreetsSet;
import java.io.IOException;
import window_cleaner.json.JsonDataReader;
import window_cleaner.json.JsonDataWriter;

/**
 *
 * @author sdgospod
 */
public class WindowModel {
    private final static String PATH = "path/file.json"; //must be set by hand for now; 
    private JsonDataReader dataReader = null;
    private JsonDataWriter dataWriter = null;
    private StreetsSet streets = null;
    
    public WindowModel() {
        try {
            dataReader = new JsonDataReader(PATH);
            dataWriter = new JsonDataWriter(PATH);
            dataReader.readSteets();
            streets = dataReader.getStreets();
        } catch (IOException ex) {
            System.out.println("Something went wrong");
            System.exit(-1);
        }
        
    }
}
