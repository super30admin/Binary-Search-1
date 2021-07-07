package com.ds.rani.algo;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchRotatedSortedArray {

    //Time complexity:o(log n)
    //Space complexity:o(1)
    /**
     * Search element target in rotated sorted array
     * @param nums array of integers
     * @param target value to be searched in an array
     * @return index of the element if exist else return -1;
     */
    public static int search(int[] nums, int target) {
        //array: 5,6,7,1,2,3,4,  target=1
        //index  0 1 2 3 4 5 6
        int left=0;
        int right=nums.length-1;

        while(left<=right) {
            int mid = (right + left) / 2;

            //check whether number is at mid
            if (nums[mid] == target)
                return mid;

            //Check if first part is sorted
            if (nums[left] <= nums[mid]) {
                //check whtjer target>= nums[left] && target<nums[mid]
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //check whether second part is sorted
            }
            if (nums[mid] <=nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
         target=3;
        System.out.println(search(nums,target));
    }
}
