// This algorithm uses the concept of dividing the whole search space into two parts. One is sorted and another is unsorted. We check for the sorted part and check if the target lies in that range. If not we move to another. Same with the second part. It works on o(logn) complexity
class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]==target) return mid;
            if(nums[i]<=nums[mid]) {
                if(target>=nums[i] && target<nums[mid]) {
                    j=mid-1;
                } else {
                    i=mid+1;
                }
            } else if(nums[mid]<=nums[j]) {
                if(target>nums[mid] && target<=nums[j]) {
                    i=mid+1;
                } else {
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}
