
/** The Driver class includes a main() method which calls the sorting methods and determines
 * how much time it takes to sort
 * 
 * @author 	Sue Fitzgerald
 * 			10/13/20
 *
 */
public class Driver {
	public static void main (String[] args)	{
		
//		assert false;
		int data[] = null;
		
		try	{
			data = ReadFromFileClass.readFile ("protests.txt");
		} catch (Exception e)	{
			System.out.println("Something went wrong while reading the file\n"+e);
		}
		
		// Decide how many items to sort
		int numToSort = 25000;  // All 35,000+ causes stack overflow on my computer
		long begin = System.currentTimeMillis(); 	// start time	
		// quickSort(integer array, starting index, ending index)
		Sorter.quickSort (data, 0, numToSort-1);
		long end = System.currentTimeMillis(); 		// end time
		// Display elapsed time
		System.out.println("Size: " + numToSort + "\tTime in ms: " + (end-begin));	

		// Make sure the list is correctly sorted
		// You must enable asserts for this test to work.  
		// See D2L - Content | Programming Assignments | Program 1 Stuff and Assert | Asserts
		for (int i=0; i < numToSort-1; i++)	{			
			// System.out.println(data[i]);
			assert (data[i] <= data[i+1]);
		}	
	}
}
