//Vaishnavi Patel
//AVL Tree Iterative
//Sec 004
//3/4/2020
public class AVL_Iter_Main {

    public static void main(String [] args) {
        AVL_Iter a = new AVL_Iter();
        //inserts nodes in the tree
        a.insertIter(4);
        a.insertIter(6);
        a.insertIter(10);
        a.insertIter(2);
        a.insertIter(16);
        a.insertIter(7);
        a.insertIter(12);
        a.insertIter(15);
        a.insertIter(20);
        //prints max,min,next,prev
        System.out.println("Max:"+ a.findMaxIter());
        System.out.println("Min:"+ a.findMinIter());
        System.out.println("Next of 12:"+ a.findNextIter(12));
        System.out.println("Previous of 10:"+ a.findPrevIter(10));

        a.printSorted();
        //deletes nodes from tree
        a.deleteIter(16);
        a.deleteIter(2);
        a.deleteIter(20);
        System.out.println("Max:"+ a.findMaxIter());
        a.deleteIter(12);
        a.printSorted();

    }
}
