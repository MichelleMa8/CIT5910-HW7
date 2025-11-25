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


}
