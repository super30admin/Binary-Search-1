package mediumProblems;

public class SearchInRotatedSortedArray {
	
	 public static int search(int[] nums, int target) {
	        
//	        int pivot = findPivot(nums, 0, nums.length-1);
//	        
//	        // If we didn't find a pivot, then  
//	       // array is not rotated at all 
//	        if(pivot == -1)
//	            return BinarySearch(nums, 0, nums.length-1, target);
//	        
//	        if(nums[pivot] == target)
//	            return pivot;
//	        
//	        if(nums[0] >= target)
//	           return BinarySearch(nums, pivot + 1, nums.length-1, target);
//	        else
//	            return BinarySearch(nums, 0, pivot -1, target);
//	        
//	    }
//	    
//	    
//	    public static int findPivot(int[] nums, int low, int high)
//	    {
//	        //checking base cases
////	         if(nums == null)
////	             return -1;
//	        
////	         if(nums.length == 1)
////	             return low;
//	        
//	        if (high < low)   
//	            return -1; 
//	        if (high == low)  
//	            return low; 
//	        
//	        int mid = (low + high)/ 2;
//	        //if pivot is around mid element
//	        if(mid < high && nums[mid] > nums[mid+1])
//	            return mid;
//	        if(mid > low && nums[mid-1] > nums[mid])
//	            return mid-1;
//	        
//	        //if not check 0th element if its greater than mid pivot exists in the left array
//	        if(nums[low] > nums[mid])
//	            return findPivot(nums, low, mid-1);
//	        return findPivot(nums, mid+1, high);
//	    }
//	    
//	    
//	    public static int BinarySearch(int[] nums, int low, int high, int target)
//	    {
//	        if (high < low) 
//	           return -1; 
//	        int mid = (low + high)/2;
//	        if(nums[mid] == target)
//	            return mid;
//	        if(nums[mid] <= target)
//	            return BinarySearch(nums, mid+1, high, target);
//	        return BinarySearch(nums, 0, mid-1, target);
//	    }
		 
		 //Define Edge cases
		    if(nums == null || nums.length ==0) 
		        return -1;
		        
		    int low = 0;
		    int high = nums.length-1;
		        
		    while(low<=high)
		    {
		        int mid = low + (high-low)/2;
		        System.out.println("Mid is: "+mid);
		        if(nums[mid] == target) return mid;
		        else if(nums[low]<=nums[mid])
		        {
		            if(nums[low] <= target && nums[mid] >= target)
		            {
		                high = mid-1;
		            }else
		            {
		                low = mid+1;
		            }
		        }else {
		        	if(nums[mid] <= target && nums[high] >= target)
		            {
		                low = mid +1;
		            }else
		            {
		                high = mid -1;
		            }
		        	
		        }
		    }   	
		   return -1;     	
	 }          
		 

	public static void main(String[] args) {
		
	       // Let us search 3 in below array 
	       int arr1[] = {4,5,6,7,8,9,10,0,1,2};
	    		  
	       int key = 7; 
	       System.out.println("Index of the element is : "
	                      + search(arr1, key));

	}

}
