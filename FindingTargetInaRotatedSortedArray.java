public class FindingTargetInaRotatedSortedArray {

	public int search(int[] nums, int target) {

		// Edge Case:
		if (nums.length == 0 || nums == null)
			return -1;

		// always make low and high pointer first and mid pointer should be in the recursive call
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2; // To avoid overflow of the integer we do this.

			// base condition and first finding which side of the array is sorted.
			if (nums[mid] == target) {
				System.out.println(mid);
				return mid;
			}
			// this implies left side of the array is sorted.
			else if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && nums[mid] >= target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// this implies right side of the array is sorted.
			else {
				if (nums[mid] <= target && nums[high] >= target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		FindingTargetInaRotatedSortedArray findingTargetInaRotatedSortedArray = new FindingTargetInaRotatedSortedArray();
		findingTargetInaRotatedSortedArray.search(nums, target);
				
	}

}
