public class QuickSort extends SortingAlgorithms {

    //Part 1 c)
    static int gtPivot = 0; 
    static int ltPivot = 0;

    //Part 1 a) QUICKSORT
    public int[] quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
        return arr;
    }

    //Part 1 b) QUICKSORT variant that return s without sorting below a threshold k
    // Then uses INSERTION-SORT to sort the entire nearly sorted array.
    public int[] quickSortWithInsertion(int[] arr, int low, int high, int k) {
        if (low < high) {
            if (high-low <= k) {
                insertionSort(arr, low, high);
            } else {
                int pivot = partition(arr, low, high);
                quickSortWithInsertion(arr, low, pivot-1, k);
                quickSortWithInsertion(arr, pivot+1, high, k);
            }
        }
        return arr;
    }

    //Part 1 c) 3-WAY-QUICKSORT
    public int[] quickSortThreeWay(int[] arr, int low, int high) {
        if (low < high) {
            int[] pivotIndex = partitionThreeWay(arr, low, high);
            quickSortThreeWay(arr, low, pivotIndex[0]);
            quickSortThreeWay(arr, pivotIndex[1], high);
        }
        return arr;
    }

    //Part 1 a) PARTITION
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    //Part 1 c) PARTITION for 3-WAY-QUICKSORT
    public int[] partitionThreeWay(int arr[], int low, int high) {

        gtPivot = low - 1; ltPivot = high;
        int p = low - 1, q = high;
        int pivot = arr[high];
    
        while (true)
        {
        //Centre to Left, find the firt element greater or equal than the pivot
            while (arr[++gtPivot] < pivot);
    
            //Centre to Right, find the firt element smaller or equal than the pivot
            while (pivot < arr[--ltPivot]){
                if (ltPivot == low){
                    break;
                }
            }
            //If the two pivots cross then terminate
            if (gtPivot >= ltPivot){
                break;
            }
    
            //Swap so smaller goes on the left, larger on the right
            swap(arr,gtPivot,ltPivot);
    
            ///Move all the same occurences of the pivot to the beginning of the array and keep count using p
            if (arr[gtPivot] == pivot){
                p++;
                swap(arr, gtPivot, p);
            }
    
            //Move all the same occurences of the pivot to the end of the array and keep count using q
            if (arr[ltPivot] == pivot){
                q--;
                swap(arr, ltPivot, q);
            }
        }
    
        //Move pivot element to correct position
        swap(arr, gtPivot, high);
    
        //Move all same occurences (on left side) to adjacent arr[i]
        ltPivot = gtPivot - 1;
        for (int r=low; r<p; r++, ltPivot--){
            swap(arr, r, ltPivot);
        }
    
       //Move all same occurences (on right side) to adjacent arr[i]
        gtPivot = gtPivot + 1;
        for (int r=high - 1; r>q; r--, gtPivot++){
            swap(arr, gtPivot, r);
        }

        return new int[] {ltPivot, gtPivot};
    }
}
