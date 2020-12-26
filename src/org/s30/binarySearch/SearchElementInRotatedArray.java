package org.s30.binarySearch;

public class SearchElementInRotatedArray {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            // to check whether left side is sorted
            else if(nums[low]<= nums[mid]){
                if(nums[low]<=target && nums[mid]>target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            // to check whether right side is sorted
            else if(nums[mid]<= nums[high]){
                if(nums[mid]<target && nums[high]>=target)
                    low = mid +1;
                else
                    high = mid-1;
            }     
        }
        return -1;
    }
}
