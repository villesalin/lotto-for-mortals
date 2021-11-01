package fi.tuni.tamk.tiko.salinville.util;
/**
 * Class Arrays contains operations related to arrays
 * @author Ville Salin
 */
public class Arrays {
/**
 * Converts a String array into an int array
 * @param array String array that will be converted
 * @return intArray converted int array
 */
    public static int [] toIntArray(String [] array) {
        int [] intArray = new int [array.length];
        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
    return intArray;
    }
    /**
     * returns a boolean value on whether integer value was found in an array
     * @param value integer that is looked for in array
     * @param array target int array
     * @return boolean value, true means int was found
     */
    public static boolean contains(int value, int [] array) {
        boolean numFound = false;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                numFound = true;
                break;
            }
        }
        return numFound;
    }
    /** Checks to see if the provided int array contains duplicates. If duplicates are found,
     * it sends a boolean true statement in return 
     * @param array int array to be checked for duplicates
     * @return  boolean value, true means a duplicate was found
     */
    public static boolean uniqueCheck(int [] array) {
        boolean duplicateFound = false;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j< array.length; j++) {
                if (array[i] == array[j] && i !=j) {
                    duplicateFound = true;
                    break;
                }
            }
        }
        return duplicateFound;
    }
    /**
     * Ensures each int value in the array falls within the minimum and maximum values provided
     * If a value falls outside, the program returns a boolean true value
     * @param min minimum value
     * @param max maximum value
     * @param array array that is checked
     * @return  boolean value, true = number fell outside the min max range
     */
    public static boolean minMaxCheck(int min, int max, int [] array) {
        boolean underOverFound = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min || array[i] > max) {
                underOverFound = true;
                break;
            }
        }
        return underOverFound;
    }
/**
 * Compares the integers in two arrays to each other and returns the number of matches
 * @param array1 first int array
 * @param array2 second int array
 * @return numOfMatches number of integers shared by two arrays
 */
    public static int containsSameValues(int [] array1, int [] array2) { 
        int numOfMatches = 0;
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array1.length; j++) {
                if (array1[i] == array2[j]) {
                    numOfMatches++;
                }
            }
        }
        return numOfMatches;
    }
} 
