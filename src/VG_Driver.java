
public class VG_Driver {

public static void main (String[] args)	{

		//total length 35632
		
		//tests
		
		// size
		int n = 2000;
		int num = n;
		long start;
		long end;
		VideoGame[] arrayToBeSorted = null;  // Will hold all data read from file, size unknown
		
		//loop for all different tests with different length of num
		for(int i=1; i<=10; i++) {
			
			System.out.println("\nlength of time for: " + num);
			
			//loop for tests for particular length num
			for(int j=0; j<10; j++) {
				
				try	{
					// Read the file and return an array holding the data
					arrayToBeSorted = ReadVGFromFile.readFile ("protests.txt");
				} catch (Exception e)	{
					System.out.println("Something went wrong while reading the file\n"+e);
				}
				
				start = System.currentTimeMillis();
				VG_Sorter.quickSort(arrayToBeSorted, 0, num-1);
				//VG_Sorter.mergeSort(arrayToBeSorted, num);
				//VG_Sorter.insertionSort(arrayToBeSorted,num);
				end = System.currentTimeMillis();
				System.out.println(end - start);
				
				for (int k=0; k < num-1; k++){
					assert(arrayToBeSorted[i].compareTo(arrayToBeSorted[i+1]) <= 0);
				}
			}
			//System.out.println(arrayToBeSorted[i]);
			num = num + n;
		}
		
//		long start = System.currentTimeMillis();
//		Sorter.quickSort(arrayToBeSorted, 0, n-1);
//		long end = System.currentTimeMillis(); 
		
//		System.out.println("length of time: " + (end - start));
	}

}
