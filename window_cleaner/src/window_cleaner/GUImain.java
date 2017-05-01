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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
        addRecordButton.setVisible(false);
        addHouseButton.setVisible(false);
        removeStreetButton.setVisible(false);
        removeHouseButton.setVisible(false);
        displayMessage("Pick a street to start");
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
        jSeparator1 = new javax.swing.JSeparator();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        balanceLabel = new javax.swing.JLabel();
        balanceValueLabel = new javax.swing.JLabel();
        optionalErrorMessage = new javax.swing.JLabel();
        addStreetButton = new javax.swing.JButton();
        addHouseButton = new javax.swing.JButton();
        addRecordButton = new javax.swing.JButton();
        streetNameComboBox = new javax.swing.JComboBox<>();
        removeStreetButton = new javax.swing.JButton();
        removeHouseButton = new javax.swing.JButton();
        removeRecordButton = new javax.swing.JButton();

        statusComboBox.setEditable(false);
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAID", "NOT PAID", "NEXT TIME" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment tracker");

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
        table.getTableHeader().setReorderingAllowed(false);
        tableScrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setCellRenderer(new HouseNumberRenderer());
            table.getColumnModel().getColumn(1).setCellRenderer(new PriceRenderer());
            table.getColumnModel().getColumn(2).setCellEditor(createCalenderMenu());
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(statusComboBox));
        }

        balanceLabel.setText("Balance:");

        balanceValueLabel.setText("0");

        addStreetButton.setText("New street");
        addStreetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStreetButtonActionPerformed(evt);
            }
        });

        addHouseButton.setText("New house");
        addHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouseButtonActionPerformed(evt);
            }
        });

        addRecordButton.setText("New record");
        addRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordButtonActionPerformed(evt);
            }
        });

        streetNameComboBox.setModel(fillStreetPickerComboBox());
        streetNameComboBox.setToolTipText("");
        streetNameComboBox.setName(""); // NOI18N
        streetNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetNameComboBoxActionPerformed(evt);
            }
        });

        removeStreetButton.setText("Remove street");
        removeStreetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStreetButtonActionPerformed(evt);
            }
        });

        removeHouseButton.setText("Remove House");
        removeHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeHouseButtonActionPerformed(evt);
            }
        });

        removeRecordButton.setText("Remove record");
        removeRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRecordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(optionalErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(215, 215, 215))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(streetNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(67, 67, 67)
                                .addComponent(balanceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(balanceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addStreetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addHouseButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addRecordButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeStreetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRecordButton)
                                .addGap(126, 126, 126))))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceLabel)
                    .addComponent(balanceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addRecordButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addStreetButton)
                        .addComponent(removeStreetButton)
                        .addComponent(addHouseButton)
                        .addComponent(removeHouseButton)
                        .addComponent(removeRecordButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(optionalErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        addStreetButton.getAccessibleContext().setAccessibleName("AddStreetButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHouseButtonActionPerformed
        new AddHouseWindow(controller).setVisible(true);
    }//GEN-LAST:event_addHouseButtonActionPerformed

    private void addRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordButtonActionPerformed
        new AddRecordWindow(controller).setVisible(true);
    }//GEN-LAST:event_addRecordButtonActionPerformed

    private void addStreetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStreetButtonActionPerformed
        new AddStreetWindow(controller).setVisible(true);
    }//GEN-LAST:event_addStreetButtonActionPerformed

    private void streetNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetNameComboBoxActionPerformed
        String searchText = streetNameComboBox.getSelectedItem().toString();
        controller.setCurrentStreet(controller.findStreet(searchText));
        
        if (searchText.equals("Pick a street...")) {
            cleanTable();
            displayMessage("Pick a street to start");
            addRecordButton.setVisible(false);
            addHouseButton.setVisible(false);
            removeStreetButton.setVisible(false); 
        } else { 
            redrawTable();
            refreshBalance();
            displayMessage("");
            addRecordButton.setVisible(controller.getCurrentStreet().hasAnyHouses());
            addHouseButton.setVisible(true);
            removeStreetButton.setVisible(true); 
        }
    }//GEN-LAST:event_streetNameComboBoxActionPerformed

    private void removeStreetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStreetButtonActionPerformed
        try {
            controller.removeSelectedStreet(streetNameComboBox.getSelectedItem().toString());
            updateStreetComboBox();
            cleanTable();
            addRecordButton.setVisible(false);
            addHouseButton.setVisible(false);
            removeStreetButton.setVisible(false);
        } catch (IOException e) {}
    }//GEN-LAST:event_removeStreetButtonActionPerformed

    private void removeHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeHouseButtonActionPerformed
//        new RemoveHouseWindow();
    }//GEN-LAST:event_removeHouseButtonActionPerformed

    private void removeRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRecordButtonActionPerformed
        int row = table.getSelectedRow();
        if(row == -1){
           JOptionPane.showMessageDialog(null, "Select record first", "Ops", JOptionPane.INFORMATION_MESSAGE);
       }else{
           String houseNumber = (String)table.getModel().getValueAt(row, 0);
           CleaningRecord record = recordsIndexTable.get(row);
            try {
                controller.removeRecord(houseNumber, record);
            } catch (IOException ex) {}
       }
    }//GEN-LAST:event_removeRecordButtonActionPerformed

    private DatePickerCellEditor createCalenderMenu() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        DatePickerCellEditor calenderMenu = new DatePickerCellEditor(dateFormat);
        return calenderMenu;
    }
    
    private DefaultComboBoxModel fillStreetPickerComboBox () {
        Vector<String> streets = new Vector(1, 1);
        streets.add("Pick a street...");
        streets.addAll(controller.getAllStreets().keySet());
        return new DefaultComboBoxModel(streets);
    }
    
    public void updateStreetComboBox() {
        streetNameComboBox.setModel(fillStreetPickerComboBox());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHouseButton;
    private javax.swing.JButton addRecordButton;
    private javax.swing.JButton addStreetButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel balanceValueLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel optionalErrorMessage;
    private javax.swing.JButton removeHouseButton;
    private javax.swing.JButton removeRecordButton;
    private javax.swing.JButton removeStreetButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JComboBox<String> streetNameComboBox;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

    public void redrawTable() {    
        DefaultTableModel tModel = (DefaultTableModel) table.getModel();
        cleanTable();
        Iterator housesIterator = controller.getCurrentStreet().getHouses().values().iterator();
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
    
    private String formatHouseNumber(int houseNumber) {
        return Integer.toString(houseNumber);
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
                System.out.println(column);
                controller.editRecord(recordsIndexTable.get(row), column, value);
                // Get the current street and redraw table
                // It's a bit of a hack but w/e
                String searchText = streetNameComboBox.getSelectedItem().toString();
                redrawTable();
                refreshBalance();
            } catch (ParseException ex) {
                System.out.println("Not sure why this happened");
            } catch (IOException ex) {
                System.out.println(value);
            } 
        }
    }

    void displayMessage(String message) {
        optionalErrorMessage.setText(message);
    }

    public void refreshBalance() {
        balanceValueLabel.setText(Double.toString(controller.getCurrentStreet().getBalance()));
    }
}
