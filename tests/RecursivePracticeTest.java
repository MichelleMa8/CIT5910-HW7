import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
}