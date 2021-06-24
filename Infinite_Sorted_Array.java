//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// Q - Suppose you are given a sorted array of unknown length and a number to search for, return the index of the number. 
//     Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. 
//     If it isn’t present, return -1. 
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Need to read more about in build functions. Took help to solve this.

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 100;
        while(start <= end) {
            if(reader.get(end) == 2147483647) {
                end --;
            } else if(reader.get(end) == target) {
                return end;
            } else if(reader.get(end) < target) {
                start = end + 1;
                end = end + 101;
            } else {
                end --;
            }
        }
        
        return -1;
    }
}
