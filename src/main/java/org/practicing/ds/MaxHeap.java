package org.practicing.ds;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap;

    MaxHeap(int capacity) {
        this.heap = new ArrayList<>(capacity);
    }

    private int getParentIndex(int index) {
        return (index / 2) - 1;
    }

    private int getLeftChild(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public void insert(Integer value) {
        heap.add(value);
        int currIndex = heap.size() - 1;

        while (getParentIndex(currIndex) >= 0 && heap.get(currIndex) > heap.get(getParentIndex(currIndex))) {
            swap(currIndex, getParentIndex(currIndex));
            currIndex = getParentIndex(currIndex);
        }
    }

    public void swap(Integer indexChild, Integer parentIndex) {
        int swappedChild = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(indexChild));
        heap.set(indexChild, swappedChild);
    }

    public Integer getMax() {
        Integer root = heap.get(0);
        int currIndex = 0;
        heap.set(currIndex, heap.remove(heap.size() - 1));
        maxify(currIndex);
        return root;
    }

    public void maxify(int currIndex) {
        int higherIndex = 0;
        if (heap.size() > getLeftChild(currIndex) && heap.get(getLeftChild(currIndex)) > heap.get(currIndex)) {
            higherIndex = getLeftChild(currIndex);
        }

        if (heap.size() > getRightChildIndex(currIndex) && heap.get(getRightChildIndex(currIndex)) > heap.get(currIndex)) {
            higherIndex = getRightChildIndex(currIndex);
        }

        if (currIndex != higherIndex) {
            swap(currIndex, higherIndex);
            maxify(currIndex);
        }
    }

    public void printout() {
        heap.forEach(System.out::println);
        System.out.println("===================");
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(3);

        maxHeap.printout();

        System.out.println("MAx Value Extracted: " + maxHeap.getMax());
        maxHeap.printout();
        System.out.println("MAx Value Extracted: " + maxHeap.getMax());
        maxHeap.printout();
        System.out.println("MAx Value Extracted: " + maxHeap.getMax());
        maxHeap.printout();
        System.out.println("MAx Value Extracted: " + maxHeap.getMax());
        maxHeap.printout();
    }
}
