/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sdgospod
 */
public class HouseNumberRenderer extends DefaultTableCellRenderer {
    public HouseNumberRenderer() { super(); }

    public void setValue(Object value) {
        setText("№ " + value.toString());
    }
}
