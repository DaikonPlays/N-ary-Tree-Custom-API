/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * File description: 
 * Custome testers for the N-ary. I included
 * a few of my own tests for extra measures.
 */
 
import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;


/**
 * class containing all tests/
 * Instance variable:
 * completeTree: calls the n-ary tree
 */
public class CSE12NaryTreeTester<E> {
    CSE12NaryTree<Integer> completeTree;
    /**
     * tests add when there are only root children in 5-ary tree
     */
    @Test
    public void testAdd(){
        completeTree = new CSE12NaryTree<>(5);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child1 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child2 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child3 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child4 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child5 = this.completeTree.new Node(1);
        CSE12NaryTree<Integer>.Node testnode = this.completeTree.new Node(10);
        completeTree.root = root;
        completeTree.root.addChild(child1);
        completeTree.root.addChild(child2);        
        completeTree.root.addChild(child3);
        completeTree.root.addChild(child4);
        completeTree.root.addChild(child5);
        completeTree.add(10);
        assertTrue(completeTree.contains(10));
        assertEquals(testnode.data, completeTree.root.children.get(0).children.get(0).data);
    }

    /**
     * tests contains when the element is not present in a 5 ary tree
     */
    @Test
    public void testContains(){
        completeTree = new CSE12NaryTree<>(5);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        completeTree.root = root;  
        assertFalse(completeTree.contains(10));
    }

    /**
    * tests sort tree when there is only the root node in a 5-ary tree
    */
    @Test
    public void testSortTree(){
        completeTree = new CSE12NaryTree<>(5);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        completeTree.root = root;
        completeTree.sortTree();
        assertEquals(root.data, completeTree.sortTree().get(0));
        assertEquals(1, completeTree.sortTree().size());
    }

    /**
     * tests add when there are tons of duplicates and lot bigger
     */
    @Test
    public void testCustom(){
        completeTree = new CSE12NaryTree<>(3);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child1 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child2 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child3 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child4 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child5 = this.completeTree.new Node(1);
        CSE12NaryTree<Integer>.Node child6 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child7 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child8 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child9 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child10 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child11 = this.completeTree.new Node(10);
        CSE12NaryTree<Integer>.Node child12 = this.completeTree.new Node(10);

        completeTree.root = root;
        completeTree.root.addChild(child1);
        completeTree.root.addChild(child2);
        completeTree.root.addChild(child3);
        completeTree.root.children.get(0).addChild(child4);
        completeTree.root.children.get(0).addChild(child5);
        completeTree.root.children.get(0).addChild(child6);
        completeTree.root.children.get(1).addChild(child7);
        completeTree.root.children.get(1).addChild(child8);
        completeTree.root.children.get(1).addChild(child9);
        completeTree.root.children.get(2).addChild(child10);
        completeTree.root.children.get(2).addChild(child11);
        completeTree.root.children.get(2).addChild(child12);
        completeTree.add(7);
    }
    /**
     * tests add with a ton of nodes 
     */
    @Test
    public void testCustom1(){
        completeTree = new CSE12NaryTree<>(2);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child1 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child2 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child3 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child4 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child5 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child6 = this.completeTree.new Node(1);
        CSE12NaryTree<Integer>.Node child7 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child8 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child9 = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child10 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child11 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child12 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child13 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child14 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child15 = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child16 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child17 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node test = this.completeTree.new Node(4);
        completeTree.root = root;
        completeTree.root.addChild(child1);
        completeTree.root.addChild(child2);
        completeTree.root.children.get(0).addChild(child3);
        completeTree.root.children.get(0).addChild(child4);
        completeTree.root.children.get(1).addChild(child5);
        completeTree.root.children.get(1).addChild(child6);
        completeTree.root.children.get(0).children.get(0).addChild(child7);
        completeTree.root.children.get(0).children.get(0).addChild(child8);
        completeTree.root.children.get(0).children.get(1).addChild(child9);
        completeTree.root.children.get(0).children.get(1).addChild(child10);
        completeTree.root.children.get(1).children.get(0).addChild(child11);
        completeTree.root.children.get(1).children.get(0).addChild(child12);
        completeTree.root.children.get(1).children.get(1).addChild(child13);
        completeTree.root.children.get(1).children.get(1).addChild(child14);

        completeTree.root.children.get(0).children.get(0).children.get(0).addChild(child15);
        completeTree.root.children.get(0).children.get(0).children.get(0).addChild(child16);
        completeTree.root.children.get(0).children.get(0).children.get(1).addChild(child17);
        completeTree.add(4);
        assertEquals(test.data, completeTree.root.children.get(0).children.get(0).children.get(1).children.get(1).data);
    }
    /**
     * tests sortTree with unsorted tree
     */
    @Test
    public void testCustom2(){
        completeTree = new CSE12NaryTree<>(2);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child1 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child2 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child3 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child4 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child5 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child6 = this.completeTree.new Node(1);
        completeTree.root = root;
        completeTree.root.addChild(child1);
        completeTree.root.addChild(child2);
        completeTree.root.addChild(child3);
        completeTree.root.children.get(0).addChild(child4);
        completeTree.root.children.get(0).addChild(child5);
        completeTree.root.children.get(0).addChild(child6);
        completeTree.sortTree();
    }
}

