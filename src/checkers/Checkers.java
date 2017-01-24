/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

/**
 *
 * @author eas57
 */
public class Checkers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NavModel model = new NavModel();
        NavView view = new NavView(model);
        NavController controller = new NavController(model, view);
        
        view.setVisible(true);
    }
    
}
