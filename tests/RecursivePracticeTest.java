import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecursivePracticeTest {

    @Test
    public void testCountSubstrings1(){
        String word = "banana";
        String substring = "ana";
        int expected = 2;
        int actual = RecursivePractice.countSubstrings(word, substring);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountSubstrings2(){
        String word = "banana";
        String substring = "nan";
        int expected = 1;
        int actual = RecursivePractice.countSubstrings(word, substring);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountSubstrings3(){
        String word = "apple";
        String substring = "lep";
        int expected = 0;
        int actual = RecursivePractice.countSubstrings(word, substring);
        assertEquals(expected, actual);
    }

    @Test
    public void  testConvertIntToString1(){
        int x = 0;
        String expected = "0";
        String actual = RecursivePractice.convertIntToString(x);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testConvertIntToString2(){
        int x = 123;
        String expected = "123";
        String actual = RecursivePractice.convertIntToString(x);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testConvertIntToString3(){
        int x = -567;
        String expected = "-567";
        String actual = RecursivePractice.convertIntToString(x);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testDigitMatch1(){
        int x = 1072503891;
        int y = 62530841;
        int expected = 4;
        int actual = RecursivePractice.digitMatch(x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void testDigitMatch2(){
        int x = 0;
        int y = 840;
        int expected = 1;
        int actual = RecursivePractice.digitMatch(x, y);
        assertEquals(expected, actual);
        int actual2 = RecursivePractice.digitMatch(y, x);
        assertEquals(expected, actual2);
    }

    @Test
    public void testDigitMatch3(){
        int x = 810;
        int y = 30840;
        int expected = 2;
        int actual = RecursivePractice.digitMatch(x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void testDigitMatch4(){
        int x = 0;
        int y = 30841;
        int expected = 0;
        int actual = RecursivePractice.digitMatch(x, y);
        assertEquals(expected, actual);
        int actual2 = RecursivePractice.digitMatch(y, x);
        assertEquals(expected, actual2);
    }

    @Test
    public void testSumReciprocalsBetween1(){
        int lower = -1;
        int upper = 3;
        assertThrows(Exception.class, () -> {RecursivePractice.sumReciprocalsBetween(lower, upper);});
        assertThrows(Exception.class, () -> {RecursivePractice.sumReciprocalsBetween(upper, lower);});

        int lower2 = 4;
        int upper2 = 1;
        assertThrows(Exception.class, () -> {RecursivePractice.sumReciprocalsBetween(lower2, upper2);});
    }

    @Test
    public void testSumReciprocalsBetween2(){
        int lower = 1;
        int upper = 1;
        double expected = 1.0;
        double actual = RecursivePractice.sumReciprocalsBetween(lower, upper);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumReciprocalsBetween3(){
        int lower = 1;
        int upper = 2;
        double expected = 1.5;
        double actual = RecursivePractice.sumReciprocalsBetween(lower, upper);
        double threshold = 0.000001;
        assertTrue(Math.abs((expected - actual)) <= threshold);
    }

    @Test
    public void testWriteBinary1(){
        int x = -1;
        assertThrows(Exception.class, () -> {RecursivePractice.writeBinary(x);});
    }

    @Test
    public void testWriteBinary2(){
        int x = 0;

        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(baos);
        System.setOut(testOut);

        RecursivePractice.writeBinary(x);

        String actual = baos.toString();
        String expected = "0\n";

        assertTrue(actual.equals(expected));
        System.setOut(originalOut);
    }

    @Test
    public void testWriteBinary3(){
        int x = 44;

        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(baos);
        System.setOut(testOut);

        RecursivePractice.writeBinary(x);

        String actual = baos.toString();
        String expected = "101100\n";

        assertTrue(actual.equals(expected));
        System.setOut(originalOut);
    }

    @Test
    public void testMultiplyOdds1(){
        assertThrows(Exception.class, () -> {RecursivePractice.multiplyOdds(-1);});
        assertThrows(Exception.class, () -> {RecursivePractice.multiplyOdds(0);});
    }

    @Test
    public void testMultiplyOdds2(){
        int n = 1;
        int expected = 1;
        int actual = RecursivePractice.multiplyOdds(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyOdds3(){
        int n = 4;
        int expected = 105;
        int actual = RecursivePractice.multiplyOdds(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindSecondLargest1(){
        int[] arr = {1, 2};
        int expected = 1;
        int actual = RecursivePractice.findSecondLargest(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindSecondLargest2(){
        int[] arr = {1, 2, 2};
        int expected = 2;
        int actual = RecursivePractice.findSecondLargest(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindSecondLargest3(){
        int[] arr = {3, 2, 2, 4, 3};
        int expected = 3;
        int actual = RecursivePractice.findSecondLargest(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testCollatz1(){
        int n = 10;
        boolean expected = true;
        boolean actual = RecursivePractice.collatz(n);
        assertEquals(actual, expected);
    }

    @Test
    public void testCollatz2(){
        int n = 12;
        boolean expected = true;
        boolean actual = RecursivePractice.collatz(n);
        assertEquals(actual, expected);
    }

    @Test
    public void testCollatz3(){
        int n = 1;
        boolean expected = true;
        boolean actual = RecursivePractice.collatz(n);
        assertEquals(actual, expected);
    }

    @Test
    public void testPermutation1(){
        assertThrows(Exception.class, () -> {RecursivePractice.permutation(-1, 1);});
        assertThrows(Exception.class, () -> {RecursivePractice.permutation(1, -1);});
        assertThrows(Exception.class, () -> {RecursivePractice.permutation(1, 2);});
    }

    @Test
    public void testPermutation2(){
        int n = 10;
        int r = 1;
        double expected = 10.0;
        double actual = RecursivePractice.permutation(n, r);
        assertEquals(expected, actual);
    }

    @Test
    public void testPermutation3(){
        int n = 7;
        int r = 4;
        double expected = 840.0;
        double actual = RecursivePractice.permutation(n, r);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecamans1(){
        assertThrows(Exception.class, () -> {RecursivePractice.recamans(0);});
        assertThrows(Exception.class, () -> {RecursivePractice.recamans(-1);});
    }

    @Test
    public void testRecamans2(){
        int n = 2;
        int expected = 3;
        int actual = RecursivePractice.recamans(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecamans3(){
        int n = 6;
        int expected = 13;
        int actual = RecursivePractice.recamans(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubsetsOfSize1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        int size = 2;
        assertThrows(Exception.class, () -> {RecursivePractice.subsetsOfSize(list, size);});
    }

    @Test
    public void testSubsetsOfSize2(){
        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(baos);
        System.setOut(testOut);

        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        int size = 2;
        RecursivePractice.subsetsOfSize(list, size);

        String actual = baos.toString();
        String expected = "[Banana, Apple]\n";

        assertTrue(actual.equals(expected));
        System.setOut(originalOut);
    }

    @Test
    public void testSubsetsOfSize3(){
        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(baos);
        System.setOut(testOut);

        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Mango");
        list.add("Peach");
        int size = 2;
        RecursivePractice.subsetsOfSize(list, size);

        String actual = baos.toString();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("[Banana, Apple]");
        expected.add("[Banana, Mango]");
        expected.add("[Banana, Peach]");
        expected.add("[Apple, Mango]");
        expected.add("[Apple, Peach]");
        expected.add("[Mango, Peach]");

        for (String s: expected){
            assertTrue(actual.contains(s));
        }

        System.setOut(originalOut);
    }
}