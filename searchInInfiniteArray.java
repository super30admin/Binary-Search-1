class searchInSortedInfiniteArray {
	public static int search(int[] nums, int target) {
		int low = 0, high = 1;
		while (nums[high] < target) {
			low = high;
			high *= 2;
		}
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) return mid;
			if (target > nums[mid]) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,4,5,6,7,8,9,11,19};
		System.out.println(search(nums, 11));
	}
}