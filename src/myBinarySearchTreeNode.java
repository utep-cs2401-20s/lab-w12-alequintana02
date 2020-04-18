public class myBinarySearchTreeNode {
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;

  myBinarySearchTreeNode(int inValue) {
    myValue = inValue;
    left = null;
    right = null;
    // created a new node with empty child pointers
  }

  myBinarySearchTreeNode(int[] A) {
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    //for root
    myValue = (A[0]);
    //for all other nodes
    for (int i = 1; i < A.length; i++) {//here we do not want to include A[0] because that is the root
      insert(A[i]);
    }
  }

  public void insert(int inValue) {
    // This method takes a new integer as input and decides 
    // if it should be placed:
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken.
    if (inValue > myValue) { //insert to R
      if (right == null) {
        right = new myBinarySearchTreeNode(inValue);
      } else {
        right.insert(inValue);
      }
    }//closes big if
    else if (inValue < myValue) { //insert to left
      if (left == null) {
        left = new myBinarySearchTreeNode(inValue);
      } else {
        left.insert(inValue);
      }
    }//closes other big if
    else if (inValue == myValue) {//we cannot have node duplicates
      System.out.println("ERROR: No duplicate values allowed!");
    }
  } //closes insert method

  public int height() {
    // This method recursively calculates the height of the entire (sub)tree.
    // This method will take O(n) time
    int heightR = 0;
    int heightL = 0;
    if (left != null) {
      heightL += left.height();
    }
    if (right != null){
      heightR += right.height();
    }
    if (heightL > heightR) {
      return heightL + 1;
    } else {
      return heightR + 1;
    }
  }

  public int depth(int search) {
    // This method recursively calculates the depth of a given search value.
    // If the given value is not in the tree, this method returns -1.
    // Note that if the tree is a proper BST, this method should complete in O(log n) time.
    // Additionally, remember that the depth is the number of nodes on the path from a node to the root
    // (i.e. the number of the recursive calls).
    if (search < myValue) {
      if (left != null) {
        return left.depth(search) + 1;
      }
    }//closes big if
    if (search > myValue) {
      if (right != null) {
        return right.depth(search) + 1;
      }
    }
    if (search == myValue) {
      return 0;
    }
      return -1; // given value is not in the tree
    }

  public int size(){
// This method recursively calculates the number of nodes in the (sub)tree.
    int sum = 1; //we include the root in this count
    if (left != null) {
      sum += left.size();
    } if(right != null){
      sum += right.size();
    }
    return sum; //base case
  }

  // Utility function included so you can debug your solution. 
  /*public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }*/

  //I was having a hard time interpreting if my tree was building correctly (everything looked like it was being added to the left)
  //I asked Antoine if it was an IntelliJ issue or if my code was incorrect. He provided this print method for testing purposes
  public void print2() {
    System.out.println("==========");
    System.out.println("Root: " + myValue);

    if(left != null)
      System.out.println("Left: " + left.myValue);
    else
      System.out.println("Left: none");

    if(right != null)
      System.out.println("Right: " + right.myValue);
    else
      System.out.println("Right: none");

    if(left != null)
      left.print2();
    if(right != null)
      right.print2();
  }
} 
