package problems.medium;

public class DesignCircularQueue {
    /**
     * #622. Design Circular Queue
     * https://leetcode.com/problems/design-circular-queue/
     */
    class MyCircularQueue {

        private int[] queue;
        private int headIndex;
        private int currentSize;

        public MyCircularQueue(int k) {
            queue = new int[k];
            headIndex = 0;
            currentSize = 0;
        }

        public boolean enQueue(int value) {
            if(currentSize == queue.length) return false;

            int currentIndex = (headIndex + currentSize) % queue.length; //<<<<---
            queue[currentIndex] = value;
            currentSize++;
            return true;
        }
        //remove int from head
        public boolean deQueue() {
            if (currentSize == 0) return false;
            //queue[headIndex] = -1;
            headIndex = (headIndex +1) % queue.length; // <<<-----new  head
            currentSize--;
            return true;
        }

        public int Front() {
            return currentSize == 0 ? -1 : queue[headIndex];
        }

        public int Rear() {
            if (currentSize == 0) return -1;
            int tailIndex = (headIndex + currentSize - 1) % queue.length; //<<<-----
            return this.queue[tailIndex];
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == queue.length;
        }
    }
}
