package Week1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void checkPrime1() {
        boolean res = Solution.isPrime(0);
        assertEquals(res, false);
    }

    @Test
    public void checkTotalPNumbers1() {
        int res = Solution.numPrimes(10);
        assertEquals(4, res);
    }

    @Test
    public void small() {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        assertEquals(6, Solution.sumElementsUpToIterative(arr, 2));
    }

    @Test
    public void smallp() {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        assertEquals(6,  Solution.sumElementsUpToRecursive(arr, 2));
    }

    @Test
    public void testExaample() {
        int[] arr = { 1, 2, 3, 4, 5 };
        Solution.reverse(arr);
        int[] result = { 5, 4, 3, 2, 1 };
        assertArrayEquals(result, arr);
    }

    @Test
    public void mp() {
        assertEquals(20, Solution.multiply(4, 5));
    }

    @Test
    public void testExampdle() {
        assertEquals(5, Solution.fibonacci(5));
    }

    @Test
    public void testBasseZero() {
        assertEquals(0, Solution.fibonacci(0));
    }

    @Test
    public void testBasdeOne() {
        assertEquals(1, Solution.fibonacci(1));
    }

    @Test
    public void testdSmall() {
        assertEquals(13, Solution.fibonacci(7));
    }

    @Test
    public void testMedaium() {
        assertEquals(55, Solution.fibonacci(10));
    }

    @Test
    public void testLargse2() {
        assertEquals(267914296, Solution.fibonacci(42));
    }

    @Test
    public void testTime() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 41, 42, 43, 44));
        for (int n : numbers) {
            runFibWithTime(n);
        }
    }

    public int runFibWithTime(int n) {
        long start = System.currentTimeMillis();
        int res = Solution.fibonacci(n);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time for %d: %d ms", n, end - start));
        return res;
    }

    @Test
    public void testExample() {
        assertEquals(5, Solution.fibonacciEnhanced(5));
    }

    @Test
    public void testBaseZero() {
        assertEquals(0, Solution.fibonacciEnhanced(0));
    }

    @Test
    public void testBaseOne() {
        assertEquals(1, Solution.fibonacciEnhanced(1));
    }

    @Test
    public void testSmall() {
        assertEquals(13, Solution.fibonacciEnhanced(7));
    }

    @Test
    public void testMedium() {
        assertEquals(55, Solution.fibonacciEnhanced(10));
    }

    @Test
    public void testLarge2() {
        assertEquals(267914296, Solution.fibonacciEnhanced(42));
    }

    @Test
    public void testTaime() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 41, 42, 43, 44, 1000));
        for (int n : numbers) {
            runFibWithTisme(n);
        }
    }

    public int runFibWithTisme(int n) {
        long start = System.currentTimeMillis();
        int res = Solution.fibonacciEnhanced(n);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time for %d: %d ms", n, end - start));
        return res;
    }

    @Test
    public void testExaadmple() {
        int[] arr = { 0, 1, 1, 3, 3, 3, 8, 10 };
        int[] result = { 1, 2, 0, 3, 0 };
        for(int i = 0; i < result.length; i++) {
            System.out.println(Solution.count(arr, 4)[i]);
        }
        assertArrayEquals(result, Solution.count(arr, 4));
    }
    @Test
    public void tesatSmall() {
        int[] arr1 = { 1, 2, 4 };
        int[] arr2 = { 2, 3, 5, 6 };
        int[] arr = Solution.merge(arr1, arr2);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        assertArrayEquals(new int[] { 1, 2, 2, 3, 4, 5, 6 }, arr);
    }

}