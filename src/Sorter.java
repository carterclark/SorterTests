// Original quickSort() code found at https://www.baeldung.com/java-quicksort
// Original mergeSort() code found at https://www.baeldung.com/java-merge-sort
// Original insertionSort() code found at https://www.geeksforgeeks.org/java-program-for-insertion-sort/
public class Sorter {
	
	/**
	 * 
	 * @param arr	int array to be sorted
	 */
	public static void insertionSort(int arr[], int n){
		
        for (int i=1; i<n; ++i) 
        { 
            int key = arr[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j] > key) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
	
	/**
	 * Mergsort gets the middle index and creates 
	 * two temporary arrays l[] and r[]. The 
	 * mergeSort function is then called recursively 
	 * for both the sub-arrays:
	 * 
	 * @param a		int array to be sorted
	 * @param n		size of array 
	 */
	public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	}
	
	/**
	 * merge takes in the input and both 
	 * the sub-arrays and the starting and 
	 * end indices of both the sub arrays. 
	 * The merge function compares the elements 
	 * of both sub-arrays one by one and 
	 * places the smaller element into 
	 * the input array.
	 * 
	 * @param a		array being sorted
	 * @param l		left half of array
	 * @param r		right half of array	
	 * @param left	left midpoint
	 * @param right	right midpoint
	 */
	public static void merge(
			int[] a, int[] l, int[] r, int left, int right) {
		
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
				
			}
			
			else {
				a[k++] = r[j++];
				
			}
			
		}
		while (i < left) {
			a[k++] = l[i++];
			
		}
		while (j < right) {
			a[k++] = r[j++];
			
		}
		
	}
	
	/**
	 * Quicksort recursively organizes data into partitions, reducing the entropy of the data with
	 * each round
	 * 
	 * @param arr	array of integer data to be sorted
	 * @param begin	index of beginning of this partition
	 * @param end	index of the end of this partition
	 */
	public static void quickSort(int arr[], int begin, int end) {
	    
		// Stop when beginning index >= ending index
		if (begin < end) {
			
			// Reorganize the data into 2 parts - <= pivot and > pivot
	        int partitionIndex = partition(arr, begin, end);
	 
	        // Recursively sort each partition
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	/** 
	 * partition() reorganizes the data into two partitions - 
	 * one < the pivot and one > the pivot
	 * 
	 * @param arr	Array of data to be sorted
	 * @param begin	Index of beginning of partition
	 * @param end	Index of end of partition
	 * @return		Returns index of new pivot point
	 */
	private static int partition(int arr[], int begin, int end) {
		
		// Pivot arbitrarily chosen as last element in the array
	    int pivot = arr[end];
	    int i = (begin-1);		// partition < pivot
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {		// if element < pivot
	            i++;					// increase size of < partition
	 
	            int swapTemp = arr[i];	// swap from > partition to < partition
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    // Move pivot to end of < partition
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    // Return index of pivot
	    return i+1;
	}
	
	/** This main() method tests quickSort() with a short list of numbers
	 * 
	 * @param args		
	 */
	public static void main (String args[])	{
				
		//assert false;
		int myData[] = {10, 100, 52, 90, 40, 32, 1, 8, 200, 16, 83};
		int size = myData.length;
		System.out.println("Before");
		for (int i=0; i < size; i++){
			System.out.println(myData[i]);
		}
		
		// quickSort ( int[], starting index, ending index)
		Sorter.quickSort(myData, 0, size-1);
		Sorter.mergeSort(myData, size);
		Sorter.insertionSort(myData, size);

		System.out.println("\nAfter");
		for (int i=0; i < size; i++) {
			System.out.println(myData[i]);
		}
		
		for (int i=0; i < size-1; i++) {
			assert(myData[i] < myData[i+1]);
		}
		
	}
}
