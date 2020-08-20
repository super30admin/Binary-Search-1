// Time Complexity : O(log n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No
/*
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class BinarySearchRotated {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;

        //obtain the location from where the array is rotated
        while(left<right){
            mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else   right=mid;
        }
        int start=left;
        left=0;
        right=nums.length-1;
        if(target>=nums[start] && target<=nums[right]){
            left=start;   //if target lies between the above bound update left
        }else   right=start;

        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target)   return mid;
            if(target>nums[mid])    left=mid+1;   //update the left so as to skip the elements which are not required to search
            else    right=mid-1;    //update the right so as to skip the elements which are not required to search
        }
        return -1;
    }
}
