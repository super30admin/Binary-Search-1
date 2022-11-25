
//Time Complexity :O(logN+logK) (LogN in finding the range and logK 
//for Binary search for the Range)

//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 

public class SearchInASortedArrayOfUnknownSize {

	 public int search(ArrayReader reader, int target) {
	       int low  = 0;
	       int high = 1;
	    
	       while(low <= high && high < Integer.MAX_VALUE){

	          int mid = low +(high - low)/2;
	         
	          int midVal =  reader.get(mid);

	         if(midVal == target)
	                    return mid;

	        else if(target < midVal){
	                    high = mid-1;
	        }
	        else{
	            low = mid+1;
	            high = high * 2;          
	        } 
	       
	       } 
	       return -1;
	    }

	class ArrayReader {
		public int get(int index) {
			return 0;
		}
	}
}
