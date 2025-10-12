
/**
 * @author Aditya Sinha
 *
 */
// rotated sorted array will have atleast one side of mid as sorted
// Space Complexity : O(1)
// Time Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class SearchRotatedSorted {
	public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) { // left sorted
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else { // right sorted
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

class SearchRotatedSortedMain {
	public static void main(String[] args) {
		SearchRotatedSorted srs = new SearchRotatedSorted();
		int[] nums = {4,5,6,7,0,1,2};
		
		System.out.println("target is at index - " + srs.search(nums, 0));
	}
	
}
