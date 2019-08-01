
public class SearchInRotatingArray {
	public static int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == nums[mid]) {
				return mid;
			}

			if (nums[mid] <= nums[end]) {
				
				if (target < nums[mid] || target > nums[end]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] >= nums[start]) {
				
				if (target > nums[mid] || target < nums[start]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		int index = search(nums,0);
		System.out.println(index);
	}

}
