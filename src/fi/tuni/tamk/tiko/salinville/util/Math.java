package fi.tuni.tamk.tiko.salinville.util;
/** The class Math contains mathematical operations and was originally created
 * as part of an intro to programming course at TUNI
 * @author Ville Salin
*/
public class Math {
    /** Returns a pseudo-random integer between and including specified integers
     * using Math.random
     * @param min smallest integer that can be returned
     * @param max largest integer that can be returned
     * @return integer between min and max
    */
    public static int getRandom(int min, int max) {

        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}