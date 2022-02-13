package problems.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    /***
     * #295. Find Median from Data Stream - HARD
     * https://leetcode.com/problems/find-median-from-data-stream/
     * Find the Median of a Number Stream (medium)
     * https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4
     *
     */


        //stores the biggest elements. E.g. [7, 8, 15]. The smallest 7 - is on the top and quickly accessible
        private PriorityQueue<Double> minHeap;
        //stores the smallest elements. E.g. [4, 2, 1]. The biggest 4 - is on the top and quickly accesible
        private PriorityQueue<Double> maxHeap;

        public MedianFinder() {
            //Min Heap - by default
            this.minHeap = new PriorityQueue<>();
            //Max Heap - with reverse comparator
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if(this.minHeap.size() == 0 || this.maxHeap.size()==0){
                this.minHeap.add(Double.valueOf(num));
            } else{
                double minHeapBiggest = minHeap.peek();
                double maxHeapSmallest = maxHeap.peek();

                if(num <maxHeapSmallest){
                    this.maxHeap.add(Double.valueOf(num));
                }else{
                    this.minHeap.add(Double.valueOf(num));
                }
            }
            //rebalance heaps if needed
            if(this.minHeap.size() - this.maxHeap.size() == 2){
                this.maxHeap.add(this.minHeap.poll());
            }else if(this.maxHeap.size()-this.minHeap.size() == 2){
                this.minHeap.add(this.maxHeap.poll());
            }


        }

        public double findMedian() {
            if(this.minHeap.size()>this.maxHeap.size()){
                return this.minHeap.peek();
            }else if(this.minHeap.size()<this.maxHeap.size()){
                return this.maxHeap.peek();
            }else{
                return (this.minHeap.peek() + this.maxHeap.peek())/2;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */



