
/** The Driver class includes a main() method which calls the sorting methods and determines
 * how much time it takes to sort
 * 
 * @author 	Sue Fitzgerald
 * 			10/13/20
 *
 */
public class Driver {
	public static void main (String[] args)	{
		

		//total length 35632
		
		//tests
		
		// size
		int n = 2500;
		int num = n;
		long start;
		long end;
		int[] arrayToBeSorted = null;  // Will hold all data read from file, size unknown
		
		//loop for all different tests with different length of num
		for(int i=1; i<=10; i++) {
			
			System.out.println("\nlength of time for: " + num);
			
			//loop for tests of individual length num
			for(int j=0; j<10; j++) {
				
				try	{
					// Read the file and return an array holding the data
					arrayToBeSorted = ReadFromFileClass.readFile ("protests.txt");
				} catch (Exception e)	{
					System.out.println("Something went wrong while reading the file\n"+e);
				}
				
				start = System.currentTimeMillis();
				//Sorter.quickSort(arrayToBeSorted, 0, num-1);
				//Sorter.mergeSort(arrayToBeSorted, num);
				Sorter.insertionSort(arrayToBeSorted,num);
				end = System.currentTimeMillis();
				System.out.println(end - start);
				
				
				for (int k=0; k < num-1; k++){// test that each list is sorted correctly
					assert(arrayToBeSorted[i] <= arrayToBeSorted[i+1]);
				}
			}
			
			num = num + n;
		}
		

		
//		System.out.println("length of time: " + (end - start));
	}
}
