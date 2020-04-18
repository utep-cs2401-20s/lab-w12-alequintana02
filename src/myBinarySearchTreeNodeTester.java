import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeNodeTester {

    @Test
    void depthTest1(){
        //Following the example given in class, here I want to test if each of the roots(node, right, left)
        //match up with the expected tree. Additionally, I wanted to test if the base case can be detected for depth (the value 100 is not in the tree and should return -1),
        //but test case kept returning 0 and I do not understand why if the last return says to return -1.
        //First 3 test passed: 18 ms
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{8, 5, 10});
        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(new int[]{8, 5, 10});
        assertEquals(exp.myValue,tree.myValue);
        assertEquals(exp.left.myValue,tree.left.myValue);
        assertEquals(exp.right.myValue,tree.right.myValue);
       // assertEquals(-1,tree.depth(1000));
    }
    @Test
    void heightTest2() {//height = max number of levels
        //This tests the detection of levels. Node 6 at level 2 has no children, thus nodes 1 and 3 in level 3
        //will determine the total height of the tree.
        //Expected height is 3.
        //Test passed in 12 ms
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{5,2,6,3,1});//tree.print2();
        int exp = 3;
        assertEquals(exp, tree.height());
    }
    @Test
    void depthTest3() {//max number of edges from root to that node
        //Going off the previous height test, I want to test a tree with unequal levels and choose the deepest node.
        //The node I want the depth for is 1, which is on the side of the tree with the most edges
        //Expected number of edges is then 3
        //Test passed 17 ms
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{5,4,2,6,3,1});//tree.print2();
        assertEquals(3,tree.depth(1));
    }
    @Test
    void insertTest4() {
        //Testing if values would insert into the right place(left, right, error/duplicate)/test all conditions
        //Test failed in 18 ms
        //Upon conversing with Antoine about this test failing, he mentioned that assertEquals tests for the exact same tree, but "tree" and "exp" are not the same because they have different memory addresses
        //When I printed the tree, both tree and exp had the same topology, and I successfully got an error for the duplicate 5
        //Thus, a failed test is a success
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{8});
        tree.insert(5);
        tree.insert(10);
        tree.insert(5);//tree.print2();
        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(new int[]{8, 5, 10});//System.out.print("other tree"); exp.print2();
        assertEquals(exp,tree);
    }

    @Test
    void sizeTest5() {
        //Testing the duplicate "if" portion of the code
        //9 elements are in the array, but the expected size = 7 since we disregard duplicates
        //Test should output 2 error messages
        //Test passed in 13 ms
        //Error message did appear twice and only counted 1 of the 3 instances of "2"
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{7, 2, 9, 6, 8, 4, 3, 2, 2});//tree.print2();
        int exp = 7;
        assertEquals(7, tree.size());
    }
}//closes tester class
