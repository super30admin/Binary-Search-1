
public class SearchRSortedArray {
	
	public int search(int[] nums, int target) {
		int l=0;
		int r = nums.length;
		int pivot = findPivot(nums, l,r);
		
		if(pivot == -1) {
			return binarySearch(nums,l, r,target);
		}
		
		if(nums[0] < target) {
			return binarySearch(nums,l, pivot-1,target);
		}else {
			return binarySearch(nums,pivot+1,r,target);
		}
	}
	
	public int findPivot(int[] nums, int low, int high) {
		if (high < low)   
            return -1; 
        if (high == low)  
            return low;
        
        int mid = (low + high)/2;    
        if (mid < high && nums[mid] > nums[mid + 1]) 
            return mid; 
        if (mid > low && nums[mid] < nums[mid - 1]) 
            return (mid-1); 
        if (nums[low] >= nums[mid]) 
            return findPivot(nums, low, mid-1); 
        return findPivot(nums, mid + 1, high);
	}
	
	public int binarySearch(int[] nums, int l, int r, int target) {
		if(l>r) {
			return -1;
		}
		int mid = (l+r)/2;
        if (target == nums[mid]) 
           return mid; 
        if (target > nums[mid]) {
        	return binarySearch(nums, (mid + 1), r, target); 
        }else {
        	return binarySearch(nums, l, (mid -1), target); 
        }
	}

	public static void main(String[] args) {
		SearchRSortedArray myObj = new SearchRSortedArray();
		int[] arr = {3,4,5,1,2};
		System.out.println(myObj.search(arr, 1));
	}
}

//Time Complexity : O(logn)
//Space Complexity : O(logn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
