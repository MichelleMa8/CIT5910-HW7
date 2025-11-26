import java.util.ArrayList;
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

    public static void writeBinary(int x){
        if (x < 0){
            throw new IllegalArgumentException();
        }

        if (x == 0){
            System.out.println("0");
        } else {
            writeBinaryHelper(x, "");
        }
    }

    private static void writeBinaryHelper(int x, String binary){
        if (x == 0){
            System.out.println(binary);
            return;
        }

        int rest = x / 2;
        int binaryDigit = x % 2;
        binary = Character.toString((char)(48 + binaryDigit))+ binary;
        writeBinaryHelper(rest, binary);
    }

    public static int multiplyOdds(int n){
        if (n <= 0){
            throw new IllegalArgumentException();
        }

        return multiplyOddsHelper(n, 1);

    }

    private static int multiplyOddsHelper(int n, int oddNum){
        if (n == 1){
            return oddNum;
        }

        return oddNum * multiplyOddsHelper(n - 1, oddNum + 2);
    }

    public static int findSecondLargest(int[] arr){
        return findSecondLargestHelper(arr, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static int findSecondLargestHelper(int[] arr, int index, int l, int sl){
        if (index > arr.length - 1){
            return sl;
        }

        int cur = arr[index];
        if (cur > sl){
            if (cur >= l){
                sl = l;
                l = cur;
            } else {
                sl = cur;
            }
        }
        return findSecondLargestHelper(arr, index + 1, l, sl);
    }

    public static boolean collatz(int n){
        HashSet<Integer> numSet = new HashSet<>();
        return collatzHelper(n, numSet);
    }

    private static boolean collatzHelper(int n, HashSet<Integer> numSet){
        if (n == 1){
            return true;
        } else if (numSet.contains(n)){
            return false;
        }
        numSet.add(n);

        if (n % 2 == 0){
            n = n / 2;
        } else {
            n = 3 * n + 1;
        }

        return collatzHelper(n, numSet);
    }

    public static double permutation(int n, int r){
        if (n < 0 || r < 0 || n < r){
            throw new IllegalArgumentException();
        }

        if (r == 1){
            return (double)n;
        }

        return (double) n * permutation(n - 1, r - 1);
    }

    public static int recamans(int n){
        if (n <= 0){
            throw new IllegalArgumentException();
        }
        return recamansHelper(n, new HashSet<>());

    }

    private static int recamansHelper(int n, HashSet<Integer> a){
        if (n == 0){
            return 0;
        }

        int prevA = recamansHelper(n - 1, a);
        int newA = prevA - n;

        if (!(newA > 0 && !a.contains(newA))){
            newA = prevA + n;
        }

        a.add(newA);
        return newA;
    }

    public static void subsetsOfSize(ArrayList<String> list, int size){
        if (size > list.size()){
            throw new IllegalArgumentException();
        }

        ArrayList<String> subset = new ArrayList<>();
        subsetsOfSizeHelper(list, size, 0, subset);
    }

    private static void subsetsOfSizeHelper(ArrayList<String> list, int size, int startIndex, ArrayList<String> subset){
        if (size == 0){
            System.out.println(subset.toString());
            return;
        }

        for (int i = startIndex; i < list.size(); i++){
            ArrayList<String> cur = new ArrayList<>();
            cur.add(list.get(i));
            subsetsOfSizeHelper(list, size - 1, i + 1, RecursivePractice.mergeTwoArrayLists(subset, cur));
        }

    }

    private static ArrayList<String> mergeTwoArrayLists(ArrayList<String> list1, ArrayList<String> list2){
        ArrayList<String> result = new ArrayList<>();
        for (String str: list1){
            result.add(str);
        }

        for (String str2: list2){
            result.add(str2);
        }
        return result;
    }
}
