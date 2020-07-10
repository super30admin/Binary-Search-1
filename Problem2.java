/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

//PROBLEM - Search in a Rotated Sorted Array 
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N time.
 * 
 * The array is INFITE, so we can't use binary search as we don't know mid.
 * Approach:
 * We took two pointers - slow and fast - fast will jump twice at each iteration
 * and will move slow to fast 
 * and check if target lies within the range of slow and fast.
 * When we find that we will range do - BINARY Search
 */ 
//
//time Complexity :
// Search - LOG(N), N is the End number for the Fast pointer

// Space Complexity :
// O(1)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO, I have doubt what if fast pointer crosses the last index, will ask in class as wel.



class Solution {
    public int search(ArrayReader reader, int target) {

        int slow = 0; 
        int fast = 1; 

        while (slow < fast) {

            if (reader.get(slow) <= target && target <= reader.get(fast)) {

                // we found the range 

                return binarySearch(reader, target, slow, fast);

            } else {

                slow = fast; 
                fast = fast * 2; // double jump for faster 
            }

        }

        return -1;
    }

    private int binarySearch(ArrayReader reader, int target, int start, int end) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (reader.get(mid) == target)
            return mid;

        if (target < reader.get(mid)) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return binarySearch(reader, target, start, end);
    }
}
