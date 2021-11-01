package fi.tuni.tamk.tiko.salinville;
import fi.tuni.tamk.tiko.salinville.util.Arrays;
import fi.tuni.tamk.tiko.salinville.util.Math;
import fi.tuni.tamk.tiko.salinville.util.MyConsole;

/** An application that tests whether it's statistically a good idea for mortals
 * to play the lottery
 * @author Ville Salin
 */
public class Main {
    /**The program first checks if the user has provided their lottery numbers as arguments.
     * If not, the program asks for them individually, ensuring all fall within the specified parameters.
     * Next it uses Math.random to create an array of winning numbers, which it compares to the one provided by the user.
     * It announces how many years it takes for the player to first hit x correct numbers.
     * It finally terminates when the player has hit the jackpot within 120 years.
     * @param args lottery numbers provided as arguments.
     */
    public static void main(String [] args) {
        boolean askUser = true;
        int min = 1;
        int max = 40;
        int arraySize = 7;
        int iterations = 0;
        int years = 0;
        int numOfMatches = 0;
        int bestOf = 1;
        String errorMessageNonNumeric = "Please give a number";
        String errorMessageNonMinAndMax = "Please give a unique number between " + min + " and " + max;
        String intro = "Let's play the lottery!";
        String instructions1 = "Choose " + arraySize + " unique numbers. All numbers must be between " + min + " and " + max + ":";
        String instructions2 = "Numbers chosen: ";
        String yourTicket = "Your numbers are ";
        String enter = "Press Enter to play:";
        String victory = "Congratulations, you won! It only took you ";
        String victory2 = " years!";
        String mortal = "Unfortunately, it took you longer than 120 years, which is impossible for a mortal. Let's try again:";
        String freedom = "You have finally beaten the house within a lifetime. Please enjoy your fake millions!";
        int [] lotteryTicket = new int [arraySize];
        System.out.println(intro);
//This portion validates the arguments the user may have given
        if(args.length == arraySize) {
            int [] tempLotteryTicket = Arrays.toIntArray(args);
            boolean duplicateFound = Arrays.uniqueCheck(tempLotteryTicket);
            boolean underOverFound = Arrays.minMaxCheck(min, max, tempLotteryTicket);
            if(duplicateFound == false && underOverFound == false){
                askUser = false;
                lotteryTicket = tempLotteryTicket; 
            }
        }
//if the user didn't provide a valid ticket as arguments, this portion of the program
//asks for it number by number
        if(askUser == true) {
            System.out.println(instructions1);
            for(int i = 0; i < arraySize; i++) { 
                int temp = MyConsole.readInt(min, max, errorMessageNonNumeric, errorMessageNonMinAndMax);
                boolean numFound = Arrays.contains(temp, lotteryTicket);
                if(numFound) {
                    System.out.println(errorMessageNonMinAndMax);
                    i--;
                } else {
                    lotteryTicket[i] = temp;
                }
                System.out.println(instructions2 + (i + 1) + "/" +arraySize);
            }
        }
        System.out.print(yourTicket);
        System.out.println(java.util.Arrays.toString(lotteryTicket));
        System.out.println(enter);
        try{System.in.read();}
        catch(Exception e){}
//The lottery begins. The program finishes after the user's numbers are picked by the randomizer 
//and it takes less than 120 years, assuming one iteration takes one week.
        do {
            bestOf = 0;
            iterations = 0;
            do {
                numOfMatches = 0;
                int [] winnerArray = calculateLotto(min, max, arraySize);
                numOfMatches = Arrays.containsSameValues(lotteryTicket, winnerArray);
                iterations++;
                if (numOfMatches == bestOf) {
                    years = iterations/52;
                    System.out.println("You got " + bestOf + " right in " + years + " year(s).");
                    bestOf++;
                }
            } while (numOfMatches < arraySize);
            years = iterations/52;
            System.out.println(victory + years + victory2);
            System.out.println(mortal);
        } while (years > 120);
        System.out.println(freedom);

    }
    /**The method creates an array with max numbers in it and then fills a second array (size specified in arraySize
     *  with lottery numbers using Math.random. To avoid duplicates, it replaces the chosen value with a 0
     * @return winnerArray, the winning lottery numbers
     */
    private static int[] calculateLotto(int min, int max, int arraySize) {
        int [] numbers = new int [max];
        int [] winnerArray = new int [arraySize];
        for(int i = 0; i < max; i++) {
            numbers[i] = i+1;
        }
        for(int i = 0; i< arraySize; i++) {
            int random = (Math.getRandom(min -1, max -1));
                if(numbers[random] == 0) {
                    i--;
                } else {
                    winnerArray[i] = numbers[random];
                    numbers[random] = 0;
                }
        }
        return winnerArray;
    }
}