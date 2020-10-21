// Original quickSort() code found at https://www.baeldung.com/java-quicksort
// Original mergeSort() code found at https://www.baeldung.com/java-merge-sort
// Original insertionSort() code found at https://www.geeksforgeeks.org/java-program-for-insertion-sort/
public class VG_Sorter {
	
	/**
	 * 
	 * @param arr	int array to be sorted
	 */
	public static void insertionSort(VideoGame arr[], int n){
		
        for (int i=1; i<n; ++i) 
        { 
        	VideoGame key = arr[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j].compareTo(key) > 0) 
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
	public static void mergeSort(VideoGame[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    VideoGame[] l = new VideoGame[mid];
	    VideoGame[] r = new VideoGame[n - mid];
	 
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
			VideoGame[] a, VideoGame[] l, VideoGame[] r, int left, int right) {
		
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i].compareTo(r[j]) <= 0) {
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
	public static void quickSort(VideoGame arr[], int begin, int end) {
	    
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
	private static int partition(VideoGame arr[], int begin, int end) {
		
		// Pivot arbitrarily chosen as last element in the array
		VideoGame pivot = arr[end];
	    int i = (begin-1);		// partition < pivot
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j].compareTo(pivot) <= 0) {		// if element < pivot
	            i++;					// increase size of < partition
	 
	            VideoGame swapTemp = arr[i];	// swap from > partition to < partition
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    // Move pivot to end of < partition
	    VideoGame swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    // Return index of pivot
	    return i+1;
	}
	
	/** This main() method tests sort methods with a short list of objects
	 * 
	 * @param args		
	 */
	public static void main (String args[])	{
		
		VideoGame gow = new VideoGame("God of War",2005,94);
		VideoGame cod4 = new VideoGame("Call of Duty 4: Modern Warfare",2007,92);
		VideoGame sims = new VideoGame("The Sims",2000,92);
		VideoGame duesx = new VideoGame("Deus Ex",2000,90);
		VideoGame diablo = new VideoGame("Diablo",1996,94);
				
		//assert false;
		VideoGame myData[] = {gow, cod4, sims, duesx, diablo};
		int size = myData.length;
		System.out.println("Before");
		for (int i=0; i < size; i++){
			System.out.println(myData[i]);
		}
		
		// quickSort ( VideoGame[], starting index, ending index)
		//VG_Sorter.quickSort(myData, 0, size-1);
		//VG_Sorter.mergeSort(myData, size);
		VG_Sorter.insertionSort(myData, size);

		System.out.println("\nAfter");
		for (int i=0; i < size; i++) {
			System.out.println(myData[i]);
		}
		
		for (int i=0; i < size-1; i++) {
			assert(myData[i].compareTo(myData[i+1]) < 0);
		}
		
	}
}
