// Problem 3: Search in a sorted array of unknown size

// Approach 1: Implemented Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Used brute force approach by reading all the elements using array reader,
// checking if the value is equal to the target and returning the index


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int i=0;
        while(reader.get(i)!=target)
            i++;
        if(reader.get(i)==target)
            return i;
        else return -1;
    }
}