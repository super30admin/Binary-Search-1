/**
 * Time Complexity : O(logn)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Was super confused as to how to divide the array as it was not sorted
 * Explanation:
 * As the array is rotated, it means when we take mid, it'll atleast be sorted on one side, 
 * So we can take that sorted side and start binarySearch on that.
 * If the element lied b/w mid and start, we will decrement end to mid -1
 * if the element lies between mid and end then we will ince start to mid + 1
 */



class SearchInRotatedArray {
        public static void main(String args[]) {
            int nums[] = {4,5,6,7,0,1,2};
            int target= 0;
            SearchInRotatedArray obj = new SearchInRotatedArray();
            int ans = obj.search(nums,target);
            System.out.println(ans);
        }
        
        public int search(int[] nums, int target) {
        int start = 0;
		int end = nums.length-1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target) return mid;
			if(nums[start] <= nums[mid]){
				if(nums[start] <= target && nums[mid] > target){
					end = mid -1;
			} else {
				start = mid +1;
			}
			} else if(target > nums[mid] && target <= nums[end]){
				start = mid +1;
			}else {
				end = mid -1;
			}
		}
		return -1;
    }
}