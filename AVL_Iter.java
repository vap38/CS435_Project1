import java.util.LinkedList;

public class AVL_Iter {
    public AVL_Iter() {
        root = null;
        traversed = 0;
    }
    public AVL_Iter(Node n){
        this.root.dataValue = n.dataValue;
    }
    public boolean isNull(Node n) { //returns null if node is null
        if(n == null)
            return true;
        else
            return false;
    }
    public Node getRoot() { //returns root of tree
        return root;
    }
    public int getLength() {
        return length;
    }
    public int getTraversed() { //returns the levels that are traversed
        return traversed;
    }
    public boolean find(int value) { //returns true if value present in tree
        Node curr = this.root;

        while (true) { //keep traversing until you find it
            if (curr == null)
                return false;
            else if (value < curr.dataValue)
                curr = curr.left;
            else if (value > curr.dataValue)
                curr = curr.right;
            else
                return true;
        }
    }
    public void printSorted() //print inOrder traversal
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
    private int height(Node curr) { //returns the height from a node to the end of that subtree
        if (isNull(curr))
            return 0;
        LinkedList<Node> queue_nodes = new LinkedList<Node>();
        LinkedList<Node> queue2 = new LinkedList<Node>();

        int height = 0;

        queue_nodes.add(curr);

        while (!queue_nodes.isEmpty()) {
            curr = queue_nodes.removeFirst();

            if (curr.left != null)
                queue2.add(curr.left);

            if (curr.right != null)
                queue2.add(curr.right);

            if (queue_nodes.isEmpty()) {
                queue_nodes = queue2;
                height++;
                queue2 = new LinkedList<Node>();
            }
        }
        return height;
    }
    private int getNodeBalanceFactor(Node curr) {
        return height(curr.left) - height(curr.right);
    }
    private Node balancify(LinkedList<Node> stack_nodes) { //rebalances the tree, after insert,remove
        Node lastNode = null;
        while (!stack_nodes.isEmpty()) {
            Node curr = stack_nodes.removeFirst();

            if (lastNode != null){
                if (lastNode.dataValue < curr.dataValue)
                    curr.left = lastNode;
                else
                    curr.right = lastNode;
            }

            int currBF = getNodeBalanceFactor(curr);

            if (currBF == 2) {
                if (getNodeBalanceFactor(curr.left) == -1)
                    curr.left = leftRotate(curr.left);

                curr = rightRotate(curr);
            }
            else if (currBF == -2) {
                if (getNodeBalanceFactor(curr.right) == 1)
                    curr.right = rightRotate(curr.right);

                curr = leftRotate(curr);
            }
            lastNode = curr;
        }
        return lastNode;
    }
    private Node leftRotate(Node curr) { //left shifts the tree
        Node holder = curr.right;
        curr.right = holder.left;
        holder.left = curr;
        return holder;
    }
    private Node rightRotate(Node curr) { //tree is shifted right
        Node holder = curr.left;
        curr.left = holder.right;
        holder.right = curr;
        return holder;
    }
    public void insertIter(int value) { //inserts a node to tree
        if (isNull(this.root )) {
            this.root = new Node(value);
            length++;
            return ;
        }
        Node curr = this.root;
        LinkedList<Node> stack_nodes = new LinkedList<Node>();
        boolean flag = true;
        while(flag) {
            stack_nodes.addFirst(curr);
            if (value < curr.dataValue) {
                if (curr.left == null)  {
                    curr.left = new Node(value);
                    length++;
                    break;
                }
                else
                    curr = curr.left;
            }
            else if (value > curr.dataValue) {
                if (curr.right == null) {
                    curr.right = new Node(value);
                    length++;
                    //traversed=traversed+1;
                    break;
                }
                else
                    curr = curr.right;
                    //length++;
                //traversed=traversed+1;

            }
            else
                return ;
            traversed=traversed+1;
        }
        this.root = balancify(stack_nodes);
        return ;
    }
    public void deleteIter(int value){ //deletes node in a tree
        if (isNull(this.root )) {
            System.out.println("No values to delete");
            return ;
        }
        Node last = null;
        Node curr = this.root;
        LinkedList<Node> stack_nodes = new LinkedList<Node>();
        int numChild = 0;

        boolean flag = true;
        while (flag) {
            stack_nodes.addFirst(curr);
            if (value < curr.dataValue) {
                if (curr.left == null)
                    return ;

                else {
                    last = curr;
                    curr = curr.left;
                    numChild = 1;
                }
            }
            else if(value > curr.dataValue) {
                if (isNull(curr.right ))
                    return ;

                else {
                    last = curr;
                    curr = curr.right;
                    numChild = 2;
                }
            }
            else { // We are at the dataValue to remove
                if (isNull(curr.left ) && isNull(curr.right )) {		// find no children
                    if (numChild == 0)			// it will remove the root of the AVL
                        this.root = null;
                    else if (numChild == 1)		// it will remove the left child
                        last.left = null;
                    else if (numChild == 2)		// it will remove the right child
                        last.right = null;
                }
                else if (!isNull(curr.left) && isNull(curr.right)) {		// left child
                    if (numChild == 0)
                        this.root = curr.left;
                    else if (numChild == 2)
                        last.right = curr.left;
                    else if (numChild == 1)
                        last.left = curr.left;
                }
                else if (isNull(curr.left) && isNull(curr.right)) {		// right child
                    if (numChild == 0)
                        root = curr.right;
                    else if (numChild == 1)
                        last.left = curr.right;
                    else if (numChild == 2)
                        last.right = curr.right;
                }
                else {	//both a left and right child
                    value = findSmallNode(curr.right);
                    curr.dataValue = value;
                    last = curr;
                    curr = curr.right;
                    numChild = 2;
                    continue;
                }
                break;
            }
        }
        stack_nodes.removeFirst();
        this.root = balancify(stack_nodes);
        return ;

    }
    private int findSmallNode(Node curr){
        int count = curr.dataValue;
        while(!isNull(curr.left))
            curr = curr.left;
        count = curr.dataValue;
        return curr.dataValue;
    }
    public int findNextIter(int value) { //
        if (isNull(this.root )) {
            return -1;
        }
        Node curr = this.root;
        boolean flag = true;
        int minNodeNext = curr.dataValue;

        while (flag) {
            if (value > curr.dataValue) {
                if (isNull(curr.right)) {
                    return -1;
                }
                else
                    curr = curr.right;
            }
            else if (value < curr.dataValue) {
                minNodeNext = curr.dataValue;
                if (isNull(curr.left)) {
                    return -1;
                }
                else
                    curr = curr.left;
            }
            else
                break;
        }
        if (minNodeNext == value)
            return -1;
        if (isNull(curr.right))
            return minNodeNext;
        curr = curr.right;
        while (isNull(curr.left) == false)
            curr = curr.left;
        return curr.dataValue;
    }

    public int findPrevIter(int value)  {
        if (isNull(this.root )) {
            return -1;
        }
        boolean flag = true;
        Node curr = this.root;
        int maxPrevNode = curr.dataValue;
        while (flag) {
            if (value > curr.dataValue) {
                maxPrevNode = curr.dataValue;
                if (isNull(curr.right )) {
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
        if (maxPrevNode == value)
            return -1;

        if (isNull(curr.left ))
            return maxPrevNode;

        curr = curr.left;

        while (isNull(curr.right) == false)
            curr = curr.right;

        return curr.dataValue;
    }
    public int findMaxIter() { //returns the max node
        Node curr = this.root;
        if (isNull(this.root )) {

            return -1;
        }
        while (isNull(curr.right) == false)
            curr = curr.right;
        return curr.dataValue;
    }

    public int findMinIter() //returns the smallest value
    {
        Node curr = this.root;
        if (isNull(this.root )) {
            return -1;
        }
        while (isNull(curr.left))
            curr = curr.left;
        return curr.dataValue;
    }
    private Node root;
    private int length;
    private int traversed;
}
