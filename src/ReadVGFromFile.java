// Java Program to illustrate reading from Text File 
// using Scanner Class 
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
// https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
// http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
// https://www.javatpoint.com/java-string-to-int

import java.io.File;
import java.util.Date;
import java.util.Scanner; 
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class ReadVGFromFile {

	/**
	 * 
	 * @param filename	String	holds path name of file to be read
	 * @return			int[]	returns an integer array holding all the data that was read
	 * 							from the file
	 * @throws Exception		things could go wrong - missing file, index out of bounds, etc
	 */
	public static VideoGame[] readFile(String filename)	throws Exception {	

		// Retrieve number of lines from file
		int noOfLines = 0;		
		// https://www.baeldung.com/java-file-number-of-lines
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
	        noOfLines = (int) fileStream.count();	
	    }
		
		// Instantiate a data array of exactly the correct size
		VideoGame[] arr = new VideoGame[noOfLines];
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
			String name = "";
			Date date = null;
			int rating = -1;
			try {
				name = tokens[4];
				//date format gotten from https://howtodoinjava.com/java/date-time/date-validation/
				date = new SimpleDateFormat("dd/MM/yyyy").parse(tokens[0]);
				rating = Integer.parseInt(tokens[2]);
			} catch (Exception e)	{
				// do nothing
			}
			
			// Store data in array
			try	{
				//4 == name
				//0 == years old
				//2 == to rating
				arr[curIndex] = new VideoGame(name, (date.getYear() + 1900), rating);
				
				curIndex++;
			} catch (Exception e)	{
				System.out.println("Something went wrong when adding to array");
			}
		}
		
		// Return the data array
		return arr;
	}
	
}
