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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sdgospod
 */
public class JsonDataReader {
    
    private ArrayList<Street> streets;
    private JsonReader reader = null;
    
    /**
     * @throws FileNotFoundException if file path is wrong 
     * @throws IOException if there is error while reading the JSON 
     * @param fileName Input file
     * 
     */
    public JsonDataReader(String fileName) throws FileNotFoundException, IOException {
        reader = new JsonReader(new FileReader(fileName));
    }
    
    /**
     * Reads JSON and store the data in ArrayList. To get it use getStreets() method.
     */
    public void readSteets(){
        streets = new Gson().fromJson(reader, new TypeToken<ArrayList<Street>>(){}.getType());
    }
    
    /**
     * @return ArrayList containing all of the streets read from the JSON file;
     */
    public ArrayList getStreets(){
        return streets;
    } 
}
