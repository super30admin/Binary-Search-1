// Time Complexity : O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/**
 * 1. Find mid index of the array
 * 2. Compare mid item with starting item, if starting item is less than mid item means left array is sorted.
 * 3. check target item range fits in left array. if yes do binary search on left array, otherwise search on right array.
 * 4. Compare mid item with end item, if end item is greater means right array is sorted.
 * 5. check target item range fits in right array. if yes do binary search on right array, otherwise search on left array
 */

class SolutionSearch {
    public int search(int[] nums, int target) {
        
    	int left = 0;
    	int right = nums.length-1;
    	int mid;
    	while(left<=right) {
    		mid = left + (right-left)/2;
    		if(nums[mid]==target) {
    			return mid;
    		}
    		else if (nums[left]<=nums[mid]) {
    			if(target>=nums[left] && target < nums[mid]) {
    				right = mid-1;
    			}else {
    				left=mid+1;
    			}
    		}else {
    			if(target<=nums[right] && target > nums[mid]) {
    				left = mid+1;
    			}else {
    				right=mid-1;
    			}
    		}
    	}
    	return -1;
    }
}
public class SearchRotatedsortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] {4,5,6,7,0,1,2};
		System.out.println(new SolutionSearch().search(nums, 0));
	}
}
