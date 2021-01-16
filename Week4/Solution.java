package Week4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {


    /**
     * @param arr - array of integers to be sorted.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            int b = i - 1;
            while (b >= 0 && arr[b] > a) {
                arr[b + 1] = arr[b];
                b--;
            }
            arr[b + 1] = a;
        }
    }

    /**
     * @param elements Array of integers to be sorted.
     */
    public static void selectionSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++)
                if (elements[j] < elements[min]) min = j;
            swap(elements, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param elements Array of integers to be sorted.
     * @return New array of sorted integers.
     */
    public static int[] mergeSort(int[] elements) {
        if (elements == null) return null;
        if (elements.length <= 1) return elements;


        int leftSize = elements.length / 2;
        int rightSize = elements.length - leftSize;

        //unnecessary we're allowed to use Arrays class
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < left.length; i++)
            left[i] = elements[i];
        for (int i = 0; i < right.length; i++)
            right[i] = elements[leftSize + i];

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return null;
        if (arr1 == null && arr2 != null) return arr2.clone();
        if (arr1 != null && arr2 == null) return arr1.clone();

        int l, r, i;
        l = r = i = 0;
        int[] res = new int[arr1.length + arr2.length];

        while (l < arr1.length && r < arr2.length) {
            if (arr1[l] <= arr2[r]) res[i++] = arr1[l++];
            else if (arr1[l] > arr2[r]) res[i++] = arr2[r++];
        }
        while (l < arr1.length)
            res[i++] = arr1[l++];
        while (r < arr2.length)
            res[i++] = arr2[r++];

        return res;
    }

    /**
     * @param queue1 first sorted Queue to be merged
     * @param queue2 second sorted Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     */
    public static MyQueue<Integer> merge(MyQueue<Integer> queue1, MyQueue<Integer> queue2) {
        if (queue1 == null && queue2 == null) return null;
        if (queue1 != null && queue2 == null) return copyQueue(queue1);
        if (queue1 == null && queue2 != null) return copyQueue(queue2);

        MyQueue<Integer> res = new MyQueue<Integer>();
        MyQueue<Integer> left = copyQueue(queue1);
        MyQueue<Integer> right = copyQueue(queue2);

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.front() < right.front()) res.enqueue(right.dequeue());
            else if (left.front() >= right.front()) res.enqueue(left.dequeue());
        }
        while (!left.isEmpty())
            res.enqueue(left.dequeue());
        while (!right.isEmpty())
            res.enqueue(right.dequeue());

        return res;
    }

    private static <T> MyQueue<T> copyQueue(MyQueue<T> queue) {
        MyQueue<T> res = new MyQueue<>();
        MyQueue<T> tempQueue = new MyQueue<>();

        while (!queue.isEmpty()) {
            T temp = queue.dequeue();
            res.enqueue(temp);
            tempQueue.enqueue(temp);
        }
        while (!tempQueue.isEmpty())
            queue.enqueue(tempQueue.dequeue());

        return res;
    }

    public static MyQueue<Lawyer> sortingSomeLawyer(MyQueue<Lawyer> queue1) {
        if (queue1 == null) return null;
        if (queue1.size() <= 1) return queue1;

        MyQueue<Lawyer> queue = copyQueue(queue1);
        MyQueue<Lawyer> left = new MyQueue<>();
        MyQueue<Lawyer> right = new MyQueue<>();
        int n = queue.size();

        for (int i = 0; i < n / 2; i++)
            left.enqueue(queue.dequeue());
        for (int i = 0; i < n - n / 2; i++)
            right.enqueue(queue.dequeue());

        left = sortingSomeLawyer(left);
        right = sortingSomeLawyer(right);

        //cleaner with three while loops but Im too lazy to fix it look at other examples of mergesort to see what I mean
        while (!left.isEmpty() || !right.isEmpty()) {
            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.front().getHourlyWage() > right.front().getHourlyWage()) {
                    queue.enqueue(left.dequeue());
                    continue;
                }
                if (left.front().getHourlyWage() < right.front().getHourlyWage()) {
                    queue.enqueue(right.dequeue());
                    continue;
                }
                if (left.front().getHourlyWage() == right.front().getHourlyWage()) {

                    if (left.front().getTotalIncome() >= right.front().getTotalIncome()) {
                        queue.enqueue(left.dequeue());
                        continue;
                    }
                    if (left.front().getTotalIncome() < right.front().getTotalIncome()) {
                        queue.enqueue(right.dequeue());
                        continue;
                    }

                }
            } else if (!left.isEmpty()) {
                queue.enqueue(left.dequeue());
                continue;

            } else if (!right.isEmpty()) {
                queue.enqueue(right.dequeue());
                continue;
            }
        }

        return queue;
    }

    /**
     * Takes a list and returns a new list sorted in descending order.
     * This is done by using the priority queue `queue`.
     * <p>
     * Return null if list is null.
     *
     * @param list the array that needs to be sorted.
     */
    public static List<Integer> pqSort(List<Integer> list) {
        if (list == null) return null;
        if (list.size() == 0) return new ArrayList<>();

        LibraryPQ queue = new SolutionPQ();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
            queue.insert(list.get(i));
        for (int i = 0; i < list.size(); i++)
            res.add(queue.removeMax());

        return res;
    }

    /**
     * Computes how fast the given tasks can be finished by the given amount of TAs.
     *
     * @param durations Array containing the duration for each tasks.
     * @param n         Amount of TAs to complete the tasks.
     * @return The shortest time in which all tasks can be completed.
     */
    public static int completeTasks(int[] durations, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < durations.length; i++) {
            if (n == queue.size()) {
                int t = queue.poll();
                queue.add((durations[i] + t));
                continue;
            }
            queue.add(durations[i]);
        }
        int res = 0;
        while (!queue.isEmpty())
            res = queue.poll();

        return res;
    }

    /**
     * @param elements
     *     Array of integers to be sorted.
     */
    public static void quickSort(int[] elements) {
        quickSortHelp(elements, 0, elements.length - 1);
    }

    public static void quickSortHelp(int[] arr, int a, int b) {
        if(a >= b) return;
        int l = a;
        int r = b - 1;
        int pivot = arr[b];

        while(l <= r) {
            while(l <= r && arr[l] < pivot) l++;
            while(l <= r && arr[r] > pivot) r--;
            if(l <= r) {
                int temp = arr[l]; arr[l] = arr[r]; arr[r] = temp;
                l++; r--;
            }
        }

        int temp = arr[l]; arr[l] = arr[b]; arr[b] = temp;
        quickSortHelp(arr, a, l - 1);
        quickSortHelp(arr, l + 1, b);
    }
}

class SolutionPQ extends LibraryPQ {
    /**
     * Restores the heap property in a heap represented as an arraylist.
     * The method compares the node to its parent and swaps if necessary.
     *
     * @param i
     *     index of the node
     */
    @Override
    public void upHeap(int i) {
        if(i < 1) {
            return;
        }

        int parent = (i-1) / 2;
        if(super.getInHeap(parent) < super.getInHeap(i)) {
            super.swap(parent, i);
            upHeap(parent);
        }
    }
}








