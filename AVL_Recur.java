//Vaishnavi Patel
//AVL Tree Recursive
//Sec 004
//3/4/2020
public class AVL_Recur {
    public AVL_Recur() {  //Constructor
        this.root = null;
    }
    public Node getRoot() {       //returns root
        return this.root;
    }
    public int getlength() { //Returns Length of tree
        return length;
    }
    public boolean find(int value) {  //boolean method, searches if a value is in AVL Tree
        return findHelper(value, this.root);
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
    //private methods because they are mostly helper methods for the recursive functions
    private boolean findHelper(int value, Node curr) {
        if (isNull(curr))
            return false;
        else if(value < curr.dataValue)
            return findHelper(value, curr.left);
        else if (value > curr.dataValue)
            return findHelper(value, curr.right);
        else
            return true;
    }
    private int getHeight(Node curr) { //returns height from specific node till the end
        if (isNull(curr))
            return 0;
        int leftHeight = getHeight(curr.left);
        int rightHeight = getHeight(curr.right);

        return 1 + Math.max(leftHeight, rightHeight);     // return one plus the greater between the left and right tree heights
    }
    private Node balancify(Node curr) {  //rebalance tree based on value of factor, returns a node,
        if (isNull(curr ))
            return null;
        curr.left = balancify(curr.left);
        curr.right = balancify(curr.right);

        int left_balancify_factor = getCurrNodeBalanceFactor(curr.left);
        int right_balancify_factor = getCurrNodeBalanceFactor(curr.right);
        int curr_node_balancify_factor = getCurrNodeBalanceFactor(curr);

        if (curr_node_balancify_factor == 2) {
            if (left_balancify_factor == -1)
                curr.left = rotateLeft(curr.left);

            curr = rotateRight(curr);
        }
        else if (curr_node_balancify_factor == -2) {
            if (right_balancify_factor == 1)
                curr.right = rotateRight(curr.right);

            curr = rotateLeft(curr);
        }
        return curr;
    }
    private int getCurrNodeBalanceFactor(Node curr) {  //returns int, get balancefactor of a specific node
        if (curr == null)
            return 0;

        return getHeight(curr.left) - getHeight(curr.right);
    }
    private Node rotateLeft(Node curr) {  //does a left rotation to the tree
        Node idxValue = curr.right;
        curr.right = idxValue.left;
        idxValue.left = curr;
        return idxValue;
    }
    private Node rotateRight(Node curr) { //does a right rotation to the tree
        Node idxValue = curr.left;
        curr.left = idxValue.right;
        idxValue.right = curr;
        return idxValue;
    }
    public void insertRec(int value) { //insert a node to tree
        // Return true on successful insertion, return false when failing to insert
        if (!find(value)){
            this.root = insertHelper(value, this.root);
            this.root = balancify(this.root);
            return;
        }
        else {
            return ;
        }
    }
    private Node insertHelper(int value, Node curr) {  //helper method for insert
        if (isNull(curr)) {
            length++;
            return new Node(value);
        }
        else if (value < curr.dataValue)
            curr.left = insertHelper(value, curr.left);
        else
            curr.right = insertHelper(value, curr.right);
        return curr;
    }
    public void deleteRec(int value) { //remove the node from tree
        if (!this.find(value))
            return ;
        this.root = deleteHelper(value, this.root);
        this.root = balancify(this.root);
        return ;
    }
    public Node deleteHelper(int value, Node curr) { //helper method for delete
        if (value > curr.dataValue){
            curr.right = deleteHelper(value, curr.right);
        }
        else if ( value ==  curr.dataValue){
            if (isNull(curr.left))
                return curr.right;
            else if (isNull(curr.left)&& isNull(curr.right))
                return null;
            else if (isNull(curr.right))
                return curr.left;
            else {
                curr.dataValue = findMin(curr.right);
                curr.right = deleteHelper(curr.dataValue, curr.right);
            }
        }
        else{
            curr.left = deleteHelper(value, curr.left);
        }
        return curr;
    }

    public int findPrevRec(int value) { //finds predecessor value of node
        int idxValue = findPrevious(value, this.root);
        if (idxValue == value)
            return -1;
        else
            return idxValue;
    }
    public int findNextRec(int value)  { //finds the succesor value of node
        int idxValue = findNext(value, this.root);
        if (idxValue == value)
            return -1;
        else
            return idxValue;
    }
    private int findNext(int value, Node curr) { //findNext helper
        if (isNull(curr))
            return -1;
        int idxValue;

        if (value < curr.dataValue){
            idxValue = findNext(value, curr.left);
        }
        else if(value > curr.dataValue) {
            idxValue = findNext(value, curr.right);
        }
        else{
            if (isNull(curr.right))
                return value;
            else
                return findMin(curr.right);
        }

        if ( (curr.dataValue < idxValue || idxValue == value) && curr.dataValue > value)
            idxValue = curr.dataValue;

        return idxValue;
    }
    private int findMax(Node curr) { //helper for findMaxRec
        if (isNull(curr.right))
            return curr.dataValue;
        else
            return findMax(curr.right);
    }
    private int findPrevious(int value, Node curr)  { //helper for findPrevRec
        if (isNull(curr ))
            return -1;

        int idxValue;
        if (value == curr.dataValue){
            if (isNull(curr.left))
                return value;
            else
                return findMax(curr.left); // The next node will be the min dataValue in the right subtree
        }
        else if (value < curr.dataValue) {
            idxValue = findPrevious(value, curr.left);
        }
        else {
            idxValue = findPrevious(value, curr.right);
        }
        if ((curr.dataValue > idxValue || idxValue == value) && curr.dataValue < value)
            idxValue = curr.dataValue;
        return idxValue;
    }
    private int findMin(Node curr) { //helper for findMinRec
        if (isNull(curr.left))
            return curr.dataValue;
        else
            return findMin(curr.left);
    }
    public int findMinRec()  {
        if (isNull(this.root)) {
            System.out.println("There are no dataValues in the AVL Tree.");
            return -1;
        }
        else{
            return findMin(this.root);
        }
    }
    public int findMaxRec()  { //finds Max value of tree
        if (isNull(this.root)) {
            System.out.println("There are no dataValues in the AVL Tree.");
            return -1;

        }
        else{
            return findMax(this.root);
        }
    }
    private boolean isNull(Node n) { //checks if a node is null, returns a boolean
        if(n == null)
            return true;
        else
            return false;
    }
    private Node root;  //instance variables
    private int length;
}
