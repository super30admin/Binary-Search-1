import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aditya Sinha
 *
 */
//we will follow 2 stack approach, one for storing original value, another for maintaining min value
//Space Complexity : O(1)
//Time Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
public class SearchSortedUnknownLength {

	public int search(int[] reader, int target) {
        int low = 0, high = 1;

        while(reader[high] < target){ 
            low = high ;
            high = high * 2;
        }

        while(low <= high){ 
            int mid = low + (high - low)/2;
            if(reader[mid] == target) return mid;
            if(reader[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
      
        return -1;
    }
}

class SearchSortedUnknownLengthMain {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 try {
	            System.out.print("Enter integers separated by spaces: ");
	            String line = br.readLine(); // Read the entire line

	            String[] stringNumbers = line.split(" "); // Split by space

	            int[] intArray = new int[stringNumbers.length]; // Create int array

	            for (int i = 0; i < stringNumbers.length; i++) {
	                intArray[i] = Integer.parseInt(stringNumbers[i]); // Parse to int
	            }

	            SearchSortedUnknownLength ssul = new SearchSortedUnknownLength();
	            
	            System.out.println("target is at index - " + ssul.search(intArray, 2));

	        } catch (IOException e) {
	            System.err.println("Error reading input: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid number format in input: " + e.getMessage());
	        } finally {
	            try {
	                if (br != null) {
	                    br.close(); // Close the reader
	                }
	            } catch (IOException e) {
	                System.err.println("Error closing reader: " + e.getMessage());
	            }
	        }
	}
}
