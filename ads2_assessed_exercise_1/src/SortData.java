import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Part 1
public class SortData {

    static String filePath = "ads2_assessed_exercise_1/data/";
    static String fileName = "dutch.txt";
    
    static QuickSort quick = new QuickSort();
    static SortingAlgorithms sort = new SortingAlgorithms();
    
    

public static void main(String[] args) throws Exception {

    int[] originaFile = readArray(filePath + fileName);

    int r = originaFile.length-1;

    //QUICKSORT
    int[] quickSortFile = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeQuickSort = System.currentTimeMillis();
    quick.quickSort(quickSortFile, 0, r);
    long endTimeQuickSort = System.currentTimeMillis();
    System.out.println("QUICKSORT: " + (endTimeQuickSort - startTimeQuickSort) + " ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(quickSortFile));

    // QUICK SORT WITH INSERTION
    int[] quickSortWithInsertionList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeQuickSortWithInsertion = System.currentTimeMillis(); 
    quick.quickSortWithInsertion(quickSortWithInsertionList, 0, r, 500);
    long endTimeQuickSortWithInsertion = System.currentTimeMillis();
    System.out.println("QUICKSORT-WITH-INSERTION: " + (endTimeQuickSortWithInsertion - startTimeQuickSortWithInsertion + "ms with k at 500 for " + fileName));
    System.out.println("Is sorted: " + isSorted(quickSortWithInsertionList));

    //3-WAY-QUICKSORT
    int[] quickSortThreeWayList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeQuickSortThreeWay = System.currentTimeMillis();
    quick.quickSortThreeWay(quickSortThreeWayList, 0, r);
    long endTimeQuickSortThreeWay = System.currentTimeMillis();
    System.out.println("3-WAY-QUICKSORT: " + (endTimeQuickSortThreeWay - startTimeQuickSortThreeWay) + "ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(quickSortThreeWayList));

    //INSERTION-SORT
    int[] insertionSortList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeInsertionSort = System.currentTimeMillis();
    //Part 2, setting an appropriate cut-off time
    while(System.currentTimeMillis() < startTimeInsertionSort+5000){
        sort.insertionSort(insertionSortList, 0, r);
    }
    long endTimeInsertionSort = System.currentTimeMillis();
    System.out.println("Insertion Sort: " + (endTimeInsertionSort - startTimeInsertionSort) + "ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(insertionSortList));

    //SHELL-SORT
    int[] shellSortList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeShellSort = System.currentTimeMillis();
    sort.shellSort(shellSortList);
    long endTimeShellSort = System.currentTimeMillis();
    System.out.println("Shell Sort: " + (endTimeShellSort - startTimeShellSort) + "ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(shellSortList));

    //SELECTION-SORT
    int[] selectionSortList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeSelectionSort = System.currentTimeMillis();
    //Part 2, setting an appropriate cut-off time
    while(System.currentTimeMillis()<startTimeSelectionSort+5000){
        sort.selectionSort(selectionSortList);
    }
    long endTimeSelectionSort = System.currentTimeMillis();
    System.out.println("Selection Sort: " + (endTimeSelectionSort - startTimeSelectionSort) + "ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(selectionSortList));


    //MERGE-SORT
    int[] mergeSortList = Arrays.copyOf(originaFile, originaFile.length);
    long startTimeMergeSort = System.currentTimeMillis();
    sort.mergeSort(mergeSortList, 0, r);
    long endTimeMergeSort = System.currentTimeMillis();
    System.out.println("Merge Sort: " + (endTimeMergeSort - startTimeMergeSort) + "ms for " + fileName);
    System.out.println("Is sorted: " + isSorted(mergeSortList));

}

public static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }
    return true;
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
    } }
}
