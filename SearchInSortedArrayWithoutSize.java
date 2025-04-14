// Have to perform Binary Search on a custom sized array since length of array is not known
// start with 1st element and the increase the range by a multiple: 2 or 4;
// call binary search on this sub-array; if the array goes out of bounds, catch the exception and resize the array
// Time complexity: O(log n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No





public class SearchInSortedArrayWithoutSize {

	    public static int getSubArray(int array[], int key) {
	        int start = 1; 
	        int end = 2; 

	        end = getValidEndIndex(array, start, end);

	        while (array[end] < key) {
	            int tempEnd = end + (end - start + 1) * 2; 
	            start = end + 1; 
	            end = getValidEndIndex(array, start, tempEnd); 
	            if(tempEnd > end) { 
	                break;
	            }
	        }

	        return binarySearch(array, start, end, key);
	    }

	  
	    public static int binarySearch(int array[], int start, int end, int key) {
	        while (start <= end) {
	            int mid = (start + end) >>> 1;
	            if (key == array[mid]) { 
	                return mid;          
	            }
	            if (key <= array[mid]) { 
	                end = mid - 1; 
	            } else {
	                start = mid + 1;  
	            }
	        }
	        return -1;
	    }

	   
	    public static int getValidEndIndex(int array[], int start, int end) {
	        try {
	            int value = array[end]; 
	            return end;  
	        } catch(ArrayIndexOutOfBoundsException e) {
	            if(end > start && end >= 1) {   
	                end -= 1;  
	                return getValidEndIndex(array, start, end); 
	            }
	            else {
	                return end; 
	            }
	        
	    }
	}

}
