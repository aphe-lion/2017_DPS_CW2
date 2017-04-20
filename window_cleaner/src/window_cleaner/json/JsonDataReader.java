/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.Street;
import entities.StreetsSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author sdgospod
 */
public class JsonDataReader {
    
    private StreetsSet streets = null;
    private final String fileName;
    
    /**
     * @throws FileNotFoundException if file path is wrong 
     * @throws IOException if there is error while reading the JSON 
     * @param fileName Input file
     * 
     */
    public JsonDataReader(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
    }
    
    /**
     * Reads JSON and store the data in ArrayList. To get it use getStreets() method.
     * @throws java.io.FileNotFoundException
     */
    public void readSteets() throws FileNotFoundException{
        JsonReader reader = new JsonReader(new FileReader(fileName));
        Map<String, Street> s = new Gson().fromJson(reader, new TypeToken<Map<String, Street>>(){}.getType());
        streets = new StreetsSet(s);
    }
    
    /**
     * @return ArrayList containing all of the streets read from the JSON file;
     */
    public StreetsSet getStreets(){
        return streets;
    } 
}
