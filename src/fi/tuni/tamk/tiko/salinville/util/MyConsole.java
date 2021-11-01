package fi.tuni.tamk.tiko.salinville.util;
import java.io.Console;  
    /**The class MyConsole involves operations related to the console
     * @author Ville Salin
     */
public class MyConsole {
    /**
     * Asks the user for an integer in a loop until they give one successfully
     * @param errorMessage error message for wrong input type
     * @return the integer given successfully by the user
     */
    public static int readInt(String errorMessage) {
        Console c = System.console();
        boolean intSuccess = false;
        int input = 0;
        do {
            try {
                input = Integer.parseInt(c.readLine());
                intSuccess = true;
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
            }
        } while(!intSuccess);
        return input;
    }
    /**
     * Asks the user for an integer between and including min and max in a loop until
     * the user inputs one
     * @param min lowest accepted value
     * @param max largest accepted value
     * @param errorMessageNonNumeric error for wrong data type
     * @param errorMessageNonMinAndMax error for values too small or large
     * @return user-inputted integer
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        boolean intSuccess = false;
        int input = 0;
        do {
            try {
                input = Integer.parseInt(c.readLine());
                if(input <= max && input >= min) {
                    intSuccess = true;
                } else {
                    System.out.println(errorMessageNonMinAndMax);
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        } while(!intSuccess);
        return input;
    }
}

