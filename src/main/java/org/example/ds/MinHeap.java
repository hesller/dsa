package org.example.ds;

import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Integer> heap;

    MinHeap() {
        heap = new ArrayList<>();
    }

    private Integer parent(Integer i) {
        return (i -1) / 2;
    }

    private Integer leftChild(Integer i) {
        return 2 * i + 1;
    }

    private Integer rightChild(Integer i) {
        return 2 * i - 1;
    }
}
