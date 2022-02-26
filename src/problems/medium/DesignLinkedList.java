package problems.medium;

public class DesignLinkedList {
    /***
     * #707.Design Linked List
     * https://leetcode.com/problems/design-linked-list/
     */

    /**
     * Note: head and tail не имеют индекса, имеют val=0
     * Важно в таких заданиях, имплементируя void функции всегда тестировать их какими-то другими, иначе потом можно долго дебагить
     Например чередовать "addAtHead", "get" потом "addAtIndex", "get" и тд
     */
    class MyLinkedList {
        int size;
        Node head;
        Node tail;

        public MyLinkedList() {
            this.size = 0;
            this.head = new Node(0);
            this.tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index > this.size - 1) {
                return -1;
            } else {
                Node res = head;
                int i = -1;
                while (i < index) {
                    res = res.next;
                    i++;
                }
                return res.val;
            }
        }

        public void addAtHead(int val) {
            Node previous = head;
            Node next = head.next;
            Node current = new Node(val);
            previous.next = current;
            current.prev = previous;
            current.next = next;
            next.prev = current;
            size++;
        }

        public void addAtTail(int val) {
            Node next = tail;
            Node previous = tail.prev;
            Node current = new Node(val);
            previous.next = current;
            current.prev = previous;
            current.next = next;
            next.prev = current;
            size++;
        }

        /*
         * Simply find the previous and the next nodes and insert (!!!!) <---------------
         */
        public void addAtIndex(int index, int val) {
            if (index > this.size) {
                return;
            } else {
                Node previous = head;
                int i = 0;
                while (i < index) {
                    previous = previous.next;
                    i++;
                }

                Node nextNode = index == this.size ? tail : previous.next;
                Node current = new Node(val);
                previous.next = current;
                current.prev = previous;

                nextNode.prev = current;
                current.next = nextNode;


            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index > this.size - 1) {
                return;
            } else {
                Node previous = head;
                int i = 0;
                while (i < index) {
                    previous = previous.next;
                    i++;
                }

                Node nextNode = index == this.size - 1 ? tail : previous.next.next;// <-----
                previous.next = nextNode;
                nextNode.prev = previous;
            }


            size--;
        }

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
