public class QuickSort {

    //Part 1 a) QUICKSORT
    public int[] quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
        return arr;
    }

    //Part 1 b) QUICKSORT variant that returns without sorting below a threshold k
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
            quickSortThreeWay(arr, low, pivotIndex[1]);
            quickSortThreeWay(arr, pivotIndex[0], high);
        }
        return arr;
    }


    //Part 1 b) INSERTION-SORT 
    public void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
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
    public int[] partitionThreeWay(int[] arr, int low, int high) {
        int ltPivot = low - 1;
        int gtPivot = high;
        int p = low-1;
        int q = high;
        int pivot = arr[high];
        while(true) {
            //Starting on the left, find the firt element greater or equal than the pivot
            while(arr[++ltPivot]<pivot);
            //Starting on the right, find the firt element smaller or equal than the pivot
            while(pivot<arr[--gtPivot]){
                if(gtPivot==low){
                    break;
                }
            }
            //If the two pivots cross then terminate
            if(ltPivot>=gtPivot){
                break;
            }
            //Swap so smaller goes on the left, larger on the right
            swap(arr, ltPivot,gtPivot);
            //Move all the same occurences of the pivot to the beginning of the array and keep count using p
            if(arr[ltPivot]==pivot){
                p++;
                swap(arr, ltPivot, p);
            }
            //Move all the same occurences of the pivot to the end of the array and keep count using q
            if(arr[gtPivot]==pivot){
                q--;
                swap(arr, q, gtPivot);
            }
        }
        //Move pivot element to correct position
        swap(arr, ltPivot, high);

        //Move all same occurences (on left side) to adjacent arr[i]
        gtPivot = ltPivot-1;
        for(int r=low; r<p; r++){
            swap(arr, r, gtPivot);
        }
        //Move all same occurences (on right side) to adjacent arr[i]
        ltPivot += 1;
        for(int r=high-1; r>q; r++, ltPivot--){
            swap(arr, ltPivot, r);
        }
        return new int[] {ltPivot, gtPivot};
    }
    

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
