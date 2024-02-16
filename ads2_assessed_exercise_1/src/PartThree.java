import java.util.Arrays;

//Part 3
public class PartThree extends QuickSort {

    static PartThree partThreeA = new PartThree();
    static PartThree partThreeB = new PartThree();

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 2, 4, 2};
        int i = 3;

        int[] result = partThreeA.findLargestElements(arr, i);
        int[] quickResult = partThreeB.quickFindLargestElements(arr, i);

        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Result using Quick Select: " + Arrays.toString(quickResult));
    }

    //Part 3  a) 
    public int[] findLargestElements(int[] arr, int i) {
        // Sort the array in descending order using Merge Sort
        int[] descArr = partThreeA.mergeSort(arr, 0, arr.length - 1);
        int index = 0;
        for (int j : descArr) {
            if (i >= j) {
                break;
            }
            index++;
        }
        // Extract the first i elements
        int[] result = Arrays.copyOfRange(descArr, 0, index);
        
        return result;
    }

    //Part 3 b) Implementing QUICK-SELECT
    public int[] quickFindLargestElements(int[] arr, int i) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        quickSelect(copy, i, 0, copy.length - 1);
        System.out.println(Arrays.toString(copy));
        int index = 0;
        for (int j : copy) {
            if (i < j ) {
                break;
            }
            index++;
        }
        int[] result = Arrays.copyOfRange(copy, index, copy.length);
        return result;
    }

    public void quickSelect(int[] arr, int i, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
    
            if (i < (high - pivotIndex + 1)) {
                // Explore the right partition
                quickSelect(arr, i, pivotIndex + 1, high);
            } else if (i > (high - pivotIndex + 1)) {
                // Explore the left partition
                quickSelect(arr, i - (high - pivotIndex + 1), low, pivotIndex - 1);
            }
        }
    }

    //Part 3 b) Overriding partition method to go in reverse order
    @Override
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    //Part 3 a) Overriding merge method to produce reverse order 
    @Override
    public void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (left[i] >= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
