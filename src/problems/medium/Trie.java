package problems.medium;

/***
 *
 * Leetcode #208 - MEDIUM
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 *
 * https://www.youtube.com/watch?v=giiaIofn31A
 */
class Trie {
    Node root;
    private static class Node{
        Node[] children;
        boolean isWord;
        char value;
        public Node(char c){
            this.value = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Node currentNode = this.root;
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);

            if(currentNode.children [c-'a'] == null){ //<<<------ decimal value (!!!)
                Node newNode = new Node(c);
                currentNode.children [c-'a'] = newNode;
                currentNode = newNode;
            }else{
                currentNode = currentNode.children [c-'a'];
            }
        }
        currentNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getLastNodeOfTheWord(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = getLastNodeOfTheWord(prefix);
        return node != null;
    }

    public Node getLastNodeOfTheWord(String word){
        int len = word.length();
        Node currentNode = this.root;
        for (int i = 0; i< len; i++){
            char c = word.charAt(i);
            if(currentNode.children[c - 'a'] == null){//such word does not exist on the Trie
                return null;
            }
            currentNode = currentNode.children[c - 'a'];
        }
        return currentNode;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
