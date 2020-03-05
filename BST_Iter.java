//Vaishnavi Patel
//Binary Search Tree Iterative
//Sec 004
//2/27/2020
public class BST_Iter {
    private int length;
    private Node root;
    private int x;
    private int traversed;
    public BST_Iter(Node n){
        this.root.dataValue = n.dataValue;
    }
    public BST_Iter() {
        root = null;
        traversed = 0;
    }
    public Node getRoot() {
        return root;
    }
    public int getLength() {
        return length;
    }

    public boolean isNull(Node n) {
        if(n == null)
            return true;
        else
            return false;
    }
    public int getTraversed() {
        return traversed;
    }
    public void printSorted()
    {
        printSorted(root);
        System.out.println();
    }
    private void printSorted(Node parent)
    {
        if(parent == null)
        {
            return;
        }
        printSorted(parent.left);
        System.out.print(parent.dataValue + " ");
        printSorted(parent.right);
    }
    public void deleteIter(int value){
        if (isNull(root)) {
            System.out.println("No values in the BST.");
            return ;
        }
        Node prev = null;
        Node curr = root;
        int loc = 0;
        while (true) {
            if (value < curr.dataValue) {
                if (isNull(curr.left))
                    return ;

                else {
                    prev = curr;
                    curr = curr.left;
                    loc = 1;
                }
            }
            else if(value > curr.dataValue) {
                if (isNull(curr.right))
                    return ;
                else {
                    prev = curr;
                    curr = curr.right;
                    loc = 2;
                }
            }
            else {
                if (isNull(curr.left) && isNull(curr.right)) {    //has no child nodes
                    if (loc == 0)        //if the root is being removed
                        root = null;
                    else if (loc == 1)    // Removing the left child of prev
                        prev.left = null;
                    else if (loc == 2)    // Removing the right child of prev
                        prev.right = null;
                }
                else if (isNull(curr.left) && isNull(curr.right)) {       // Only has a right child
                    if (loc == 0)
                        root = curr.right;
                    else if (loc == 1)
                        prev.left = curr.right;
                    else if (loc == 2)
                        prev.right = curr.right;
                }
                else if (isNull(curr.left) == false && isNull(curr.right)) {      // Only has a left child
                    if (loc == 0)
                        root = curr.left;
                    else if (loc == 1)
                        prev.left = curr.left;
                    else if (loc == 2)
                        prev.right = curr.left;
                }
                else {       // We have both a left and right child
                    value = findMinOfNode(curr.right);
                    curr.dataValue = value;
                    prev = curr;
                    curr = curr.right;
                    loc = 2;
                    continue;
                }
                return ;
            }
        }
    }
    public void insertIter(int value) {

        if (isNull(root)) {
            root = new Node(value);
            length++;
            return ;
        }
        Node curr = root;
        boolean flag = true;
        while(flag) {
            if (value < curr.dataValue) {
                if (isNull(curr.left))  {
                    curr.left = new Node(value);
                    length = length +1;
                    return ;
                }
                else
                    curr = curr.left;
            }
            else if (value > curr.dataValue) {
                if (isNull(curr.right)) {
                    curr.right = new Node(value);
                    length = length +1;
                    return ;
                }
                else
                    curr = curr.right;


            }
            else
                return ;
            traversed=traversed+1;
        }
    }

    public int findNextIter(int value) {
        if (isNull(root)) {
            return -1;
        }
        Node current = root;
        int smallNode = current.dataValue;
        boolean flag = true;

        while (flag) {
            if (value > current.dataValue) {
                if (isNull(current.right)) {
                    return -1;
                }
                else
                    current = current.right;
            }
            else if (value < current.dataValue) {
                smallNode = current.dataValue;
                if (isNull(current.left)) {
                    return -1;
                }
                else
                    current = current.left;
            }
            else
                break;
        }
        if (smallNode == value)
            return -1;
        if (isNull(current.right))
            return smallNode;

        current = current.right;
        while (current.left != null)
            current = current.left;

        return current.dataValue;
    }
    public int findMinIter() {
        if (isNull(this.root)) {
            return -1;
        }
        Node curr = this.root;
        while (isNull(curr.left)== false)
            curr = curr.left;
        return curr.dataValue;
    }
    public int findPrevIter(int value) {
        if (isNull(this.root)) {
            return -1;
        }
        Node curr = this.root;
        int maxprevNode = curr.dataValue;
        boolean flag = true;
        while (flag) {
            if (value > curr.dataValue) {
                maxprevNode = curr.dataValue;
                if (isNull(curr.right)){
                    return -1;
                }
                else
                    curr = curr.right;
            }
            else if (value < curr.dataValue) {
                if (isNull(curr.left)) {
                    return -1;
                }
                else
                    curr = curr.left;
            }
            else
                break;
        }
        if (maxprevNode == value) {
            return -1;
        }
        if (isNull(curr.left )) {
            return maxprevNode;
        }
        curr = curr.left;
        while (isNull(curr.right)) {
            curr = curr.right;
        }
        return curr.dataValue;
    }
    private int findMinOfNode(Node curr){
        while (isNull(curr.left ) == false)
            curr = curr.left;

        return curr.dataValue;
    }

    public int findMaxIter() {
        if (isNull(this.root)) {
            return -1;
        }
        Node curr = this.root;
        while (isNull(curr.right)==false)
            curr = curr.right;
        return curr.dataValue;
    }
}
