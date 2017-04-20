/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_cleaner;

/**
 *
 * @author tmitche1
 */
public class WindowCleaner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowModel model = new WindowModel();
        WindowController controller = new WindowController(model);
    }
    
}
