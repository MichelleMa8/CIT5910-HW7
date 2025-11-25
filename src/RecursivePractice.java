import java.util.HashMap;
import java.util.HashSet;

public class RecursivePractice {

    public static int countSubstrings(String word, String substring){
        return countSubstringsHelper(word, substring, 0);
    }

    private static int countSubstringsHelper(String word, String substring, int index){
        if (index + substring.length() > word.length()){
            return 0;
        }

        if (word.substring(index, index + substring.length()).equals(substring)){
            return 1 + countSubstringsHelper(word, substring, index + 1);
        } else {
            return countSubstringsHelper(word, substring, index + 1);
        }
    }

    public static String convertIntToString(int x){
        if (x == 0){
            return Character.toString('0');
        } else if (x < 0){
            return "-" + convertIntToStringHelper(-x, "");
        } else {
            return convertIntToStringHelper(x, "");
        }
    }

    private static String convertIntToStringHelper(int x, String curString){
        if (x == 0){
            return curString;
        }

        char digit = (char)(48 + x % 10);
        curString = Character.toString(digit) + curString;
        return convertIntToStringHelper( x / 10, curString);
    }


    public static int digitMatch(int x, int y){
        // edge case
        if (x != 0 && y != 0){
            return digitMatchHelper(x, y);
        } else if ((x == 0 && y % 10 == 0) || (y == 0 && x % 10 == 0)){
            return 1;
        } else {
            return 0;
        }
    }

    private static int digitMatchHelper(int x, int y){
        if (x == 0 || y == 0){
            return 0;
        }

        int xLast = x % 10;
        int yLast = y % 10;
        int xRest = x / 10;
        int yRest = y / 10;

        if (xLast == yLast){
            return 1 + digitMatchHelper(xRest, yRest);
        } else {
            return digitMatchHelper(xRest, yRest);
        }
    }

    public static double sumReciprocalsBetween(int lower, int upper){
        if (lower < 0 || upper < 0 || lower > upper){
            throw new IllegalArgumentException();
        }

        if (lower == upper){
            return 1.0 / lower;
        }

        return 1.0 / lower + sumReciprocalsBetween(lower + 1, upper);
    }
}
