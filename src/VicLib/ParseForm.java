/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VicLib;

import javax.swing.JTextField;


public class ParseForm {
    
    public static final int INT_ERROR = -2147483648;
    
    public static int getIntFrom(JTextField f) {
        String value = f.getText();
        int result = INT_ERROR;
        
        if (!isValidEntry(value))
            return INT_ERROR;
        
        try {
            result = Integer.parseInt(value);
            
        } catch (NumberFormatException e) {
            System.err.println("ERROR: VicLib > ParseForm > getIntFrom");
            System.err.println(e);
        }
        
        return result;
    }
    
    private static boolean isValidEntry(String s) {
        return !s.isEmpty();
    }
}
