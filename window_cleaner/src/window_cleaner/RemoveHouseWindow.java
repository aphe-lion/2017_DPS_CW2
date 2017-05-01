/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

import java.io.IOException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tmitche1
 */
public class RemoveHouseWindow extends javax.swing.JFrame {

    WindowController controller;
    
    public RemoveHouseWindow(WindowController controller) {
        this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        housePickerComboBox = new javax.swing.JComboBox<>();
        removeHouseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        housePickerComboBox.setModel(fillHousePickerComboBox());

        removeHouseButton.setText("Remove house");
        removeHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeHouseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(housePickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeHouseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(housePickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeHouseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeHouseButtonActionPerformed
        try {
            controller.removeHouse(housePickerComboBox.getSelectedItem().toString());  
            this.dispose();
        } catch (IOException e) {}
    }//GEN-LAST:event_removeHouseButtonActionPerformed

    private DefaultComboBoxModel fillHousePickerComboBox() {
        //Vector<String> streets = new Vector(1, 1);
        //streets.add("Pick a street...");
        return new DefaultComboBoxModel(controller.getHousesForCurentStreet());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> housePickerComboBox;
    private javax.swing.JButton removeHouseButton;
    // End of variables declaration//GEN-END:variables
}