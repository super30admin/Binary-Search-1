
public class SearchUnknownLengthSortedArray {

	
		// Binary search method which takes the input array, target value to be searched, 
		//left index and right index from getLocation method
	
		 public int binarySearch(int nums[], int left, int right, int target) {
			
			 if(nums == null) return -1;
			 
			 if (right >= left) {
		        int mid = left + (right - left) / 2;
		        if (nums[mid] == target) {
		        	return mid;
		        }
		        else if (nums[mid] > target) {
		        	return binarySearch(nums, left, mid - 1, target);
		        }
		        else {
		        	right = binarySearch(nums, mid + 1, right, target);
		        }
		        
		    }
			return -1;
		}
		 
		 // This method aims at finding the range in which the target value might reside
		 int getLocation(int[] nums ,int target)  
		    { 
			 int low = 0, high = 1;
			
			 // start from low as 0 and high as low+1 i.e. 1
		         
		        int element = nums[0]; 
		        
		        // Find h to do binary search 
		        while (element < target) 
		        { 
		        	//try {
		            	
		        	// update the value of low index
		            	low = high; 
		            	
		            	// double the length of part to search the target
		            	if(2*high < nums.length-1) {
		            		high = 2*high;
		            	} 
		            	else {
		            		high = nums.length-1; 
		            	}
		                    
		            //}
		        	// catch exception if it occurs
//		        	catch (ArrayIndexOutOfBoundsException e) {
//		        		break;
//		        	}
		              
		            // update new value of element
		            element = nums[high]; 
		        }
			
		  
		        // carry out binary search with updated low and high values
		        return binarySearch(nums, low, high, target); 
		    } 
		 
		// Driver method to test the above function 
		    public static void main(String[] args)  
		    { 
		    	SearchUnknownLengthSortedArray sa = new SearchUnknownLengthSortedArray();
		    	
		    	int nums[] = new int[]{3, 5, 7, 9, 10, 90,  
                        100, 130, 140, 160, 170};
		    	int ans = sa.getLocation(nums, 100);
		       
		    	
		        if (ans==-1) 
		            System.out.println("Element not found"); 
		        else
		            System.out.println("Element found at index " + ans); 
		    }
}
