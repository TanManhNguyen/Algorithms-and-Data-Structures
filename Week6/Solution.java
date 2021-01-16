package Week6;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static Queue<Integer>[] fillBuckets(int[] array) {
        if(array == null) return null;
        if(array.length == 0) {
            Queue<Integer>[] q = new Queue[0];
            return q;
        }

        int vmin = Integer.MAX_VALUE;
        int vmax = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            if(array[i] > vmax) vmax = array[i];
            if(array[i] < vmin) vmin = array[i];
        }

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];

        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();
        for(int i = 0; i < array.length; i++)
            buckets[array[i]-vmin].add(array[i]);

        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        int[] temp = new int[30000];
        int c = 0;

        for(int i = 0; i < buckets.length; i++)
            for(int j = 0; j < buckets[i].size(); j++)
                temp[c++] = buckets[i].poll();

        int[] res = new int[c];
        for(int i = 0; i < c; i++)
            res[i] = temp[i];

        return res;
    }

    public static void stableSort(String[][] table, int column) {
        if(table == null) return;
        if(table.length == 0) return;
        if(column >= table[0].length) return;

        PriorityQueue<Entry> p = new PriorityQueue<>();

        for (int i = 0; i < table.length; i++) {
            p.add(new Entry(table[i][column], table[i], i));
        }

        for (int i = 0; i < table.length; i++) {
            table[i] = p.remove().getEntry();
        }
    }

    public static class Entry implements Comparable {
        public String key;
        public String[] entry;
        public int index;

        public Entry(String key, String[] entry, int index) {
            this.key = key;
            this.entry = entry;
            this.index = index;
        }

        public String[] getEntry() {
            return entry;
        }

        @Override
        public int compareTo(Object o) {
            Entry that = (Entry) o;
            int p = this.key.compareTo(that.key);
            if(p != 0) {
                return p;
            }
            else {
                return this.index - that.index;
            }
        }
    }
}



