// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : struggled with "=" sign in first while loop


// Your code here along with comments explaining your approach
// find the pivot element first. it will be largest element of the array
// now check if target is greater than last element. this will tell if element is before or after pivot
// now use binary search to find target in that part

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length-1;
        int last = nums[r];
        while(l<=r){
            int mid = (r-l)/2 + l;
            if(nums[mid]>=last){
                l = mid+1;
            } else {
                r= mid-1;
            }
        }
        if(nums[nums.length-1] == target){
            return nums.length-1;
        } else
        if(nums[nums.length-1]>target){
            r = nums.length-1;
        } else {
            r = l-1;
            l = 0;
        }
        
        //System.out.println(l + " " + r);
         while(l<=r){
            int mid = (r-l)/2 + l;
            //System.out.println(mid);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]> target){
                r= mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}