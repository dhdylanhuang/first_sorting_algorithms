//Part 2

import java.util.Arrays;

public class SortingAlgorithms {

    public int[] insertionSort(int[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= low && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
        return a;
    }

    public int[] shellSort(int[] a) {
        int h = 1;
        int n = a.length;

        while(h<n/3) {
            h = 3*h+1;
        }

        while(h>=1) {

            for(int i = h; i<n; i++) {

                for(int j=i; j>=h && a[j]<a[j-h]; j-=h) {
                    swap(a, j, j-h);
                }
            }
            h/=3;
        }
        return a;
    }

    public int[] selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
        return a;
    }

    public int[] mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
        return a;
    }

    public void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
    
        int[] L = Arrays.copyOfRange(A, p, p + n1);
        int[] R = Arrays.copyOfRange(A, q + 1, q + 1 + n2);
    
        int i = 0, j = 0, k = p;

        // Merge the two sorted subarrays back into the original array A
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L, if any
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
    
        // Copy remaining elements of R, if any
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
