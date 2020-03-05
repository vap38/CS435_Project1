//Vaishnavi Patel
//AVL Tree Recursive Main
//Sec 004
//3/4/2020
public class AVL_Recur_Main {
    public static void main(String[] args){

        AVL_Recur tree = new AVL_Recur();
        //inserts into tree
        tree.insertRec(20);
        tree.insertRec(4);
        tree.insertRec(8);
        tree.insertRec(10);
        tree.insertRec(24);
        tree.insertRec(11);
        tree.insertRec(8);
        tree.printSorted();
        System.out.println("Max: "+ tree.findMaxRec());
        System.out.println("Min: "+tree.findMinRec());

        tree.insertRec(1);
        System.out.println("Max: "+ tree.findMaxRec());
        System.out.println("Min: "+tree.findMinRec());

        tree.insertRec(9);
        System.out.println("Next of 11: "+tree.findNextRec(11));
        tree.printSorted();
        tree.insertRec(8);    // insert 8
        tree.insertRec(14);       // insert 14
        System.out.println("Next of 8: "+tree.findNextRec(8));
        System.out.println("Prev of 11: "+tree.findPrevRec(11));
        tree.deleteRec(2);
        tree.printSorted();
        tree.insertRec(0);    // insert 0
        tree.deleteRec(7);    // remove 7
        tree.printSorted();

    }


}
