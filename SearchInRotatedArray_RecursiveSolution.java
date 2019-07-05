
public class SearchInRotatedArray_RecursiveSolution {
	
	public static int search (int nums[], int target) {
		return binarySearch(nums, 0, nums.length - 1, target);  // searching with extreme left and extreme right
	}

	public static int binarySearch(int nums[], int left, int right, int target) {
		
		 if(nums == null) return -1;
		 
		 if(left > right) return -1;
		 
		 int mid = left + (right - left) / 2;		// base condition 1
		 if (nums[mid] == target) {
	        	return mid;							// base condition 2
	        }
		 
		 if(nums[left] <= nums[mid]) {				// left part of array is sorted
			 
	        if (nums[left] < target && target <= nums[mid]) 
	        	{
	        	right = mid - 1;
	        	}
	        else left = mid + 1;
		 }
	     else {
		        	if(nums[mid] <= target && target < nums[right]) 
		        		{
		        		left = mid + 1;
		        		} 
		        	else right = mid - 1;
	          }
		 return binarySearch(nums, left, right, target);
	}
	
	public static void main(String[] args) {
		int nums[] = {4, 5, 6, 7, 0, 1, 2}; 
		
		//int nums[] = {0,1,2,4,5,6,7}; //sorted array.
		
		System.out.println(search(nums, 2));
	}
}
