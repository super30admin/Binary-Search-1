package demo;
//
//Time: O(logN)
//Spcae: O(1);
//LeetCode: yes


public class FindInRotatedArray {
//implementing binary search
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			//to avoid overflow;
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				if (nums[left] <= nums[mid] && nums[left] > target) { 
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {

				if (nums[right] >= nums[mid] && nums[right] < target) { 
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;

        // //brute force -- O(n)
        // for(int i=0 ; i < nums.length ; i++){
        //     if(nums[i] == target){
        //         return i;
        //     }
        // }
        //     return -1;
	}
}