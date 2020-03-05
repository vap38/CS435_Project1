//Vaishnavi Patel
//Binary Search Tree Recursive Main
//Sec 004
//2/27/2020
public class BST_Recur_Main {
    public static void main(String[] args){

        BST_Recur tree = new BST_Recur();
        tree.insertRec(1);
        tree.insertRec(4);
        tree.insertRec(400);
        tree.insertRec(22);
        tree.printSorted();
        System.out.println("Max: "+tree.findMaxRec());
        System.out.println("Min: "+tree.findMinRec());

        tree.insertRec(18);
        tree.insertRec(10);
        tree.insertRec(15);
        tree.insertRec(3);
        tree.insertRec(100);
        tree.insertRec(11);
        tree.insertRec(8);
        tree.deleteRec(400);
        System.out.println("Max: "+tree.findMaxRec());
        System.out.println("Min: "+tree.findMinRec());
        System.out.println("Prev: "+tree.findPrevRec(10));
        System.out.println("Next: "+tree.findNextRec(11));
        tree.deleteRec(11);
        tree.deleteRec(8);
        tree.deleteRec(18);
        tree.printSorted();
    }

}
