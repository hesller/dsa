package org.practicing.ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueue {
    public static void main(String[] args) {
        PriorityBlockingQueue<Student> pq = new PriorityBlockingQueue<>(2);

        pq.offer(new Student("name1", 2));
        pq.offer(new Student("name1", 5));
        pq.offer(new Student("name1", 10));
        pq.offer(new Student("name1", 7));
        pq.offer(new Student("name1", 1));

        System.out.println(Arrays.toString(pq.toArray()));
        System.out.println(pq.poll());

        System.out.println(Arrays.toString(pq.toArray()));
        System.out.println(pq.poll());
        System.out.println(Arrays.toString(pq.toArray()));
        System.out.println(pq.poll());
        System.out.println(Arrays.toString(pq.toArray()));
        System.out.println(pq.poll());
    }

    public static class Student implements Comparable<Student> {
        String name;
        Integer grade;

        Student(String name, Integer grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student o) {
            return o.grade.compareTo(this.grade);
        }

        @Override
        public String toString() {
            return this.name + " - " + this.grade;
        }
    }
}
