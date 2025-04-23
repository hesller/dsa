package org.practicing.ds;

import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Integer> heap;

    MinHeap() {
        heap = new ArrayList<>();

    }

    private int parentIndex(int i) {
        return (i - 1)/ 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(Integer elem) {
        heap.add(elem);
        int currIndex = heap.size() - 1;
        while (currIndex > 0 && heap.get(currIndex) < heap.get(parentIndex(currIndex)) )  {
            swap(currIndex, parentIndex(currIndex));

            currIndex = parentIndex(currIndex);
        }
    }

    private Integer getMin() {
        return heap.get(0);
    }

    private Integer extractMin() {
        Integer root = heap.get(0);

        int lastVal = heap.remove(heap.size() -1);
        heap.set(0, lastVal);
        minHeapify(0);
        return root;

    }

    private void minHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);

        int currIndex = index;

        if (left < heap.size() && heap.get(left) < heap.get(currIndex)) {
            currIndex = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(currIndex)) {
            currIndex = right;
        }

        if (currIndex != index) {
            swap(currIndex, index);
            minHeapify(currIndex);
        }
    }

    private void swap(int i, int j) {
        int parentValue = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, parentValue);
    }

    public void print() {
        for (Integer i : heap) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(10);
        minHeap.insert(2);

        minHeap.print();

        System.out.println("extracting min: " + minHeap.extractMin());
        minHeap.print();
        System.out.println("extracting min again: " + minHeap.extractMin());
        minHeap.print();
        System.out.println("extracting min again: " + minHeap.extractMin());
        minHeap.print();

        System.out.println("extracting min again: " + minHeap.extractMin());
        minHeap.print();

    }
}
