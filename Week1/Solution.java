package Week1;

public class Solution {

    /**
     * Checks whether the given integer value is a prime number.
     *
     * @param n integer value to be checked if it is a prime number or not
     * @return returns true if n is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if(n <= 1) return false;

        for(int i = 2; i < n; i++)
            if(n % i == 0 && n != i) return false;

        return true;
    }

    /**
     * Counts and returns the number of prime numbers that are less or equal
     * than the given integer value.
     *
     * @param n integer value defining an upper bound on the set of prime number to count
     * @return returns the number of prime numbers that are less or equal than n
     */
    public static int numPrimes(int n) {
        int count = 0;

        for(int i = 2; i < n; i++ )
            if(isPrime(i)) count++;

        return count;
    }

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     */
    public static int sumElementsUpToIterative(int[] arr, int n) {
        int res = 0;
        for(int i = 0; i <= n; i++)
            res += arr[i];
        return res;
    }

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     */
    public static int sumElementsUpToRecursive(int[] arr, int n) {
        if(n == 0) return arr[0];
        return sumElementsUpToRecursive(arr, n-1) + arr[n];
    }

    /**
     * Reverses the order of the elements of the given array.
     *
     * @param arr
     * the array to reverse
     */
    public static void reverse(int[] arr) {
        if(arr == null) return;

        int l = 0;
        int r = arr.length-1;

        while(l < r) {
            int temp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = temp;
        }
    }

    /**
     * Multiplies two numbers using a recursive approach
     *
     * @param num1
     * @param num2
     * @return num1 multiplied with num2
     */
    static int multiply(int num1, int num2) {
        if(num2 == 0) return 0;

        if(num2 > 0) return num1 + multiply(num1, num2 - 1);
        if(num2 < 0) return -num1 + multiply(num1, num2 + 1);

        return 0;
    }

    /**
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacciEnhanced(int n) {
        return fibonacci_helper(n, 0, 1);
    }

    /**
     * Helper function for computing the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @param acc1 - accumulator for the previous number in the Fibonacci sequence.
     * @param acc2 -accumulator for the previous number in the Fibonacci sequence.
     * @return
     */
    public static int fibonacci_helper(int n, int acc1, int acc2) {
        if(n == 0) return acc1;
        if(n == 1) return acc2;

        int temp = acc1;
        acc1 = acc2;
        acc2 += temp;
        return fibonacci_helper(n - 1, acc1, acc2);
    }

    /**
     * Calculates the number of occurrences of integers from the range
     * {0, ..., r} within a given array of integer elements. Returns
     * the array of counts: a new array of integers of size r + 1, where the
     * element at index i denotes the number occurrences of elements equal
     * to i in the given input array (with i in {0, ..., r}).
     * If the input array is null or of length 0, this will return null.
     *
     * @param arr the array of integer elements to be counted.
     * @param r the integer indicating the last element of the range.
     * @return a new array containing the number of occurrences of each
     * integer {0, ..., r} in the input array (index i has the
     * count of elements equal to i in the input array, with i
     * in {0, ..., r})
     */
    public static int[] count(int[] arr, int r) {
        if(arr == null) return null;
        if(arr.length == 0) return null;

        int[] res = new int[r + 1];

        for(int i = 0; i < arr.length; i++)
            if(arr[i] <= (r + 1) && arr[i] >= 0) res[arr[i]]++;

        return res;
    }

    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     *
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if(arr1 == null && arr2 == null) return null;
        if(arr1 == null && arr2 != null) return arr2.clone();
        if(arr1 != null && arr2 == null) return arr1.clone();

        int l, r, i;
        l = r = i = 0;
        int[] res = new int[arr1.length + arr2.length];

        while(l < arr1.length && r < arr2.length) {
            if(arr1[l] <= arr2[r]) res[i++] = arr1[l++];
            else if(arr1[l] > arr2[r]) res[i++] = arr2[r++];
        }
        while( l < arr1.length)
            res[i++] = arr1[l++];
        while(r < arr2.length)
            res[i++] = arr2[r++];

        return res;
    }




}
