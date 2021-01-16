package Week2;

import java.util.ArrayList;

public class Solution {
    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x
     *     the entry to remove from the array
     * @param arr
     *     to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        if(arr == null) return null;
        if(arr.length == 0) return arr.clone();

        int index = -1;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == x) {
                index = i;
                break;
            }
        }

        if(index == -1) return arr.clone();
        int[] res = new int[arr.length - 1];

        for(int i = 0; i < arr.length; i++) {
            if(i < index) res[i] = arr[i];
            if(i > index) res[i - 1] = arr[i];
        }

        return res;
    }

    /**
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     *
     * @param list
     *     to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {
        for(int i = list.size() - 1; i >= 0; i--)
            removeLastOccurrence(list.get(i), list);
    }

    /**
     * Takes an ArrayList and removes last occurrence of x,
     * shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5
     * would result in: [5, 1, 9, 8].
     * Note that this method does not return a new list.
     * Instead, the list that is passed as a parameter is changed.
     *
     * @param list
     *     to remove an element from.
     * @param x
     *     element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        if(list == null) return;
        if(list.size() == 0) return;

        for(int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i) == x) {
                list.remove(i);
                break;
            }
        }
    }

    //Clones a 2D double array
    static double[][] clone(double[][] a) {
        if(a.length == 0) return a.clone();

        double[][] b = new double[a.length][a[0].length];

        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[0].length; j++)
                b[i][j] = a[i][j];

        return b;
    }
}
