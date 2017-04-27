/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import entities.CleaningRecord;
import entities.House;
import entities.Street;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.table.DatePickerCellEditor;

/**
 *
 * @author badan
 */
public class GUImain extends javax.swing.JFrame implements TableModelListener{
    
    WindowController controller = null;
    
    private static final String[] labels = {"PAID", "NOT PAID", "NEXT TIME"};
    private HashMap<Integer, CleaningRecord> recordsIndexTable;
    private static int recordsIndex = 0;
    /**
     * Creates new form GUImain
     */
    GUImain(WindowController controller) {
        this.controller = controller;
        initComponents();
        table.getModel().addTableModelListener(this);
        recordsIndexTable = new HashMap<Integer, CleaningRecord>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusComboBox = new javax.swing.JComboBox<>();
        streetLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        balanceLabel = new javax.swing.JLabel();
        balanceValueLabel = new javax.swing.JLabel();
        optionalErrorMessage = new javax.swing.JLabel();
        streetNameTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        statusComboBox.setEditable(false);
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAID", "NOT PAID", "NEXT TIME" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment tracker");

        streetLabel.setText("Street:");

        table.setBackground(new java.awt.Color(237, 237, 237));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "House", "Price", "Date", "Staus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(237, 237, 237));
        jScrollPane3.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(2).setCellEditor(createCalenderMenu());
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(statusComboBox));
        }

        balanceLabel.setText("Balance:");

        balanceValueLabel.setText("0");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(streetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(balanceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(optionalErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetLabel)
                    .addComponent(balanceLabel)
                    .addComponent(balanceValueLabel)
                    .addComponent(streetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionalErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        searchButton.getAccessibleContext().setAccessibleName("SearchButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchText = streetNameTextField.getText();
        Street currentStreet = controller.findStreet(searchText);
        if (currentStreet != null){
            redrawTable(currentStreet);
            optionalErrorMessage.setText("");
        } else {
            cleanTable();
            optionalErrorMessage.setText("\"" + searchText +"\" not found");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    // Creates a DatePickerCellEditor with some settings changed
    private DatePickerCellEditor createCalenderMenu() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        DatePickerCellEditor calenderMenu = new DatePickerCellEditor(dateFormat);
        return calenderMenu;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel balanceValueLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel optionalErrorMessage;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetNameTextField;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void redrawTable(Street street) {    
        DefaultTableModel tModel = (DefaultTableModel) table.getModel();
        cleanTable();
        Iterator housesIterator = street.getHouses().values().iterator();
        while(housesIterator.hasNext()){
            House h = (House) housesIterator.next();
            Iterator recordsIterator = h.getCleaningRecords().iterator();
            while(recordsIterator.hasNext()){
                CleaningRecord record = (CleaningRecord) recordsIterator.next();
                recordsIndexTable.put(recordsIndex++, record);
                Object houseNumber = h.getNumber();
                Object price = record.getPrice();
                Object date = formatDate(record.getDate());
                Object label = formatLabel(record.getLabel());
                tModel.addRow(new Object[]{ houseNumber, price, date, label});
            }
        }
    }
    
    //private Street getCurrentStreet() {
    //    return controller.findStreet(streetNameTextField.getText());
    //}

    private String formatPrice(double price) {
        // TODO: I do not why I can not convert double to string
        return Double.toString(price);
    }

    private String formatDate(long date) {
        SimpleDateFormat formater = new SimpleDateFormat("d MMM yyyy");
        return formater.format(new Date(date));
    }

    private String formatLabel(int label) {
        return labels[label];
    }

    private void cleanTable() {
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        recordsIndexTable.clear();
        recordsIndex = 0;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getType() == TableModelEvent.UPDATE){
            int row = e.getLastRow();
            int column = e.getColumn();
            Object value = table.getModel().getValueAt(row, column);
            try {
                // Edit record
                controller.editRecord(recordsIndexTable.get(row), column, value);
                // Get the current street and redraw table
                // It's a bit of a hack but w/e
                String searchText = streetNameTextField.getText();
                Street currentStreet = controller.findStreet(searchText);
                redrawTable(currentStreet);
            } catch (ParseException ex) {
                System.out.println("Not sure why this happened");
            } catch (IOException ex) {
                System.out.println(value);
            } 
        }
    }
}
