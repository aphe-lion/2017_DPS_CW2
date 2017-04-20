/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;


/**
 *
 * @author sdgospod
 */
public class WindowController {
    private WindowModel model;
    private GUImain view;
    
    WindowController(WindowModel model) {
        this.model = model;
        view = new GUImain(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }   
}
