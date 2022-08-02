/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * File description: 
 * Code for a N=ary tree. Allows for 
 * each node to have N amount of children.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * class containing all methods for a functioning N-ary tree
 */
public class CSE12NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }
    /**
     * helper method to add all nodes in tree to arraylist
     * @return ArrayList of nodes in tree
     */
    private ArrayList<E> levelOrderTraversal() {
        if(root == null) {
            return null;
        }
        ArrayList<E> tree = new ArrayList<>(); 
        //creates a queue
        Queue<CSE12NaryTree<E>.Node> addQueue = new LinkedList<>();
        CSE12NaryTree<E>.Node curr = root;
        //adds the root node to the queue
        addQueue.add(curr);
        //loops until queue is empty
        while(addQueue.isEmpty() != true){
            //sets a node to the first element in the queue 
            Node nodeAdd = addQueue.poll();
            tree.add(nodeAdd.data);
            //loops to add any children from the node into the queue
            for(int j = 0; j < nodeAdd.getNumChildren(); j++) {
                addQueue.add(nodeAdd.children.get(j));
            }
        }
        return tree;
    }
    /**
     * helper method to find the depth of tree
     * @return max level
     */
    private int getLevel() {
        Node curr = root;
        int level = 0;
        //loops through until on last level
        while(curr.getNumChildren() != 0) {
            curr = curr.children.get(0);
            level++;
        }
        return level;
    }
    /**
     * helper method to get the path of input number
     * @param Ncount number to track a path for
     * @return ArrayList of the reversed path 
     */
    private ArrayList<Integer> getPath(int Ncount) {
        ArrayList<Integer> path = new ArrayList<>();
        int height = getLevel();
        //uses arithmetics to loop through tree and get path
        for(int i = 0; i < height; i++) {
            Ncount = Ncount/N;
            path.add(Ncount);
        }
        return path;
    }
    /**
     * adds the input element into the tree
     * @param element to be inserted 
     */
    public void add(E element) {
        if(element == null) {
            throw new NullPointerException();
        }
        //calls helper method
        ArrayList<E> addArrayLists = levelOrderTraversal();
        CSE12NaryTree<E>.Node addEle = new Node(element);
        CSE12NaryTree<E>.Node currcopy = root;
        int level = getLevel();
        int levelNodes = (int) Math.pow(N, level);
        int leftoverNodes = 0;
        int Ncount = 0;
        //gets currcopy to the last level
        for(int i = 0; i < level; i++) {
            currcopy = currcopy.children.get(0);
        }
        //finds where in the arraylist is the first node of the last level
        for(int i = 0; i < level; i++) {
            Ncount += Math.pow(N, i);
        }
        //gets the total nodes in the last level
        Ncount = addArrayLists.size() - Ncount;
        leftoverNodes = levelNodes - Ncount;
        //if there are no leftover nodes, add to the next level
        if(leftoverNodes == 0) {
            currcopy.addChild(addEle);
        }
        else{
        //calls getPath to get the path for the last node
        ArrayList<Integer> reversePath = getPath(Ncount);  
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = reversePath.size() - 1; i >= 0; i--) {
            path.add(reversePath.get(i));
        }
        //removes excess number
        path.remove(0);    
        currcopy = root;
        //gets to the parent node
        for(int i = 0; i < path.size(); i++) {
            currcopy = currcopy.children.get(path.get(i));
        }
        //adds child
        currcopy.addChild(addEle);
    }
        size++;
    }

    /**
     * checks if the input element is in the tree
     * @param element to check if in tree
     * @return true if found, false if not
     */
    public boolean contains(E element) {
        if(element == null) {
            throw new NullPointerException();
        }
        ArrayList<E> addArrayLists = levelOrderTraversal();
        for(int i = 0; i < addArrayLists.size(); i++) {
            //checks if the element is equal to the arraylist element at i
            if(addArrayLists.get(i) == element) {
                return true;
            }
        }
        return false;
    }
    /**
     * sorts the tree and returns it in an arraylist
     * @return the sorted arraylist
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> sortedfinArrList = new ArrayList<>();
        ArrayList<E> addArrList = levelOrderTraversal();
        //uses priority queue to create a heap
        PriorityQueue<E> prio = new PriorityQueue<E>();
        //heap sorts by adding the arraylist into the priority queue
        for(int i = 0; i < addArrList.size(); i++) {
            prio.add(addArrList.get(i));
        }
        //adds to another arraylist in ascending order
        while(prio.size() > 0) {
            sortedfinArrList.add(prio.poll());
        }
        return sortedfinArrList;
    }
}
