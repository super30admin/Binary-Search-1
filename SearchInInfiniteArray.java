/*
## Problem2
Search in Infinite sorted array: 
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

Time complexity: O(log(n))
Space complexity: O(1) No auxilary space used to compute index
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1, ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target) ans = mid;
            if(reader.get(mid) < target) {
                left = mid + 1;
                right *= 2;
            }
            else right = mid - 1;
        }
        return ans;
    }
}