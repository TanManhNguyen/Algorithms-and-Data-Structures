package Endterm20182019B;

import java.util.*;

class LibraryTree {
    private int key;
    private List<LibraryTree> children;

    public LibraryTree(int key) {
        this.key = key;
        children = new ArrayList<>();
    }

    public LibraryTree(int key, List<LibraryTree> children) {
        this.key = key;
        this.children = children;
    }

    public int getKey() {
        return this.key;
    }

    public List<LibraryTree> getChildren() {
        return this.children;
    }
}

