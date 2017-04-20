/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner.json;

import com.google.gson.Gson;
import entities.StreetsSet;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sdgospod
 */
public class JsonDataWriter {

    private String fileName;
    
    
    public JsonDataWriter(String fileName) throws IOException {
        this.fileName = fileName;
    }
    
    public void saveData(StreetsSet streets) throws IOException{
        FileWriter fileOutputWriter = new FileWriter(fileName);
        new Gson().toJson(streets, fileOutputWriter);
        fileOutputWriter.close();
    }
}
