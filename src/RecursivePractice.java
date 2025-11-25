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
}
