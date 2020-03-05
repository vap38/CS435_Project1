//Vaishnavi Patel
//Binary Search Tree Iterative Main
//Sec 004
//2/27/2020
public class BST_Iter_Main {
    public static void main(String[] args){

        BST_Iter tree = new BST_Iter();
        tree.insertIter(22);
        tree.insertIter(4);
        tree.insertIter(400);
        tree.deleteIter(22);
        tree.printSorted();
        tree.insertIter(8);
        tree.insertIter(14);
        tree.insertIter(2);
        tree.insertIter(13);
        tree.insertIter(10);
        tree.insertIter(1);
        tree.insertIter(18);
        System.out.println("Max: "+tree.findMaxIter());
        System.out.println("Min: "+tree.findMinIter());
        System.out.println("Prev of 10: "+tree.findPrevIter(10));
        System.out.println("Next of 11: "+tree.findNextIter(1));
        tree.deleteIter(14);
        tree.deleteIter(11);
        tree.deleteIter(8);
        tree.deleteIter(18);
        tree.printSorted();
    }
}
