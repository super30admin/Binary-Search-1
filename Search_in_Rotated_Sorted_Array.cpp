// Time Complexity : O(log n) 
// Space Complexity : O(3) ~ O(1) ... need to allocate 3 new variables, but its nothing but O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
*/

/*
Code explanation : 
Binary search can be used to divide array in two half - one half is sorted array and another 
half is unsorted array
Condition for searching in sorted array is simplified i.e. check if target lies between low
element and mid element and then perform sorting on it by moving mid.
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {

        if((&nums) == nullptr || nums.size()==0) return false;
        int low = 0;
        int high = nums.size()-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){
                //left side of array is sorted
                if(nums[low]<=target && target<nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                //right side of array is sorted
                if(nums[mid]<target && target<=nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
};