package Week6;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testFillBucketsZeroElements() {
        int[] a = {};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(0, a.length);
        // Check no buckets have been created
        assertEquals(0, buckets.length);
    }

    @Test
    public void testFillBucketsOneElement() {
        int[] a = {42};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        // Check one bucket has been created
        assertEquals(1, buckets.length);
        assertEquals(new Integer(42), buckets[0].peek());
    }

    @Test
    public void testFillBucketsTwoElements() {
        int[] a = {42, 21};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        assertEquals(21, a[1]);
        // Check enough buckets have been created
        assertEquals(22, buckets.length);
        // Check that the values are in the right buckets
        assertEquals(new Integer(21), buckets[0].peek());
        assertEquals(new Integer(42), buckets[21].peek());
    }

    @Test
    public void testFillBucketsThreeElements() {
        int[] a = {42, 42, 21};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        assertEquals(42, a[1]);
        assertEquals(21, a[2]);
        // Check one bucket has been created
        assertEquals(22, buckets.length);
        assertEquals(new Integer(21), buckets[0].poll());
        assertEquals(new Integer(42), buckets[21].poll());
        assertEquals(new Integer(42), buckets[21].poll());
    }

    @Test
    public void testSortZeroElements() {
        int[] a = {};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check a has not been changed.
        assertEquals(0, a.length);
        // Check sorted array has the same length.
        assertEquals(0, sorted.length);
    }

    @Test
    public void testSortOneElement() {
        int[] a = {42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check that a new array has been built.
        assertFalse(a == sorted);
        // Check sorted array.
        assertArrayEquals(a, sorted);
    }

    @Test
    public void testSortTwoElements() {
        int[] a = {42, 21};
        int[] expected = {21, 42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check sorted array has the same length.
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testSortThreeElements() {
        int[] a = {42, 15, 21};
        int[] expected = {15, 21, 42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check sorted array has the same length.
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testUnion() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet union12 = ms1.union(ms2);
        MySet union21 = ms2.union(ms1);
        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(5, union12.size());
        assertTrue(union12.contains("a"));
        assertTrue(union12.contains("b"));
        assertTrue(union12.contains("c"));
        assertTrue(union12.contains("d"));
        assertTrue(union12.contains("t"));
        assertEquals(5, union21.size());
        assertTrue(union21.contains("a"));
        assertTrue(union21.contains("b"));
        assertTrue(union21.contains("c"));
        assertTrue(union21.contains("d"));
        assertTrue(union21.contains("t"));
    }

    @Test
    public void testIntersection() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet intersection12 = ms1.intersection(ms2);
        MySet intersection21 = ms2.intersection(ms1);
        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(2, intersection12.size());
        assertTrue(intersection12.contains("a"));
        assertTrue(intersection12.contains("d"));
        assertEquals(2, intersection21.size());
        assertTrue(intersection21.contains("a"));
        assertTrue(intersection21.contains("d"));
    }

    @Test
    public void testDifference() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet difference12 = ms1.difference(ms2);
        MySet difference21 = ms2.difference(ms1);
        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(2, difference12.size());
        assertTrue(difference12.contains("b"));
        assertTrue(difference12.contains("c"));
        assertEquals(1, difference21.size());
        assertTrue(difference21.contains("t"));
    }

    @Test
    public void testXOR() {
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        MySet ms2 = new MySet();
        ms2.add("b");
        ms2.add("c");
        ms2.add("d");
        MySet ms3 = ms1.exclusiveOr(ms2);
        String s = ms3.toString();
        assertTrue(s.contains("a"));
        assertFalse(s.contains("b"));
        assertFalse(s.contains("c"));
        assertTrue(s.contains("d"));
    }

    @Test
    public void testToString() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        // test code
        String s = ms1.toString();
        assertTrue(s.contains("a"));
        assertTrue(s.contains("b"));
        assertTrue(s.contains("c"));
        assertTrue(s.contains("d"));
        assertTrue(s.contains(">"));
        assertTrue(s.contains("<"));
        assertTrue(s.contains("MySet"));
    }

    private static final int DEFAULT_SIZE = 4;

    @Test
    public void testETHHashNull() {
        assertEquals(0, new ETHHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testGNUCPPHashNull() {
        assertEquals(0, new GNUCPPHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testGNUCC1HashNull() {
        assertEquals(0, new GNUCC1Hash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testHashCodeHashNull() {
        assertEquals(0, new HashCodeHash(DEFAULT_SIZE).hash(null));
    }

    @Test
    public void testETHHashHelloWorld() {
        assertEquals(1, new ETHHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCPPHashHelloWorld() {
        assertEquals(1, new GNUCPPHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCC1HashHelloWorld() {
        assertEquals(1, new GNUCC1Hash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testHashCodeHashHelloWorld() {
        assertEquals(3, new HashCodeHash(DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testETHHashHelloWorld2xSize() {
        assertEquals(5, new ETHHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCPPHashHelloWorld2xSize() {
        assertEquals(1, new GNUCPPHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testGNUCC1HashHelloWorld2xSize() {
        assertEquals(1, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testHashCodeHashHelloWorld2xSize() {
        assertEquals(3, new HashCodeHash(2 * DEFAULT_SIZE).hash("Hello World!"));
    }

    @Test
    public void testETHHashArthurDent2xSize() {
        assertEquals(4, new ETHHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testGNUCPPHashArthurDent2xSize() {
        assertEquals(4, new GNUCPPHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testGNUCC1HashArthurDent2xSize() {
        assertEquals(0, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testHashCodeHashArthurDent2xSize() {
        assertEquals(3, new HashCodeHash(2 * DEFAULT_SIZE).hash("Arthur Dent"));
    }

    @Test
    public void testETHHashFortyTwo2xSize() {
        assertEquals(2, new ETHHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }

    @Test
    public void testGNUCPPHashFortyTwo2xSize() {
        assertEquals(3, new GNUCPPHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }

    @Test
    public void testGNUCC1HashFortyTwo2xSize() {
        assertEquals(6, new GNUCC1Hash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }

    @Test
    public void testHashCodeHashFortyTwo2xSize() {
        assertEquals(6, new HashCodeHash(2 * DEFAULT_SIZE).hash("FortyTwo"));
    }

    @Test
    public void testEmpty() {
        String[][] data = {};
        String[][] data2 = {};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testOneColumn() {
        String[][] data = {{"d"}, {"a"}, {"e"}, {"b"}, {"g"}, {"c"}, {"f"}};
        String[][] data2 = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testMixed() {
        String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data2 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data3 = {{"ccc", "bbb"}, {"aaa", "ddd"}};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
        Solution.stableSort(data, 1);
        assertArrayEquals(data3, data);
    }

    @Test
    public void testEverythingOneItem() {
        MultiMap map = new MultiMap();
        map.put(1, 2);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList(2), map.get(1));
        assertFalse(map.remove(1, 3));
        assertTrue(map.remove(1, 2));
    }

}
