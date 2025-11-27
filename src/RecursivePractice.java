import java.util.ArrayList;
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
        return convertIntToStringHelper(x / 10, curString);
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
        if (lower <= 0 || upper <= 0 || lower > upper){
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

        if (n == 1){
            return 1;
        }
        int curOdd = 2 * n - 1;
        return curOdd * multiplyOdds(n - 1);

    }

    public static int findSecondLargest(int[] arr){
        return findSecondLargestHelper(arr, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static int findSecondLargestHelper(int[] arr, int index, int l, int sl){
        if (index == arr.length){
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

        if (r == 0){
            return 1.0;
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
            a.add(0);
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

    private static void subsetsOfSizeHelper(ArrayList<String> list, int size, int index, ArrayList<String> subset){
        if (size == 0){
            System.out.println(subset.toString());
            return;
        }

        if (index == list.size() || size > list.size() - index) {
            return;
        }

        // option1: choose current element
        subset.add(list.get(index));
        subsetsOfSizeHelper(list, size - 1, index + 1, subset);
        subset.remove(subset.size() - 1);

        // option2: don't choose current element
        subsetsOfSizeHelper(list, size, index + 1, subset);
    }

    public static int maxSum(ArrayList<Integer> list, int limit){
        if (list.isEmpty() || limit <= 0){
            return 0;
        }
        return maxSumHelper(list, limit, 0);
    }

    private static int maxSumHelper(ArrayList<Integer> list, int limit, int index) {
        if (index == list.size() || limit <= 0) {
            return 0;
        }

        int cur = list.get(index);
        if (cur <= limit) {
            // max(include cur, not include cur)
            return Math.max(cur + maxSumHelper(list, limit - cur, index + 1),
                    maxSumHelper(list, limit, index + 1));
        } else {
            // not include
            return maxSumHelper(list, limit, index + 1);
        }
    }

    public static int waysToClimb(int n){
        if (n <= 0){
            throw new IllegalArgumentException();
        }

        if (n <= 2){
            return n;
        }
        // ways of climbing 1 stair this time + ways of climbing 2 stairs this time
        return waysToClimb(n - 1) + waysToClimb(n - 2);
    }

}
