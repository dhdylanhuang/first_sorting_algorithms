import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortData {

    static String filePath = "ads2_assessed_exercise_1/data/";
    static QuickSort test = new QuickSort();

public static void main(String[] args) throws Exception {
    //int[] testFile = new int[] {5,2,5,6,1,54,212,3,56,4,3,2,6,78,56,50,23,54,23,2};
    //int[] testFile = readArray(filePath + "Bad.txt");
    //int[] testFile = readArray(filePath + "dutch.txt");
    //int[] testFile = readArray(filePath + "int20k.txt");
    //int[] testFile = readArray(filePath + "int500k.txt");
    //int[] testFile = readArray(filePath + "int1000.txt");
    int[] testFile = readArray(filePath + "intBig.txt");
    int r = testFile.length-1;
    //System.out.println(Arrays.toString(test.quickSort(testFile, 0, length - 1)));
    //System.out.println(Arrays.toString(test.quickSortWithInsertion(testFile, 0, r, 100)));
    System.out.println(Arrays.toString(test.quickSortThreeWay(testFile, 0, r)));
}

    public static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size(); 
        int[] res = new int[n];
        for (int i = 0; i<n; i++){
            res [i] = data.get(i); 
        }
        return res; 
    }

    public static int[] readArray(String path) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(path))) {
            ArrayList<Integer> data = new ArrayList<Integer>();
            while (sc.hasNextInt()) {
                data.add(sc.nextInt()); 
            }
            return copyArray(data);
        } 
    }    
}
