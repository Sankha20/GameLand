/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VicLib;

import javax.swing.JOptionPane;


public class Msg {
    
    public static boolean confirm(String msg) {
        int response;
        response = JOptionPane.showConfirmDialog(null, msg, "Confirmar!", JOptionPane.YES_NO_OPTION);

        return (response == 0);
    }

    public static void alert(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Alerta!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void alertValid(String from) {
        error("Insira um valor válido em " + from + ".");
    }

}
