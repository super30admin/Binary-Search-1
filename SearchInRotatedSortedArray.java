package BinarySearch1;

//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Intuition here is, when we find a mid point in the rotated sorted array one half of the array is always sorted since its rotated array.
//So, check always if target is greater than low and less than mid pointer OR less than high and greater than mid.
//then repeatedly do the binary search algorithm and return the index of the element to be searched if found.


public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		
		int result = searchInRotatedSortedArray(nums,target);
		
		System.out.println(result);
	}

	private static int searchInRotatedSortedArray(int[] nums, int target) {
		// TODO Auto-generated method stub
		
		int result = 0;
		int n = nums.length;
		int low = 0;
		int high = n-1;
		int mid = 0;

		while(low<=high) {
			mid = low + (high-low)/2;
			 
			if(nums[mid] == target) {
				result = mid;
				return result;
			}else if(nums[mid] >= nums[low]) {
				if(target < nums[mid] && target >= nums[low] ) {
					high = mid -1;
				}else {
					low = mid +1;
				}
			}else if(nums[mid] < nums[high]){
				if(target > nums[mid] && target <= nums[high] ) {
					low = mid+1;
				}else {
					high = mid-1;
				}				
			}
		}
		
		return -1;
	}

}
