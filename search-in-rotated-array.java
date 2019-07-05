
public class Day3_Problem1 {
	public static int search(int[] nums, int target) {
		int start = 0;
	    int end = nums.length - 1;
	    while (start < end) {
	        int mid = (start + end) / 2;
	        if (nums[mid] == target) return mid;
	        
	        if (nums[start] <= nums[mid]) {
	            if (target >= nums[start] && target < nums[mid]) {
	                end = mid - 1;
	            } else start = mid + 1;
	        } else {
	            if (target > nums[mid] && target <= nums[end]) {
	            	start = mid + 1;
	            } else end = mid - 1;
	        }
	    }
	    return nums[start] == target ? start : -1;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,8,9,1};
		int target = 9;
		System.out.println(search(arr, target));
	}

}
