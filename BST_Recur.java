//Vaishnavi Patel
//Binary Search Tree Recursive
//Sec 004
//2/27/2020
public class BST_Recur {
    public BST_Recur() {
        root = null;
    }
    public BST_Recur(Node n){
        this.root.dataValue = n.dataValue;
    }

    public void insertRec(int number) {
        if (this.find(number))
            return ;
        else {
            this.root = insert(number, this.root);
            return ;
        }
    }

    public void deleteRec(int number) {
        if (!this.find(number))
            return ;

        root = delete(number, this.root);
        return ;
    }
    public Node delete(int value, Node curr) {
        if (value < curr.dataValue)
            curr.left = delete(value, curr.left);
        else if (value > curr.dataValue)
            curr.right = delete(value, curr.right);
        else {    // value == curr.dataValue
            if (isNull(curr.left ) && isNull(curr.right))
                return null;
            else if (isNull(curr.left))
                return curr.right;
            else if (isNull(curr.right))
                return curr.left;
            else {
                curr.dataValue = findMin(curr.right);
                curr.right = delete(curr.dataValue, curr.right);
            }
        }
        return curr;
    }
    public int findNextRec(int value){ //throws Exception {
        int indexValue = findNext(value, this.root);
        if (indexValue == value)
            return -1;
        else
            return indexValue;
    }

    public int findPrevRec(int value) {
        int indexValue = findPrev(value, this.root);
        if (indexValue == value)
            return -1;

        else
            return indexValue;
    }

    public int findMinRec() {
        if (isNull(root)) {
            return -1;

        }
        else
            return findMin(root);
    }

    public void printSorted()
    {
        printSorted(root);
        System.out.println();
    }

    public int findMaxRec() {
        if (isNull(root)) {
            return -1;

        }
        else
            return findMax(root);
    }
    public Node getRoot() {
        return root;
    }
    public int getlength() {
        return length;
    }
    public boolean isNull(Node n) {
        if(n == null)
            return true;
        else
            return false;
    }
    public boolean find(int number) {
        return findHelper(number, root);
    }
    //private methods are mostly helper methods for the recursive methods
    private int findMax(Node curr) {
        if (isNull(curr.right))
            return curr.dataValue;
        else
            return findMax(curr.right);
    }
    private int findMin(Node curr) {
        if (isNull(curr.left))
            return curr.dataValue;
        else
            return findMin(curr.left);
    }
    private void printSorted(Node parent) {
        if(parent == null)
        {
            return;
        }
        printSorted(parent.left);
        System.out.print(parent.dataValue + " ");
        printSorted(parent.right);
    }
    private int findPrev(int value, Node curr) {
        if (isNull(curr))
            return -1;

        int index;
        if (value < curr.dataValue) {
            index = findPrev(value, curr.left);
        }
        else if (value > curr.dataValue) {
            index = findPrev(value, curr.right);
        }
        else {
            if (isNull(curr.left ))
                return value;
            else
                return findMax(curr.left);
        }
        if ((curr.dataValue > index || index == value) && curr.dataValue < value)
            index = curr.dataValue;

        return index;
    }
    private int findNext(int value, Node curr){
        if (isNull(curr))
            return -1;

        int indexValue;
        if (value < curr.dataValue) {
            indexValue = findNext(value, curr.left);
        }
        else if (value > curr.dataValue) {
            indexValue = findNext(value, curr.right);
        }
        else {
            if (isNull(curr.right))
                return value;
            else
                return findMin(curr.right);
        }
        if ((curr.dataValue < indexValue || indexValue == value) && curr.dataValue > value)
            indexValue = curr.dataValue;
        return indexValue;
    }
    private Node insert(int number, Node curr) {
        if (isNull(curr)) {
            length++;
            return new Node(number);
        } else if (number < curr.dataValue)
            curr.left = insert(number, curr.left);
        else
            curr.right = insert(number, curr.right);

        return curr;
    }
    private boolean findHelper(int number, Node curr) {
        if (isNull(curr))
            return false;
        else if (number < curr.dataValue)
            return findHelper(number, curr.left);
        else if (number > curr.dataValue)
            return findHelper(number, curr.right);
        else
            return true;
    }
    private Node root;
    private int length;
}
