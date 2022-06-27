package problems.medium;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    /***
     * 138. Copy List with Random Pointer
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     */
    //<oldNode, newNode>
    HashMap<Node, Node> nodes = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node oldNode = head;
        Node newNode = new Node(head.val);
        nodes.put(oldNode, newNode);

        while(oldNode!=null){

            newNode.next = getCloned(oldNode.next);
            newNode.random = getCloned(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next; //newNode.next был создан 2 строчки выше и уже существует

        }

        return nodes.get(head);
    }

    private Node getCloned(Node node){
        if(node == null) return null;

        if(nodes.containsKey(node)){
            return nodes.get(node);
        }else{
            nodes.put(node, new Node(node.val, null, null));
            return nodes.get(node);
        }

    }
}
/*
 * Основная идея задачи - мы будем создавать линки this.next по мере продвижения по nodes
 * И также мы будем создавать линки на this.random (Они не будут сами по себе болтаться в воздухе, к ним же будет линк От другого node)

 * И те и другие могут уже существовать (мы их создали на предыдущих шагах), тогда мы из извлечем из HashMap
 * Или не существовать, тогда мы их создадим, и поместим в HashMap
 */