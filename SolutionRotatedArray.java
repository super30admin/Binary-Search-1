// This algorithm performs binary search based on the fact that a rotated array will have sorted on one side and unsorted on other (for most of the cases), and checks whether target is present in the sorted range and pivots the search towards sorted or unsorted side based on availability
class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]==target) return mid;
            // Check whether first part is sorted
            if(nums[i]<=nums[mid]) {
                // Check whether target is in the first part
                if(target>=nums[i] && target<nums[mid]) {
                    // If yes move the search towards left
                    j=mid-1;
                } else {
                    // If not right
                    i=mid+1;
                }
            // Check whether second part is sorted
            } else if(nums[mid]<=nums[j]) {
                // Check whether target is in the second part
                if(target>nums[mid] && target<=nums[j]) {
                    // If yes move the search towards right
                    i=mid+1;
                } else {
                    //If not left
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}
