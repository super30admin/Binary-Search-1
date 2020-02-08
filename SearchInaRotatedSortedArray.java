// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * The problem is to implement a search in O(log n) time that gives idea to use binary search
 * 1. find middle point
 * 2. if target is present at middle point return mid
 * 3. else if left subarray is sorted 
 * 			If target to be searched lies in range from arr[l] to arr[mid], recur for arr[l..mid]
 * 			else recur for a[mid+1..h]
 * 4. else if right subarray is sorted 
 * 			If target to be searched lies in range from arr[m+1] to arr[end], recur for arr[mid+1..h]
 * 			else recur for a[low..mid-1]
 */
public class SearchInaRotatedSortedArray {
	public int search(int[] nums, int target) {
		//edge cases
		if(nums == null || nums.length ==0)
			return -1;
        int start = 0, end = nums.length-1;
        int mid =0;
        while(start<= end) {
        	mid = start+(end-start)/2;
        	//return index if item found
        	if(nums[mid]== target)
        		return mid;
        	//left side of the array is sorted
        	else if(nums[start] <= nums[mid]) {
        		//target lies in left side of the array
        		if(nums[start] <= target &&  nums[mid]>target)
        			end = mid-1;
        		else 
        			start=mid+1;
        	}
        	//right side is sorted
        	else {
        		if(nums[mid] <= target && nums[end]>target)
        			start=mid+1;
        		else 
        			end=mid-1;
        	}
        }
        return -1;
    }
	public static void main(String args[]) {
		SearchInaRotatedSortedArray sArray= new SearchInaRotatedSortedArray();
		int [] nums = {4,5,6,7,0,1,2};
		System.out.println(sArray.search(nums, 0));
		System.out.println(sArray.search(nums, 3));
	}
}

