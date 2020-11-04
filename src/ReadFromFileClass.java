// Java Program to illustrate reading from Text File 
// using Scanner Class 
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
// https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
// http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
// https://www.javatpoint.com/java-string-to-int

import java.io.File; 
import java.util.Scanner; 
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Paths;

public class ReadFromFileClass {

	/**
	 * 
	 * @param filename	String	holds path name of file to be read
	 * @return			int[]	returns an integer array holding all the data that was read
	 * 							from the file
	 * @throws Exception		things could go wrong - missing file, index out of bounds, etc
	 */
	public static int[] readFile(String filename)	throws Exception {	

		// Retrieve number of lines from file
		int noOfLines = 0;		
		// https://www.baeldung.com/java-file-number-of-lines
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
	        noOfLines = (int) fileStream.count();	
	    }
		
		// Instantiate a data array of exactly the correct size
		int[] nums = new int[noOfLines];
		int curIndex = 0;
		
		// Open file
		File file = new File(filename); 
		// Pass the path to the file as a parameter 
		Scanner sc = new Scanner(file); 
		
		// Loop until end of file
		while (sc.hasNextLine()) {
			String line = sc.nextLine();				// Get one line of data
			// Data fields are separated by tabs
			// Split one line into 7 Strings
			String tokens[] = line.split("[\\t]+");		
			
			// tokens[0] - Date		 MM/DD/YYYY (convert from String to Date)
			// tokens[1] - Location	 String
			// tokens[2] - Attendees int (convert from String to int)
			// tokens[3] - Event	 String
			// tokens[4] - Tags		 String
			// tokens[5] - Curated	 Yes/No (String)
			// tokens[6] - Source	 URL (String)
			// tokens[7] - Total articles	int (Convert from String to int)
			
			// Convert numbers from Strings to ints.  Replace missing data (blanks) by -1
			int attendees = -1;
			int totalArticles = -1;
			try {
				attendees = Integer.parseInt(tokens[2]);
				totalArticles = Integer.parseInt(tokens[7]);
			} catch (Exception e)	{
				// do nothing
			}
			
			// Store data in array
			try	{
				nums[curIndex++] = attendees;
			} catch (Exception e)	{
				System.out.println("Something went wrong when adding to array");
			}
		}
		
		// Return the data array
		return nums;
	}
	
		
	/** This is a test program to make sure that readFile works properly
	 * 
	 * @param args
	 */
	public static void main (String[] args)    {


        int[] arrayToBeSorted = null;  // Will hold all data read from file, size unknown

        try    {
            // Read the file and return an array holding the data
            //creating integer array
            arrayToBeSorted = ReadFromFileClass.readFile ("protests.txt");
        } catch (Exception e)    {
            System.out.println("Something went wrong while reading the file\n"+e);
        }
        //Sorter.quickSort (arrayToBeSorted,0,arrayToBeSorted.length-1);

        // Report on the number of records read and print a few data items
        System.out.println ("Length: " + arrayToBeSorted.length);
        for (int i=0; i < 10; i++)
            System.out.println(arrayToBeSorted[i]);
    }
}
