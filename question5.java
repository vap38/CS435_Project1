//Vaishnavi Patel
//Question 3,5, 6, 7
//Sec 004
//3/4/2020
import java.util.Random;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
public class question5 {
    public static int[] getRandomArray(int n) { //question 3
        Random r = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        int random=0;
        for (int i = 0; i < n; i++) {
            random = r.nextInt(n);
            int num = arr[i];
            arr[i] = arr[random];
            arr[random] = num;
        }
        return arr;
    }

    public static int[] getSortedArray(int n) { //question 3
        int[] arr = new int[n];
        int temp =0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
            n = n - 1;
        }
        return arr;
    }

    private static BST_Iter createIterBST(int[] inputArray) {
        BST_Iter iterBSTree = new BST_Iter();
        int numElements = inputArray.length;

        for (int i = 0; i < numElements; i++)
            iterBSTree.insertIter(inputArray[i]);

        return iterBSTree;
    }

    private static AVL_Iter createIterAVL(int[] inputArray) {
        AVL_Iter iterAVLee = new AVL_Iter();
        int numElements = inputArray.length;

        for (int i = 0; i < numElements; i++)
            iterAVLee.insertIter(inputArray[i]);

        return iterAVLee;
    }
    public static void main(String[] args) {

        int total = 10000;

        int[] sorted = getSortedArray(total);
//        for(int i=0;i<sorted.length;i++)
//            System.out.println(sorted[i]);
        System.out.println("*******Question 5A*******");
        int[] randomArr= getRandomArray(total);

        BST_Recur a = new BST_Recur(); //BST_Recursive
        int n = randomArr.length;
        for (int i = 0; i < total; i++)
            a.insertRec(randomArr[i]);

        AVL_Recur b = new AVL_Recur();   //AVL_Recursive
        for (int i = 0; i < total; i++)
            b.insertRec(randomArr[i]);

        System.out.print("*******QUESTION 5C*******");

        long startTime1 = Instant.now().toEpochMilli();
        BST_Iter c = new BST_Iter();
        for (int i = 0; i < total; i++)
            c.insertIter(randomArr[i]);
        long endTime1 = Instant.now().toEpochMilli();
        long timeElapsed1 = endTime1 - startTime1;


        long startTime2 = Instant.now().toEpochMilli();
        AVL_Iter d = new AVL_Iter();
        for (int i = 0; i < total; i++)
            d.insertIter(randomArr[i]);
        long endTime2 = Instant.now().toEpochMilli();
        long timeElapsed2 = endTime2 - startTime2;

        System.out.println("QUESTION 5C Ended");
        System.out.println();

        System.out.println("*******QUESTION 6B*******");

        System.out.println("Levels traversed by BST: " + c.getTraversed());
        System.out.println("Levels traversed by AVL: " + d.getTraversed());

        System.out.println("*******QUESTION 6C*******");

        BST_Iter e = new BST_Iter();
        for(int i =0;i<total;i++){
            e.insertIter(sorted[i]);
        }

        AVL_Iter f = new AVL_Iter();
        for(int i =0;i<total;i++){
            f.insertIter(sorted[i]);
        }
        System.out.println("*******6C Ended*******");
        //System.out.println("Levels traversed by BST: " + e.getTraversed());
        //System.out.println("Levels traversed by AVL: " + f.getTraversed());

        System.out.println();
        System.out.println("*******Question 7A*******");

        //System.out.println("Time taken by BST: " + timeElapsed1);
        //System.out.println("Time taken by AVL: " + timeElapsed2);
    }
}

        // BS Trees
