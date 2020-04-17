import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeNodeTester {


    @Test
    void insertTest1(){
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{8, 5, 10});
        //tree.print();
        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(new int[]{8, 5, 10});
        //exp.print();
        assertEquals(exp.myValue,tree.myValue);
        assertEquals(exp.left.myValue,tree.left.myValue);
        assertEquals(exp.right.myValue,tree.right.myValue);
    }
    @Test
    void heightTest2() {
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{5,2,6,0,3,2,1,0,0});
        tree.print();
        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(new int[]{8, 5, 10});
    }
    @Test

    void depth() {
    }

    @Test
    void sizeTest5() {
        //duplicate values should result in an error
        //i want the test case to fail: expected size = 9, but if we disregard duplicates, test should output 2 error messages)
        //aka, only count 7 elements
        //test failed (as expected) in 13 ms (SUCCESS)
        // Error message did appear twice and only counted 1 of the 3 instances of "2"
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(new int[]{7, 2, 9, 6, 8, 4, 3, 2, 2});
        int exp = 9;
        //tree.print();
        assertEquals(9, tree.size());
    }
}//closes tester class
