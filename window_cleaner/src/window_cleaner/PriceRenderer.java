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
public class PriceRenderer extends DefaultTableCellRenderer {
    public PriceRenderer() { super(); }

    public void setValue(Object value) {
        setText("£ " + String.format("%.2f", (Double)value));
    }
}
