/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.CleaningRecord;
import entities.Street;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


/**
 *
 * @author sdgospod
 */
public class WindowController {
    private WindowModel model;
    private GUImain view;
    
    WindowController(WindowModel model) throws FileNotFoundException {
        this.model = model;
        model.loadData();
        view = new GUImain(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }   

    Street findStreet(String searchText) {
        return model.getStreetByName(searchText);
    }

    void editRecord(CleaningRecord record, int column, Object value) throws IOException, ParseException {
        switch(column){
            case 1:
                model.updateCleaningRecordPrice(record, (Double)value);
                break;
            case 2:
                // dates
                model.updateCleaningRecordDate(record, (Date)value);
                break;
            case 3:
                int label = getLabel(value);
                model.updateCleaningRecordLabel(record, label);
                break;
        }
//        System.out.println(record.getPrice());
    }

    private int getLabel(Object value) {
        if ("PAID".equals((String)value)){
            return 0;
        }else if("NOT PAID".equals((String)value)){
            return 1;
        }else if("NEXT TIME".equals((String)value)){
            return 2;
        }
        return -1;
    }
}
