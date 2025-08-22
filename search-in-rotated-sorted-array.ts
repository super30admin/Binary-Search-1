// Time complexity- lon(n), where n = size of the input array
// Space complexity- O(1)
function search(nums: number[], target: number): number {
	let low = 0;
	let high = nums.length - 1;

	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		if (nums[mid] === target) return mid;
		else if (nums[low] <= nums[mid]) {
			// left side is sorted
			if (nums[low] <= target && nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		} else {
			// right side is sorted
			if (nums[high] >= target && target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	}

	return -1;
}
